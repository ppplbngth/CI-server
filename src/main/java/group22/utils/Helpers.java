package group22.utils;
import java.io.BufferedReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import javax.servlet.http.HttpServletRequest;


/**
* This class contains helper functions for parsing and/or retrieving data from JSON formatted data in a HTTP body
*/
public class Helpers {
    
    /**
     * create JSON object of the http post request body from the webhook
     * @param request a http Post request payload
     * @return JSONObject containing the data from the webhook
     * @throws Exception if bad request
     */
    public static JSONObject convertBody(HttpServletRequest request) throws Exception{

        //read the payload line by line
        StringBuilder st = new StringBuilder();
        BufferedReader buff = request.getReader();
        String temp=buff.readLine();
        String payload="";
        while(temp!=null){
                st.append(temp);
                temp=buff.readLine();
        }
        buff.close();
        
        payload = st.toString();
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(payload);
        return json;
        
    }

    /**
     * Fetches clone url from JSONObject 
     * @param payload a JSONObject containing a webhook payload
     * @return String corresponding to the value under the "clone_url" key contained within the JSON object 
     */
    public static String getCloneUrl(JSONObject payload){
        return ((JSONObject) payload.get("repository")).get("clone_url").toString();
    }

    /**
     * Fetches the branch name from the JSONObject
     * @param payload a JSONObject containing a webhook payload
     * @return String corresponding to the value under the "ref" key contained within the JSON object 
     */
    public static String getBranch(JSONObject payload){
        return payload.get("ref").toString();
    }
    

}
