package org.example.services;

import org.example.models.LatLon;
import org.example.models.WeatherObject;
import org.springframework.web.client.RestTemplate;

public class WeatherService {
    private RestTemplate template = new RestTemplate();
    private final String API_URL = "http://api.openweathermap.org/geo/1.0/zip";
    private final String API_KEY = "9ab92acde2d95a90d3235a7f832ea7b1";

    public LatLon getLatLon(String zipcode){
        //return Latlon object
        String url = API_URL + "?zip=" + zipcode + "&appid=" + API_KEY;
        return template.getForObject(url, LatLon.class);
        //what class spring is gonna convert JSON into lat, lon, and name. which is LatLon.class
    }

    public WeatherObject getWeather(LatLon latlon){
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=" +
                latlon.getLat() + "&lon=" +
                latlon.getLon() + "&units=imperial&appid=" + API_KEY;
        return template.getForObject(url, WeatherObject.class);
    }
}
