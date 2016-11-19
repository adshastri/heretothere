#Here to There

##Brief Description

This project was created to help its users better navigate the complex Rutgers Bus System. It takes two inputs through a web app (i.e. the current location and the destination location), and it outputs the closest bus stops to the buildings as well as the appropriate bus to take.

##Detailed Description

The entire project is split into two parts: Web Application and Amazon Echo support. The web app takes the two locations the user wants to route between and it outputs the bus stop closest to the current location, the bus stop closest to the destination location and the appropriate bus code. This process is made possible through the use of Google Maps Geocoding API, which takes addresses as strings and transforms them into coordinates (latitude and longitude). From there, we use the Google Maps Distance Matrix API to directly determine which campus each location is on, and which bus stop on that campus is closest to them. In addition, the outputted text on the website is also a hyperlink to Google Maps, which gives a visual representation of the walking path the user must take. Finally, the outputted text displays the time it will take to walk from one destination to its corresponding bus stop and which bus the user must take.

The Amazon Echo support for this app performs all of the above functions. By speaking into the Amazon Echo, the project will return all the information above through speech. In addition to using Amazon Web Services, it also uses the Twilio API to send hyperlinks to Google Maps and written out directions to the user's phone, allowing for easier use of the app on the go.
