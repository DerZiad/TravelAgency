var lieux = [];
var voyages = [];
$(document).ready(function() {
	console.log("BOUCLEEE");
	refreshVoyages();
	$('input[name=date_arrive]').click(function() {
		verifi();
	});
	$('select[name=country]').change(function() {
		console.log("dd")
		refreshLieux();
		refreshVoyagesByCountry();
	});


});
function verifi() {
	var dd = $('input[name=date_depart]').val();
	var da = $('input[name=date_arrive]').val();
	document.getElementById('dr').setAttribute("min", dd);
	console.log(dd);
}
function refreshLieux() {
	$.ajax({
		url: '/api/lieux',
		type: 'get',
		data: {},
		success: function(response) {
			lieux = response;
			var country = $('select[name=country]').val();
			var contenue = "";
			for (lieu of lieux) {
				if (lieu.country.valueCountry === country) {
					contenue = contenue + '<option value="' + lieu.id + '">' + lieu.label + '</option>';
				}
			}
			console.log(lieux);
			$('select[name=state]').html(contenue);
		}
	});

}

function refreshVoyages() {
	$.ajax({
		url: '/api/voyage',
		type: 'get',
		data: {},
		success: function(response) {
			voyages = response;
			console.log("voyages.lentgh =" + voyages.length);
			//document.getElementById("srch").setAttribute("value", "search  " + voyages.length);

		}
	});
	document.getElementById("srch").setAttribute("value", "search  " + voyages.length);

}

function refreshVoyagesByCountry() {
	var country = $('select[name=country]').val();
	var i = 0;

	refreshVoyages();
	for (voy of voyages) {
		console.log("desrt " + voy['destination']);
		console.log("inout user   " + country);
		console.log("comp= " + voy['destination'] == country)
		if (voy['destination'] == country) {//voy['destination']
			i = i + 1;
		}

	}
	console.log("voy  " + i);
	document.getElementById("srch").setAttribute("value", "search  " + i);

}




