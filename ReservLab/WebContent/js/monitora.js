function initMap() {
	// Create a map object and specify the DOM element for display.
	var map = new google.maps.Map(document.getElementById('map'), {
		center: {lat: -3.0771, lng: -60.001},
		zoom: 10
	});
}