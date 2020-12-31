/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.netbeans.saas.yahoo;

import java.io.IOException;
import org.netbeans.saas.RestConnection;
import org.netbeans.saas.RestResponse;

/**
 * YahooTripService Service
 *
 * @author dantas
 */

public class YahooTripService {

    /** Creates a new instance of YahooTripService */
    public YahooTripService() {
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch(Throwable th) {}
    }

    /**
     *
     * @param id
     * @param output
     * @param callback
     * @return an instance of RestResponse
     */
    public static RestResponse getTrip(String id, String output, String callback) throws IOException {
        String apiKey = YahooTripServiceAuthenticator.getApiKey();
        String[][] pathParams = new String[][]{};
        String[][] queryParams = new String[][]{{"appid", "" + apiKey + ""}, {"id", id}, {"output", output}, {"callback", callback}};
        RestConnection conn = new RestConnection("http://travel.yahooapis.com/TripService/V1.1/getTrip", pathParams, queryParams);
        sleep(1000);
        return conn.get(null);
    }
}
