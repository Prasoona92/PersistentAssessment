package org.modules;

import org.utils.ConfigFileReader;

import java.net.HttpURLConnection;
import java.net.URL;

public class FindWordinDict {

    private static final String API_URL = ConfigFileReader.getProperty("api.base.url");


    public static boolean isWordInDictionary(String word) {
        try {
            // Create the URL for the API request
            URL url = new URL(API_URL + word);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Check the response code
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) { // 200 means the word exists
                return true;
            } else if (responseCode == 404) { // 404 means the word does not exist
                return false;
            } else {
                System.out.println("Unexpected response code: " + responseCode);
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

}
