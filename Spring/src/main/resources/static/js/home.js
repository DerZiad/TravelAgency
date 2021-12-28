reservations = []
voyagesID = []
let productNumber = 0;
jQuery(document).ready(function() {


	var username = $("input[name=username]").val();
	if (username != undefined) {
		let numbers = $('input[name=reservationNumber]').val();
		if (numbers != null) {
			productNumber = numbers;
		}
		$('#numberPanier').html(productNumber)
		//Call all reservations
		$.ajax({
			type: "GET",
			headers: { Accept: "application/json" },
			contentType: "application/json",
			url: "/api/reservation/username?username=" + username,
			success: function(response) {
				for(reservation of response){
					reservations.push(reservation);
					voyagesID.push(reservation.voyage.id);
				}
			}, error: function(xhr, ajaxOptions, thrownError) {
				var message = xhr['responseJSON'].message;
				message = JSON.parse(message);
				keys = Object.keys(message);
				for (let i = 0; i < keys.length; i++) {
					$('#' + keys[i] + 'Error').html(message[keys[i]]);
				}
			}
		});

	}


});

function addToChart(id) {

	var username = $("input[name=username]").val();
	if (username != undefined) {
		console.log(username);
		var test = 1;
		for (voyage of voyagesID) {
			if (voyage == id) {
				test = 0;
			}
		}
		if (test == 1) {
			voyagesID.push(id)
			datas = {
				'idVoyage': id,
				'idPerson': $('input[name=idPerson]').val()
			}
			datas = JSON.stringify(datas);
			$.ajax({
				type: "POST",
				headers: { Accept: "application/json" },
				contentType: "application/json",
				url: "/api/reservation",
				data: datas,
				success: function(response) {
					reservations.push(response);
				}, error: function(xhr, ajaxOptions, thrownError) {
					var message = xhr['responseJSON'].message;
					message = JSON.parse(message);
					keys = Object.keys(message);
					for (let i = 0; i < keys.length; i++) {
						$('#' + keys[i] + 'Error').html(message[keys[i]]);
					}
				}
			});

			productNumber++;
			$('#numberPanier').html(productNumber);
		}
	} else {
		window.location.replace("/login");
	}
}