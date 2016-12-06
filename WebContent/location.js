/*var asyncRequest;    
				function callServlet(){
					console.log("reached callservlet");
				    try
				    {
				        asyncRequest = new XMLHttpRequest();
				        asyncRequest.addEventListener("readystatechange", stateChange, false);
				        asyncRequest.open('POST', '/HereToThere/src/BusServlet', true); 
				        asyncRequest.setRequestHeader("stops", document.getElementById("current").value+":"+document.getElementById("destination").value);
				        asyncRequest.send();
				    }
				    catch(exception)
				   {
				    	console.log(exception);
				    alert("Request failed");
				   }
				}

				function stateChange(){
				if(asyncRequest.readyState == 4 && asyncRequest.status == 200)
				    {
				    var text = document.getElementById("text");
				    console.log(asyncRequest.responseText);
				    var answer = asyncRequest.responseText.split("|"); 
				    document.getElementById("leavingBusStop").innerHTML = answer[0];
				    //document.getElementById("left").setAttribute("onclick", "window.location='https://www.google.com/maps/dir/" + mystring2 + "/" + mystring + "/'");
				    document.getElementById("arrivingBusStop").innerHTML = answer[1];
				    document.getElementById("testOutput").innerHTML = "Take the " + answer[3] + " bus.";
				    }
				}

				window.addEventListener("load", start(), false);*/

function grab() {
    var current = document.getElementById("current").value;
    var destination = document.getElementById("destination").value;

    if (current=="" && destination==""){

    } else {

    var rutgerss = new google.maps.LatLng(40.503222, -74.4519619);
    var scott = new google.maps.LatLng(40.49957, -74.44824);
    var stuactcntr = new google.maps.LatLng(40.5039, -74.44883);
    var stuactcntr2C = new google.maps.LatLng(40.50383, -74.44885);
    var traine = new google.maps.LatLng(40.4982, -74.44511);
    var zimmerli = new google.maps.LatLng(40.4996299, -74.4450499);

    var collegeave = [rutgerss, scott, stuactcntr, traine, zimmerli];


    var lot48a = new google.maps.LatLng(40.51514, -74.46191);
    var werblinback = new google.maps.LatLng(40.5186799, -74.4614699);
    var hillw = new google.maps.LatLng(40.5219151, -74.4632567);
    var science = new google.maps.LatLng(40.523938, -74.4642213);
    var libofsci = new google.maps.LatLng(40.5262, -74.46583);
    var buschse = new google.maps.LatLng(40.5258314, -74.4587244);
    var busch = new google.maps.LatLng(40.5234, -74.45796);
    var buells = new google.maps.LatLng(40.52181, -74.4567399);
    var werblinm = new google.maps.LatLng(40.51871, -74.4599799);

    var busch = [lot48a, werblinback, hillw, science, libofsci, buschse, busch, buells, werblinm];


    var beck = new google.maps.LatLng(40.5251062, -74.4385837);
    var Livingston = new google.maps.LatLng(40.524, -74.4366299);
    var quads = new google.maps.LatLng(40.5198631, -74.4335671);

    var livingston = [beck, Livingston, quads];


    var trainn = new google.maps.LatLng(40.49768, -74.4445099);
    var rockoff = new google.maps.LatLng(40.4918304, -74.4430403);
    var pubsafs = new google.maps.LatLng(40.4870546, -74.4398732);
    var cabaret = new google.maps.LatLng(40.4842206, -74.4380994);
    var redoak = new google.maps.LatLng(40.4830599, -74.43746);
    var lipman = new google.maps.LatLng(40.48129, -74.4362699);
    var foodsci = new google.maps.LatLng(40.4789101, -74.4357138);
    var biel = new google.maps.LatLng(40.4799997, -74.4325217);
    var henders = new google.maps.LatLng(40.4809499, -74.4287199);
    var katzenbach = new google.maps.LatLng(40.48304, -74.4316);
    var gibbons = new google.maps.LatLng(40.48523, -74.43194);
    var college = new google.maps.LatLng(40.4858788, -74.4379873);
    var pubsafn = new google.maps.LatLng(40.4876282, -74.4402089);
    var liberty = new google.maps.LatLng(40.49325, -74.4434);
    var patersonn = new google.maps.LatLng(40.495286, -74.443878);

    var douglass = [trainn, rockoff, pubsafs, pubsafn, liberty, patersonn];
    var cook = [cabaret, redoak, lipman, foodsci, biel, henders, katzenbach, gibbons, college];

    var collegeAvePoint = new google.maps.LatLng(40.499632, -74.450656);
    var buschPoint = new google.maps.LatLng(40.518868, -74.459576);
    var livingstonPoint = new google.maps.LatLng(40.522865, -74.436369);
    var douglassPoint = new google.maps.LatLng(40.491985, -74.443466);
    var cookPoint = new google.maps.LatLng(40.484299, -74.435104);

    var campusPoints = [collegeAvePoint, buschPoint, livingstonPoint, douglassPoint, cookPoint];


    var stops = [rutgerss, scott, stuactcntr, traine, lot48a, werblinback, hillw, science, libofsci, buschse, busch, buells, werblinm, beck, Livingston, quads, trainn, rockoff, pubsafs, cabaret, redoak, lipman, foodsci, biel, henders, katzenbach, gibbons, college, pubsafn, liberty, patersonn, zimmerli];
    var names = ["Rutgers Student Center", "Scott Hall", "Student Activities Center", "Train Station(College Ave)", "Visitors Center", "Werblin Reacreation Center(Back Entrance)", "Hill Center", "Science Building", "Library of Sciences", "Busch Suites", "Busch Campus Center", "Buell Apartments", "Werblin Recreation Center(Main Entrance)", "Livingston Plaza", "Livingston Student Center", "Quads", "Train Station(Douglass)", "Rockoff Hall", "Public Safety Building South", "Cabaret Theater", "Red Oak Lane", "Lipman Hall", "Food Sciences Building", "Biel Road", "Henderson", "Katzenbach", "Gibbons", "College Hall", "Public Safety Building North", "Liberty Street", "Paterson Street", "Zimmerli Arts Museum"]; 
    var codes = ["rutgerss", "scott"," stuactcntr"," traine"," lot48a"," werblinback"," hillw"," science"," libofsci"," buschse"," busch"," buells"," werblinm"," beck"," Livingston"," quads"," trainn"," rockoff"," pubsafs"," cabaret"," redoak"," lipman"," foodsci"," biel"," henders"," katzenbach"," gibbons"," college"," pubsafn"," liberty"," patersonn"," zimmerli"];


    var dm = new google.maps.DistanceMatrixService();
    var gca = new google.maps.Geocoder();

    var returnValue="";

    var currentLocation;
    var destinationLocation;
    leavingGeocode(current, leavingDistanceMatrix);
    arrivingGeocode(destination, arrivingDistanceMatrix);

    function leavingGeocode(ca, callback) {
        gca.geocode({ address: ca, bounds: new google.maps.LatLngBounds(new google.maps.LatLng(40.474369, -74.495217), new google.maps.LatLng(40.547717, -74.405550))}, function(results, status) {
            if (status == 'OK') {
                currentLocation = new google.maps.LatLng(parseFloat(results[0].geometry.location.lat()), parseFloat(results[0].geometry.location.lng()));
                callback(currentLocation);
            } else {

                alert(status + ". Could not find specified address.");
            }
        });
    }

    function leavingDistanceMatrix(cl) {
        dm.getDistanceMatrix({
            origins: [cl],
            destinations: campusPoints,
            travelMode: 'WALKING',
        }, callbackLeaving);
    }

    function callbackLeaving(response, status) {
        if (status == 'OK') {
            var origins = response.originAddresses;
            var destinations = response.destinationAddresses;
            var minDist = 10000000;
            var result = response.rows[0].elements;

            var closestLeavingCampusPoint;
            var campus;
            var minIndex;
            for (var j = 0; j < result.length; j++) {
                var distance = result[j].distance.value;
                if (distance < minDist) {
                    minDist = distance;
                    minIndex = j;
                    closestLeavingCampusPoint = destinations[j];
                }
            }
            if (minIndex == 0){
            	campus = collegeave;
            } else if (minIndex == 1) {
            	campus = busch;
            } else if (minIndex==2) {
             	campus = livingston;
            } else if (minIndex == 3){
            	campus = douglass;
            } else {
            	campus = cook;
            }
            dm.getDistanceMatrix({
	            origins: [origins[0]],
	            destinations: campus,
	            travelMode: 'WALKING',
	        }, function(response, status) {
	        	if (status == 'OK') {
		            var origins2 = response.originAddresses;
		            var destinations2 = response.destinationAddresses;
		            var minDist = 10000000;
		            var result = response.rows[0].elements;
		            var closestLeavingBusStop;
		            var closestLeavingBusStopName;
		            var minIndex;
		            for (var j = 0; j < result.length; j++) {
		                var distance = result[j].distance.value;
		                if (distance < minDist) {
		                    minDist = distance;
		                    minIndex = j;
		                }
		            }
		            closestLeavingBusStop = campus[minIndex];
		             returnValue += codes[stops.indexOf(closestLeavingBusStop)];
			            //console.log(returnValue)

					closestLeavingBusStopName = names[stops.indexOf(closestLeavingBusStop)];
		            document.getElementById("leavingBusStop").innerHTML = closestLeavingBusStopName;
		                    document.getElementById("leavingSubText").innerHTML = result[minIndex].duration.text + " walk from " + current + " to " + closestLeavingBusStopName + " bus stop.";
	        		var mystring = closestLeavingBusStopName; 
							var newchar = '+'
							mystring = mystring.split(' ').join(newchar);
							var mystring2 = current  
							mystring2 = mystring2.split(' ').join(newchar);
		                    document.getElementById("left").setAttribute("onclick", "window.location='https://www.google.com/maps/dir/" + mystring2 + "/" + mystring + "/'");
	        } else {
            	alert(status + ". Could not find nearest campus.");
        	}
	     });
        }
    }

    function arrivingGeocode(da, callback) {
        gca.geocode({ address: da, bounds: new google.maps.LatLngBounds(new google.maps.LatLng(40.474369, -74.495217), new google.maps.LatLng(40.547717, -74.405550))}, function(results, status) {
            if (status == 'OK') {
                destinationLocation = new google.maps.LatLng(parseFloat(results[0].geometry.location.lat()), parseFloat(results[0].geometry.location.lng()));
                callback(destinationLocation);

            } else {
                alert(status + ". Could not find specified address.");
            }
        });
    }

    function arrivingDistanceMatrix(dl) {
        	dm.getDistanceMatrix({
            origins: [dl],
            destinations: campusPoints,
            travelMode: 'WALKING',
        }, callbackArriving);
    }


    function callbackArriving(response, status) {

        if (status == 'OK') {

            var origins = response.originAddresses;
            var destinations = response.destinationAddresses;
            var minDist = 1992382747;
            var result = response.rows[0].elements;
            var closestArrivingCampusPoint;
            var minIndex;
            for (var j = 0; j < result.length; j++) {
                var distance = result[j].distance.value;
                if (distance < minDist) {
                    minDist = distance;
                    minIndex = j;
                    closestArrivingCampusPoint = destinations[j];
                }
            }
            if (minIndex == 0){
            	campus = collegeave;
            } else if (minIndex == 1) {
            	campus = busch;
            } else if (minIndex==2) {
             	campus = livingston;
            } else if (minIndex == 3){
            	campus = douglass;
            } else {
            	campus = cook;
            }
            console.log(campus);
            dm.getDistanceMatrix({
	            origins: [origins[0]],
	            destinations: campus,
	            travelMode: 'WALKING',
	        }, function(response, status) {
	        	if (status == 'OK') {
	        		console.log(response);
		            var origins2 = response.originAddresses;
		            var destinations2 = response.destinationAddresses;
		            var minDist = 10000000;
		            var result = response.rows[0].elements;
		            var closestArrivingBusStop;
		            var closestArrivingBusStopName;
		            var minIndex;
		            for (var j = 0; j < result.length; j++) {
		                var distance = result[j].distance.value;
		                if (distance < minDist) {
		                    minDist = distance;
		                    minIndex = j;
		                }
		             }
		             closestArrivingBusStop = campus[minIndex];
		             returnValue += ":" + codes[stops.indexOf(closestArrivingBusStop)];
		                  console.log(returnValue);
		             closestArrivingBusStopName = names[stops.indexOf(closestArrivingBusStop)];
		                    document.getElementById("arrivingBusStop").innerHTML = closestArrivingBusStopName;
		                    document.getElementById("arrivingSubText").innerHTML = result[minIndex].duration.text + " walk from " + closestArrivingBusStopName + " bus stop to " + destination + ".";
		                    var mystring = closestArrivingBusStopName; 
							var newchar = '+'
							mystring = mystring.split(' ').join(newchar);
							var mystring2 = destination  
							mystring2 = mystring2.split(' ').join(newchar);
		                    document.getElementById("right").setAttribute("onclick", "window.location='https://www.google.com/maps/dir/" + mystring + "/" + mystring2 + "/'");
		                    
		                    client=new XMLHttpRequest();
		                    client.onreadystatechange=function()
		                    {
		                        if (client.readyState==4 && client.status==200)
		                        {
		                             document.getElementById("testOutput").innerHTML="Take the " + client.responseText + " bus."; 
		                        }
		                    };
		                    client.open("POST","/HereToThere/src/BusServlet",true);
		                    client.setRequestHeader("stops", returnValue);
		                    client.send(returnValue);
		                    
	        	} else {
            	alert(status + ". Could not find nearest bus stop.");
        	}
	      });
         }
    }
    	console.log(returnValue);
        
}

}
