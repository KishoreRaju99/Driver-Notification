var xhr = new XMLHttpRequest();
//window.addEventListener = ("load",getdetail,true);

window.onload = getdetail;

var cabNumber = sessionStorage.getItem('commonFileCabNumber');
var drivername = sessionStorage.getItem('commonFileDriverName');

var count;                   //screen loads
var queryStr = window.location.search;

var id = queryStr.split("=")[1];

var driveName;


function getdetail() {
	driverProfile();

	xhr.open("GET", "http://localhost:8083/Getalldetails/" + id, true);

	xhr.onreadystatechange = processResponseToGetDetail;

	xhr.send(null);
}

function processResponseToGetDetail() {

	if (xhr.readyState == 4 && xhr.status == 200) {
		constructDataToTable(xhr.responseText);

	}
}

function constructDataToTable(responseText) {
	var arr = JSON.parse(responseText);
	count = arr.length;                               //to get the details of all employees and putting them in a table
	createtable(arr);

	// appending all div tags in the same order and adding the values in innerhtml of these divtags


	var l = document.createElement('li');
	l.className = "trip-settings";
	var hour = arr[0].timeSlot.split(":");
	if (hour[0] < 12) {
		if (hour[0] >= 10) {

			l.innerHTML = "<img src='images/Clock.svg' alt='icon' class='detail-icon p-0'>" + hour[0] + ":" + hour[1] + " AM";

		}
		else {
			if (hour[0] == 00) {
				l.innerHTML   "<img src='images/Clock.svg' alt='icon' class='detail-icon p-0'>" + "12" + ":" + hour[1] + " AM";
			}

			else {
				l.innerHTML = "<img src='images/Clock.svg' alt='icon' class='detail-icon p-0'>" + "0" + hour[0] + ":" + hour[1] + " AM";
			}
		}
	}
	else {
		var hr = hour[0] - 12;
		if (hour[0] >= 10) {

			l.innerHTML = "<img src='images/Clock.svg' alt='icon' class='detail-icon p-0'>" + hr + ":" + hour[1] + " PM";

		}


		else {
			l.innerHTML = "<img src='images/Clock.svg' alt='icon' class='detail-icon p-0'>" + "0" + hr + ":" + hour[1] + " PM";
		}
	}


	//}

	var l2 = document.createElement('li');
	l2.className = "trip-settings";
	l2.innerHTML = "<img src='images/Map.svg' alt='icon' class='mt-2 detail-icon'>" + arr[0].source + "  to  " + arr[0].destination;

	var l3 = document.createElement('li');
	l3.className = "trip-settings";
	l3.innerHTML = "<img src='images/People.svg' alt='icon' id='Passengercount' class='detail-icon'>" + count + " Passengers ";

	document.getElementById("uldetails").appendChild(l);
	document.getElementById("uldetails").appendChild(l2);
	document.getElementById("uldetails").appendChild(l3);

}
//end of function constructTable
function createtable(arr) {
	for (var i = 0; i < arr.length; i++) {


		if (i % 2 == 0) {

			var div1 = document.createElement('div');
			div1.className = "col-md-12 mt-2 alt-row";

		}

		else {
			var div1 = document.createElement('div');
			div1.className = "col-md-12 mt-2 ";
		}

		var div2 = document.createElement('div');
		div2.className = "row";

		var div3 = document.createElement('div');
		div3.className = "col-md-4 left-col mx-1 mt-2 float-start";

		var div4 = document.createElement('div');
		div4.className = "col-md-6 show-header mt-2";

		var div5 = document.createElement('div');
		div5.className = "parent";

		var div6 = document.createElement('div');
		div6.className = "custom-radio tivasta-w-100 no-show-button";

		var div7 = document.createElement('div');
		div7.className = "custom-radio tivasta-w-100 show-button";


		var list = document.createElement('ul');
		list.className = "p-0";


		var listitem1 = document.createElement('li');
		listitem1.className = "Name";
		listitem1.innerText = arr[i].employeeName;


		var listitem2 = document.createElement('li');
		listitem2.className = "Emp-ID";
		listitem2.innerText = "EmpId:" + arr[i].employeeId;

		var listitem3 = document.createElement('li');
		listitem3.className = "Address";

		listitem3.innerHTML = "<img src='images/Map-table.svg' alt='icon' class= 'map-icon' >" + arr[i].dropPoint;

		list.appendChild(listitem1);
		list.appendChild(listitem2);
		list.appendChild(listitem3);

		div3.appendChild(list);

		div6.innerHTML = "<input type='radio'  id='radio-" + (i + (i + 1)) + "'name='radio" + i + "' value='r-opt1-db'  class='noshow'onclick='cancelTripVisibility()' checked=''>" + " <label for='radio-" + (i + (i + 1)) + "'></label>";
		div7.innerHTML = "<input type='radio' id='radio-" + (i + (i + 2)) + "' name='radio" + i + "' value='r-opt2-db' class='show'onclick='startTripVisibility()' >" + "<label for='radio-" + (i + (i + 2)) + "'></label>";

		div5.appendChild(div6);
		div5.appendChild(div7);
		div4.appendChild(div5);
		div2.appendChild(div3);
		div2.appendChild(div4);

		div1.appendChild(div2);
		document.getElementById('divid').appendChild(div1);

	}



}







var start = new XMLHttpRequest();
var startforshow = new XMLHttpRequest();



var submitBtn = document.getElementById("submitBtn");
submitBtn.addEventListener('click', startTrip);
// -- rohit
var submitBtn2 = document.getElementById("starttripb");
submitBtn2.addEventListener('click', recheckCount);
//submitBtn.addEventListener('click', starttripforshow);

var noshowlist = new Array();
var showlist = new Array();



function startTrip() {
	//ongoingForTripCabInfo();
	starttripforshow();
	//-- rohit

	for (var i = 0; i < count; i++) {
		var div = document.getElementById("divid");
		var radiv = document.getElementById("radio-" + (i + (i + 1)));


		if (radiv.checked == true) {


			const array = Array.prototype.slice.call(div.getElementsByClassName("Emp-ID"));
			console.log(array);
			var res = { "employeeId": array[i].innerText.split(":")[1] }
			noshowlist.push(res);


		}



		console.log(noshowlist);


	}

	ongoingForTripCabInfo();


	var url = "http://localhost:8083/update/for/" + id;

	start.open("PUT", url, true);

	start.onreadystatechange = processResponseToGetNoShow;

	start.setRequestHeader("Content-Type", "application/json");

	start.send(JSON.stringify(noshowlist));



}
function processResponseToGetNoShow() {

	if (start.readyState == 4 && start.status == 200) {
		var responsefornoshow = start.responseText;
		//alert("record updated successfully");


	}
}




//rohit - beg
function recheckCount() {
	//alert("hi");

	xhr.open("GET", "http://localhost:8083/Getalldetails/" + id, false);

	xhr.onreadystatechange = processResponseBeforeStart;

	xhr.send(null);

}

var countBeforeStart;
function processResponseBeforeStart() {
	if (xhr.readyState == 4 && xhr.status == 200) {

		var arr = JSON.parse(xhr.responseText);
		countBeforeStart = arr.length;

		if (count < countBeforeStart) {
			//	alert("new person has been added");
			document.getElementById('starttrip').disabled = true;
			var passengercount = document.getElementById('uldetails');
			while (passengercount.firstChild  {
				passengercount.removeChild(passengercount.firstChild);
			}

			if (countBeforeStart == undefined) {
				l3.innerHTML = "<img src='images/People.svg' alt='icon' id='Passengercount' class='detail-icon'>" + countBeforeStart + " Passengers ";
			}


			constructDataToTable(xhr.responseText);

			var parentdiv = document.getElementById('divid');
			while (parentdiv.firstChild) {
				parentdiv.removeChild(parentdiv.firstChild);

			}
			createtable(arr);
			count = countBeforeStart;
			return false;
		}

		return true;
	}
}
//rohit -- end





function starttripforshow() {


	for (var i = 0; i < count; i++) {
		var divid = document.getElementById("divid");
		var radiv2 = document.getElementById("radio-" + (i + (i + 2)));


		if (radiv2.checked == true) {


			const array = Array.prototype.slice.call(divid.getElementsByClassName("Emp-ID"));
			console.log(array);
			var result = { "employeeId": array[i].innerText.split(":")[1] }
			showlist.push(result);


		}



		console.log(showlist);


	}



	var url = "http://localhost:8083/update/for/show/" + id;

	startforshow.open("PUT", url, true);

	startforshow.onreadystatechange = processResponseToGetShow;

	startforshow.setRequestHeader("Content-Type", "application/json");

	startforshow.send(JSON.stringify(showlist));

}

function processResponseToGetShow() {

	if (startforshow.readyState == 4 && startforshow.status == 200) {
		var responseforshow = startforshow.responseText;
		//alert("record updated successfully");

	}
}

function cancelTripFunction() {
	startTrip();
	window.location.href = 'No-Trip-Assigned-Page.html'


}

function startTripVisibility() {


	document.getElementById("canceltrip").style.visibility = 'hidden';
	document.getElementById("starttripb").style.visibility = 'visible';

}
function cancelTripVisibility() {
	var checkallnoshow = new Array();
	for (var i = 0; i < count; i++) {
		var div = document.getElementById("divid");
		var radiv = document.getElementById("radio-" + (i + (i + 1)));


		if (radiv.checked == true) {


			const array = Array.prototype.slice.call(div.getElementsByClassName("Emp-ID"));
			console.log(array);
			var res = { "employeeId": array[i].innerText }
			checkallnoshow.push(res);


		}






	}
	if (checkallnoshow.length == count) {

		document.getElementById("canceltrip").style.visibility = 'visible';
		document.getElementById("starttripb").style.visibility = 'hidden';
		return false;
	}

}







function TripInProgressscreen() {

	//ongoingForTripCabInfo();
	//onclick="ongoingTripFunction()"
	window.location.href = "Trip-InProgress.html?TripId=" + id;

}


var xhrupdate = new XMLHttpRequest();

function ongoingForTripCabInfo() {

	xhrupdate.open("PUT", "http://localhost:8083/updateme/Ongoing/" + id, true);

	xhrupdate.onreadystatechange = processResponseforCabInfo;

	xhrupdate.send(null);
}

function processResponseforCabInfo() {

	if (xhrupdate.readyState == 4 && xhrupdate.status == 200) {
		window.location.href = "Trip-InProgress.html?TripId=" + id;
	}
}

// DRIVER PROFILE SCRIPT STARTS HERE

//window.onload = driverProfile;

function driverProfile() {



	var CabDriverName = document.getElementById("driver-profile1").innerText = drivername;

	var intials = CabDriverName.charAt(0);
	var nameicon = $('#nameicon').text(intials);


	document.getElementById("driver-profile3").innerText = cabNumber;
}
// DRIVER PROFILE SCRIPT ENDS HERE



//ADMIN CONTACTS SCRIPT STARTS HERE
var xhttp = new XMLHttpRequest();
function adminContacts() {

	xhttp.open("GET", "http://localhost:8083/adminContactDetails", true);

	xhttp.onreadystatechange = function() {

		if (this.readyState == 4 && this.status == 200) {

			response = JSON.parse(this.responseText);
			for (var i = 0; i < response.length; i++) {


				document.getElementById("adminContact" + i).innerHTML = "<label class='float-start mb-3' id='contacts1'><a class='link contact-number' href='#'>" + response[i].contactNumber + "</a>" + "  -  " + response[i].adminName + "</label>";

			}
		}
	};
	xhttp.send();
}

//ADMIN CONTACTS SCRIPT ENDS HERE

function logOut() {
	sessionStorage.clear();
	window.location.href = "http://localhost:8083/DriverLogin.html";
}

