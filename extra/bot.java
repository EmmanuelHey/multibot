package extra;
import java.net.*;
import java.util.*;
import java.io.*;
import com.google.gson.Gson;

public class bot {
    public static void main(String[] args) {
        // try{
            
        //     //reading the json object and then parsing it
            
        // }
        // catch (MalformedURLException e)
        // {
        //     e.printStackTrace();
        // }
        // catch (IOException f)
        // {
        //     f.printStackTrace();
        // }
        String endpoint = "http://api.openweathermap.org/data/2.5/weather?q=Austin&APPID=26aa1d90a24c98fad4beaac70ddbf274";
    }
        
}

public String getJson(String endpoint) throws Exception
{
    Gson gson = new Gson();
            
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
    }
    else
    {
        return "";
    }
    return content.toString();

}
