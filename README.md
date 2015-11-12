# Prism
Prism Coding Challenge

Deck of Cards 

I decided to create an inner class called Card within my class called Deck so that I could initialize cards 
and set the proper attributes (facevalue, value, and suit). The instiaters are private because no other class should be able to
initialize Cards except the Deck when its created. All of the methods in the Deck class are private and nonstatic because no other 
class should need to use them and each method should be called by a Deck object. There was no real ambiguity in the instructions; they were
very clear. I tested my code by writing some code in the main method that tests if the deck is being populated correctly, whether its
being shuffled correctly and throwing errors correctly. 

To see that this deck works, simply, in terminal, run

javac Deck.java 
java Deck

This will compile the code and run it to show that a Deck has been created successfully. 

--------------------------------------------------------------------------------------------------------------------------------


Traveling Salesman

To do this challenge, Google Geocoding API was used. Thus, there are some issues with running the file. I added Maven to this project through IntelliJ correctly and when I run from my IDE, everything works fine. However, when I run from terminal, I do get issues that the package is not found. I suggest running from an IDE like IntelliJ or Eclipse. These instructions might help: https://github.com/googlemaps/google-maps-services-java/. The following below is the code running in IntelliJ

(in miles)

miles or kilometers?: 
miles
Nov 12, 2015 1:07:40 PM com.google.maps.GeoApiContext getWithPath
INFO: Request: https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyAM2sw09S1GTm5Zdi4tIvmpuuQ4LBOVnFY&address=Paris%2C+France
Nov 12, 2015 1:07:41 PM com.google.maps.GeoApiContext getWithPath
INFO: Request: https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyAM2sw09S1GTm5Zdi4tIvmpuuQ4LBOVnFY&address=New+York+City%2C+USA
Nov 12, 2015 1:07:41 PM com.google.maps.GeoApiContext getWithPath
INFO: Request: https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyAM2sw09S1GTm5Zdi4tIvmpuuQ4LBOVnFY&address=New+York+City%2C+USA
Nov 12, 2015 1:07:41 PM com.google.maps.GeoApiContext getWithPath
INFO: Request: https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyAM2sw09S1GTm5Zdi4tIvmpuuQ4LBOVnFY&address=Nunuk%2C+Greenland

Paris, France -> New York City, USA: 3626.0 miles

New York City, USA -> Nunuk, Greenland: 1851.0 miles

Total distance covered in your trip: 5477.0miles

(in kilometers)

miles or kilometers?: 
kilometers
Nov 12, 2015 1:08:21 PM com.google.maps.GeoApiContext getWithPath
INFO: Request: https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyAM2sw09S1GTm5Zdi4tIvmpuuQ4LBOVnFY&address=Paris%2C+France
Nov 12, 2015 1:08:21 PM com.google.maps.GeoApiContext getWithPath
INFO: Request: https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyAM2sw09S1GTm5Zdi4tIvmpuuQ4LBOVnFY&address=New+York+City%2C+USA
Nov 12, 2015 1:08:21 PM com.google.maps.GeoApiContext getWithPath
INFO: Request: https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyAM2sw09S1GTm5Zdi4tIvmpuuQ4LBOVnFY&address=New+York+City%2C+USA
Nov 12, 2015 1:08:21 PM com.google.maps.GeoApiContext getWithPath
INFO: Request: https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyAM2sw09S1GTm5Zdi4tIvmpuuQ4LBOVnFY&address=Nunuk%2C+Greenland

Paris, France -> New York City, USA: 5836.0 kilometers

New York City, USA -> Nunuk, Greenland: 2980.0 kilometers

Total distance covered in your trip: 8816.0kilometers


I chose Java becasue I am most comfortable with that language and it has a lot of tools that are well documented. There was not that much thought that went into design because no external objects were needed for this. The only things that were necessary was being able to scan a text file and also successfully making API calls on all lines of the textfile. If I had more time, I would like to use the Google Distance Matrix API OR Direction API to optimize the route between cities. I was unable to use these APIs with success which is why I stuck with the Geocoder API. The Direction API also would tell me the best route and the cost of using that route, which would all be very useful information for a user. 





