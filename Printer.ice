module Demo {
    struct WeatherData {
        string city;
        string temperature;
        string description;
    };

    interface Printer {
        string getWeather(string city);
    }
}
