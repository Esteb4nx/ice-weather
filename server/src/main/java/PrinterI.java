import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class PrinterI implements Demo.Printer
{

    private static final String API_KEY = "a41d308e0d5a7a58009029239504a657";

    public String getWeather(String city, com.zeroc.Ice.Current current) {
            try {
                URL url = new URL("http://api.weatherapi.com/v1/current.json?key=5bb5bd81c428428ca32132623240901&q="+city+"&aqi=yes");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");

                int responseCode = con.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    String jsonStr = response.toString();

                    Demo.WeatherData data = jsonParser(jsonStr);
                    return formatWeatherData(data);

                } else {
                    return "Error en la consulta: " + responseCode;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "Error al obtener el clima";
            }
    }


    public Demo.WeatherData jsonParser(String json){

            JSONObject jsonObj = new JSONObject(json);
            JSONObject location = jsonObj.getJSONObject("location");
            JSONObject currentWeather = jsonObj.getJSONObject("current");

            // Crear y llenar WeatherData
            Demo.WeatherData weatherData = new Demo.WeatherData();
            weatherData.city = location.getString("name");
            weatherData.temperature = currentWeather.getDouble("temp_c")+"";
            weatherData.description = currentWeather.getJSONObject("condition").getString("text");
            return weatherData;

    }

    public String formatWeatherData(Demo.WeatherData weatherData) {
        return "Ciudad: "+weatherData.city+"\nTemperatura: "+weatherData.temperature+"°C\nDescripción: "+weatherData.description;
    }
}