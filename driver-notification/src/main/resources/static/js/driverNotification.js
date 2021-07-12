 
 
		var tripId;
     
           
           //DRIVER NOTIFICATION SCRIPT STARTS HERE 
           
           function tripDetails(){
        	 var value = tripCabId ; 

             window.location.href = "tripdetails.html?tripCabId="+tripId;
           }

            var response;
            var xhttp = new XMLHttpRequest();
            window.onload = driverNotification;	
            setInterval('driverNotification()', 10000);            
            function driverNotification() {
            driverProfile();
                    
                    xhttp.open("GET", "http://localhost:8080/api/v1/notification/TN8S6677", true);

                    xhttp.onreadystatechange = function () {
                    	 if (this.readyState == 4 && this.status == 200) {              
                     
                            if(this.responseText){
                           
                            	response = JSON.parse(this.responseText);
                         
                            	
                         //BELOW CODE FOR TRIP GENERATED TIME
                            	
                            	 tripId = response.tripCabId;
                            	
//                         var splitTime=response.generatedtime.split(":");
//                         var hours = splitTime[0];
//                         var min = splitTime[1];
//                         var time;
//                         if(hours<12){
//                         	if(hours==00){
//                         		time="12"+":"+min+" "+"AM";
//                         	}
//                         	else{
//                         		time=hours+":"+min+" "+"AM";
//                         	}
                        	
//                         }
//                         else if(hours==12){
//                         	time=hours+":"+min+" "+"PM";
                        	
                        	
//                         }
//                         else{
//                         	var hour= hours-12;
//                         	time=hour+":"+min+" "+"PM";
//                         }
                        
                        
                        // BELOW CODE FOR CAB BOOKING TIMESLOTS
                        
                        
                        var timeSlot=response.timeSlot.split(":");
                        var slotHours = timeSlot[0];
                        var slotMin = timeSlot[1];
                        var slotTime;
                        if(slotHours<12){
                        	if(slotHours==00){
                        		slotTime="12"+":"+slotMin+" "+"AM";
                        	}
                        	else if(slotHours<10){
                        		
                        		slotTime="0"+slotHours+":"+slotMin+" "+"AM";
                        	}
                        	else{
                        		slotTime=slotHours+":"+slotMin+" "+"AM";
                        	}
                        	
                        }
                        else if(slotHours==12){
                        	slotTime=slotHours+":"+slotMin+" "+"PM";
                        	
                        	
                        }
                        else{
                        	var slothour= slotHours-12;
                        	if(slothour<10){
                        		slotTime="0"+slothour+":"+slotMin+" "+"PM";
                        	}
                        	else{
                        		slotTime=slothour+":"+slotMin+" "+"PM";
                        	}
                        	
                        }
                        
	                      
                            
                            document.getElementById("notification-details").innerHTML = " <button type='button' class='btn btn-primary' data-toggle='modal' data-target=''#exampleModal' onclick='tripDetails()' >" + "<h5 class='text-center fw-bold'>You have been assigned a trip</h5>" + "<img src='images/Map-table.svg' alt='map-icon' class='mx-1 map-icon1'>" +
                                response.source + " → " + response.destination + " @ " + slotTime +"</button>";
                          
                        		document.getElementById("notificationID").src = "images/MicrosoftTeams-image.png";
                        	}
                        	
                            else{
                        		
                        		document.getElementById("notificationID").src = "images/Bell-icon.svg";
                        	}
                            
                        }

                    };




                    xhttp.send();
                }         
            
            //DRIVER NOTIFICATION SCRIPT ENDS HERE 
            
            
            
            // DRIVER PROFILE SCRIPT STARTS HERE
               
              //  window.onload = driverProfile;
                function driverProfile() {
                	
                	  xhttp.open("GET", "http://localhost:8080/api/v1/driverProfile/TN8S6677", false);

                      xhttp.onreadystatechange = function () {

                          if (this.readyState == 4 && this.status == 200) {
                        	  
                        	  
                        	  response = JSON.parse(this.responseText)
                        	  
                    var driveName = $('#drive-profile1').text();
                    var intials = response.driverName.charAt(0) ;//+ response.driverName.charAt(1) ;
                    var nameicon = $('#nameicon').text(intials);
                    
                    document.getElementById("driver-profile1").innerText = response.driverName;
                    document.getElementById("driver-profile2").innerText = response.role;
                    document.getElementById("driver-profile3").innerText = response.cabNumber;
                   
                    
                }
                      };
                      xhttp.send();
                }
                
              // DRIVER PROFILE SCRIPT ENDS HERE
                
                
              //ADMIN CONTACTS SCRIPT STARTS HERE
              
                function adminContacts() {
                	  xhttp.open("GET", "http://localhost:8080/api/v1/adminContactDetails", true);

                      xhttp.onreadystatechange = function () {

                          if (this.readyState == 4 && this.status == 200) {
         	  
                        	  response = JSON.parse(this.responseText);
                        	  for(var i=0;i<response.length;i++){
                        		  
                        document.getElementById
                        	  document.getElementById("adminContact"+i).innerHTML = "<label class='float-start mb-3' id='contacts1'><a class='link contact-number' href='#'>"+response[i].contactNumber+"</a>"+"  -  "+response[i].adminName+"</label>" ;
                        	 
                        	  }
                          }
                      };
                      xhttp.send();
                }	
              
              
              //ADMIN CONTACTS SCRIPT ENDS HERE
              
              
            


          
            
    