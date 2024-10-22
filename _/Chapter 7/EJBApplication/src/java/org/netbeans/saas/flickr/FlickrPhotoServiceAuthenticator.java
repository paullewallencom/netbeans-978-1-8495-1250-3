/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.netbeans.saas.flickr;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.netbeans.saas.RestConnection;

/**
 *
 * @author dantas
 */
public class FlickrPhotoServiceAuthenticator {

    private static String apiKey;
    private static String secret;
    //private static boolean readOnly = false;
    private static final String PROP_FILE = FlickrPhotoServiceAuthenticator.class.getSimpleName().toLowerCase() + ".properties";
    

    static {
        try {
            Properties props = new Properties();
            props.load(FlickrPhotoServiceAuthenticator.class.getResourceAsStream(PROP_FILE));
            apiKey = props.getProperty("api_key");
            secret = props.getProperty("secret");
        } catch (IOException ex) {
            Logger.getLogger(FlickrPhotoServiceAuthenticator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getApiKey(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (apiKey == null || apiKey.length() == 0) {
            throw new IOException("Please specify your api key and secret in the " + PROP_FILE + " file.");
        }
        return apiKey;
    }

    private static String getSecret() throws IOException {
        if (secret == null || secret.length() == 0) {
            throw new IOException("Please specify your api key and secret in the " + PROP_FILE + " file.");
        }
        return secret;
    }

    public static String getAuthToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        assert request != null;
        String authToken = (String) request.getSession().getAttribute("flickr_auth_token");

        if (authToken == null || authToken.length() == 0) {
            throw new IOException("Failed to get a valid authentication token.");
        }
        return authToken;
    }

    public static void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        assert request != null;
        assert response != null;

        HttpSession session = request.getSession(true);
        String authToken = (String) session.getAttribute("flickr_auth_token");

        // If there is already a auth token, we are already logged in. 
        // Simply return.
        if (authToken != null) {
            return;
        }

        String frob = (String) session.getAttribute("flickr_frob");

        // If there is an auth token instead of a session key, we need to 
        // obtain the session key using the auth token.  If there is no
        // auth token, we redirect to the login page.
        if (frob != null) {
            session.removeAttribute("flickr_frob");
            String apiKey = getApiKey(request, response);
            String method = "flickr.auth.getToken";
            String apiSig = sign(
                    new String[][]{
                        {"method", method},
                        {"frob", frob},
                        {"api_key", apiKey},
                    });

            RestConnection conn = new RestConnection(
                    "http://api.flickr.com/services/rest/",
                    new String[][]{
                        {"method", method},
                        {"api_key", apiKey},
                        {"api_sig", apiSig},
                        {"frob", frob}
                    });
            String result = conn.get().getDataAsString();

            try {
                authToken = result.substring(result.indexOf("<token>") + 7,
                        result.indexOf("</token>"));
                session.setAttribute("flickr_auth_token", authToken);
            } catch (Exception ex) {
                throw new IOException("Failed to get authentication token: " + result);
            }

            String returnUrl = (String) session.getAttribute("flickr_return_url");

            if (returnUrl != null) {
                session.removeAttribute("flickr_return_url");
                response.sendRedirect(returnUrl);
            }
        } else {
            session.setAttribute("flickr_return_url", request.getRequestURI());
            response.sendRedirect(request.getContextPath() + "/FlickrPhotoServiceLogin");
        }
    }

    private static void logout() {
    }

    public static String sign(String[][] params) throws IOException {
        TreeMap<String, String> map = new TreeMap<String, String>();

        for (int i = 0; i < params.length; i++) {
            String key = params[i][0];
            String value = params[i][1];

            if (value != null) {
                map.put(key, value);  
            }
        }

        String signature = getSecret();
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            signature += entry.getKey() + entry.getValue();
        }

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] sum = md.digest(signature.getBytes("UTF-8"));
            BigInteger bigInt = new BigInteger(1, sum);

            return bigInt.toString(16);
        } catch (Exception ex) {
            throw new IOException(ex.getMessage());
        }
    }
}
