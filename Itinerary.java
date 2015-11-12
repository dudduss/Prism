
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import java.lang.Math;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.*;


public class Itinerary {

    static String metric;

    public static void main(String[] args) {

        ArrayList<String> cities = new ArrayList<String>();
        ArrayList<Double> distances = new ArrayList<Double>();

        //Have to change filepath to specific text filepath
        String fileName = "/Users/sampathduddu/Desktop/prism/Prism/cities.txt";
        String line = null;

        //Reading from file and appending to local List
        try {
            FileReader fileReader =
                    new FileReader(fileName);

            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                cities.add(line);
            }

            bufferedReader.close();
        }

        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");

        }


        //Asking if user wants information in miles or kilometers
        System.out.println("miles or kilometers?: ");
        Scanner scan = new Scanner(System.in);
        String metric = scan.next();
        scan.close();


        //Using Google Geocoder API to retrieve latLon of specific cities and calculating distance between those cities
        GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyAM2sw09S1GTm5Zdi4tIvmpuuQ4LBOVnFY");
        for (int i = 0; i < cities.size() - 1; i++) {
            try {
                GeocodingResult[] from = GeocodingApi.geocode(context, cities.get(i)).await();
                GeocodingResult[] to = GeocodingApi.geocode(context, cities.get(i+1)).await();
                double distance = calcDistance(from,to,metric);
                distances.add(distance);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        //Printing out distances and total distance
        double totalDistance = 0;
        for (int i = 0; i < distances.size() ; i++) {
            System.out.println(cities.get(i) + " -> " + cities.get(i+1) + ": " + distances.get(i) + " " + metric);
            totalDistance += distances.get(i);
        }
        System.out.println("Total distance covered in your trip: " + totalDistance + metric);
    }

    //Adapted from Stack Overflow
    public static int calcDistance( GeocodingResult[] from, GeocodingResult[] to,  String metric) {

        double latA = from[0].geometry.location.lat;
        double longA = from[0].geometry.location.lng;

        double latB = to[0].geometry.location.lat;
        double longB = to[0].geometry.location.lng;

        double theDistance = (Math.sin(Math.toRadians(latA)) *
                Math.sin(Math.toRadians(latB)) +
                Math.cos(Math.toRadians(latA)) *
                        Math.cos(Math.toRadians(latB)) *
                        Math.cos(Math.toRadians(longA - longB)));

        if (metric.charAt(0) == 'm') {
            return new Double((Math.toDegrees(Math.acos(theDistance))) * 69.09).intValue();
        }

        return new Double((Math.toDegrees(Math.acos(theDistance))) * 69.09 * 1.6093).intValue();

    }

}