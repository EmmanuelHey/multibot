package extra;
import java.net.*;
import java.util.*;
import java.io.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class bot {

    public bot ()
    {

    }

    public void getWeather(String state)
    {
        String endPoint = "http://api.openweathermap.org/data/2.5/weather?q=";
        String appID = "&APPID=";
        String key = "26aa1d90a24c98fad4beaac70ddbf274";

        endPoint += state + appID + key;
        try
        {
            String result = getJson(endPoint + state + appID + key);
            System.out.println(result);
        }
        catch (Exception e)
        {
            //throw e;
        }
        //System.out.println(result);
    }
    
    
    public String getJson(String endpoint) throws Exception
    {
        //Gson gson = new Gson();
                
        URL url = new URL(endpoint);    

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();


        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        StringBuffer content = null;
        if (responseCode == 200)
        {
            // read the response into a StringBuffer
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            content = new StringBuffer();
            //System.out.println(content);
        }
        else
        {
            return "";
        }
        //connection.disconnect();
        
        return content.toString();
    }

}

