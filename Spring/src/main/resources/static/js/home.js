reservations = []
voyagesID = []
let productNumber = 0;
jQuery(document).ready(function() {	
	$('#numberPanier').html(productNumber)
});

function addToChart(id){
	var test = 1;
	for(voyage of voyagesID){
		if(voyage == id){
			test = 0;
		}
	}
	if(test == 1){
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
}