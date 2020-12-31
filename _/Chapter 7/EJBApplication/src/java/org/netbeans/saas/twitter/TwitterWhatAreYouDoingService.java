/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.netbeans.saas.twitter;

import java.io.IOException;
import org.netbeans.saas.RestConnection;
import org.netbeans.saas.RestResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TwitterWhatAreYouDoingService Service
 *
 * @author dantas
 */

public class TwitterWhatAreYouDoingService {

    /** Creates a new instance of TwitterWhatAreYouDoingService */
    public TwitterWhatAreYouDoingService() {
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch(Throwable th) {}
    }

    /**
     *
     * @param request
     * @param response
     * @param location
     * @param format
     * @return an instance of RestResponse
     */
    public static RestResponse updateLocation(HttpServletRequest request, HttpServletResponse response, String location, String format) throws IOException {
        TwitterWhatAreYouDoingServiceAuthenticator.login(request, response);
        String[][] pathParams = new String[][]{{"{format}", format}};
        String[][] queryParams = new String[][]{{"location", location}};
        RestConnection conn = new RestConnection("http://twitter.com/account/update_location.{format}", pathParams, null);
        sleep(1000);
        return conn.post(null, queryParams);
    }
}
