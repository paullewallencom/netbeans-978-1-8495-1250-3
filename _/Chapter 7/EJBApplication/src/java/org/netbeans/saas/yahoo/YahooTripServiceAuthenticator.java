/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.netbeans.saas.yahoo;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *
 * @author dantas 
 */
public class YahooTripServiceAuthenticator {
    
    private static String apiKey;
    
    private static final String PROP_FILE = YahooTripServiceAuthenticator.class.getSimpleName().toLowerCase() + ".properties";

    static {
        try {
            Properties props = new Properties();
            props.load(YahooTripServiceAuthenticator.class.getResourceAsStream(PROP_FILE));
            apiKey = props.getProperty("api_key");
        } catch (IOException ex) {
            Logger.getLogger(YahooTripServiceAuthenticator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getApiKey() throws IOException {
        if (apiKey == null || apiKey.length() == 0) {
            throw new IOException("Please specify your api key in the "  + PROP_FILE + " file.");
        }

        return apiKey;
    }
}