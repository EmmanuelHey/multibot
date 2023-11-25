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
        String endPoint = "https://api.openweathermap.org/data/2.5/weather?units=imperial&q=";
        String appID = "&APPID=";
        String key = "26aa1d90a24c98fad4beaac70ddbf274";

        endPoint += state + appID + key;
        System.out.println(endPoint);
        try
        {
            String result = getJson(endPoint);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            WeatherAPI myWeather = gson.fromJson(result, WeatherAPI.class);
            System.out.println("This is the weather at " + state + ": " + result);
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
    class WeatherAPI
    {
        private String name;
        private List<Weather> weather;
        private Main main;
        
        // name accessor and mutator
        public void setName(String n)
        {
            name = n;
        }
        public String getName()
        {
            return name;
        }
        
        // weather accessor and mutator
        public void setWeather(List<Weather> w)
        {
            weather = w;
        }
        public List<Weather> getWeather()
        {
            return weather;
        }
        
        // main accessor and mutator
        public void setMain(Main m)
        {
            main = m;
        }
        public Main getMain()
        {
            return main;
        }
    }
    class Weather
    {
        private String description;
        
        // description mutator and accessor
        public void setDescription(String d)
        {
            description = d;
        }
        public String getDescription()
        {
            return description;
        }
    }
    class Main
    {
        private double temp;
        private double feels_like;
        
        // temperature accessor and mutator
        public void setTemp(double t)
        {
            temp = t;
        }
        public double getTemp()
        {
            return temp;
        }
        
        // feels_like accessor and mutator
        public void setFeelsLike(double f)
        {
            feels_like = f;
        }
        public double getFeelsLike()
        {
            return feels_like;
        }
    }
}

