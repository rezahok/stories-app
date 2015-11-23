package com.rongpencil.app.stories;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

public class StoriesParser {

    static final String JsonURL =  "http://stories-crawler-dev.elasticbeanstalk.com/api/stories";

    // JSON Node names
    public static final String TAG_Stories = "stories";
    public static final String TAG_Title = "title";
    public static final String TAG_PreviewImg = "previewImg";
    public static final String TAG_Summary = "summary";
    public static final String TAG_BODY = "body";
    public static final String TAG_PublishedDate = "publishedDate";

    // constructor
    public StoriesParser() {
    }

    public ArrayList<HashMap<String, String>> GetStories() {

        String jsonStr = getJsonFromUrl(JsonURL); // getting Json from URL

        // contacts JSONArray
        JSONArray stories = null;

        // Hashmap for ListView
        ArrayList<HashMap<String, String>> storiesList = new ArrayList<HashMap<String, String>>();

        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);

                // Getting JSON Array nodes
                stories = jsonObj.getJSONArray(TAG_Stories);

                // looping through All Contacts
                for (int i = 0; i < stories.length(); i++) {
                    JSONObject c = stories.getJSONObject(i);


                    // tmp hashmap for single story
                    HashMap<String, String> story = new HashMap<>();

                    // adding each child node to HashMap key => value
                    story.put(TAG_Title, c.getString(TAG_Title));
                    //story.put(TAG_Summary, c.getString(TAG_Summary));
                    //story.put(TAG_BODY,c.getString(TAG_BODY));
                    String url = c.getString(TAG_PreviewImg);
                    if(url != null) {
                        story.put(TAG_PreviewImg, url);
                    }
                    //story.put(TAG_PublishedDate, c.getString(TAG_PublishedDate));

                    // adding contact to contact list
                    storiesList.add(story);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return storiesList;
    }

    /**
     * Getting Json from URL making HTTP request
     * @param url string
     * */
    private String getJsonFromUrl(String url) {
        String json = null;

        try {
            // defaultHttpClient
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);

            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            json = EntityUtils.toString(httpEntity);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}
