reservations = []
var etat1 = "";

$(document).ready(function() {
	console.log("hh	");

	refreshReservation();
});
function refreshReservation() {
	$.ajax({
		url:'/api/reservation',
		type:'get',
		data: {},
		success: function(response) {
			reservations = response;
			var contenue = "";
			for (rese of reservations) {
				contenue = contenue + '<tr>\n';
				console.log(rese.id)
				contenue=contenue+'<td>'+"AAA"+'</td>\n'
				if (rese.isConfirmed == '1') {
					etat1 = "Confirmee"
				}
				contenue = contenue + '<td>' + "Reservee" + '</td>\n'
				contenue = contenue + '<td>' + etat1 + '</td>\n'
				contenue = contenue + '</tr>\n'
			}
			$('#reservationslist').html(contenue);
		}
	});
}