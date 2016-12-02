var asyncRequest;    
				function callServlet(){
				    try
				    {
				        asyncRequest = new XMLHttpRequest();
				        asyncRequest.addEventListener("readystatechange", stateChange, false);
				        asyncRequest.open('POST', '/BusServlet', true); 
				        asyncRequest.send(null);
				    }
				    catch(exception)
				   {
				    alert("Request failed");
				   }
				}

				function stateChange(){
				if(asyncRequest.readyState == 4 && asyncRequest.status == 200)
				    {
				    var text = document.getElementById("text");
				    var answer = asyncRequest.responseText.split("|"); 
				    document.getElementById("leavingBusStop").innerHTML = answer[0];
				    document.getElementById("arrivingBusStop").innerHTML = answer[1];
				    document.getElementsById("testOutput").innerHTML = "Take the " + answer[3] + " bus.";
				    }
				}

				window.addEventListener("load", start(), false);