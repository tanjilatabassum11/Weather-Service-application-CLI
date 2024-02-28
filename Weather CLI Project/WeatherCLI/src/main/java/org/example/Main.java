package org.example;

import org.example.models.LatLon;
import org.example.models.WeatherObject;
import org.example.services.WeatherService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter zipcode: ");
        String zipcode = input.nextLine();

        //longitude and latitude
        WeatherService service = new WeatherService();
        LatLon latLon = service.getLatLon(zipcode);
        System.out.println("You are in " + latLon.getName());
        System.out.println("Your latitude is " + latLon.getLat() +
                " and longitude is " + latLon.getLon());

        //Current temperature
        WeatherObject weather = service.getWeather(latLon);
        System.out.println("Current temperature is " + weather.getMain().getTemp());
        System.out.println("Today's weather: " + weather.getWeather()[0].getDescription());


    }
}