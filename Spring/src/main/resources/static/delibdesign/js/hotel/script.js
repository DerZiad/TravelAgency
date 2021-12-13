const gold = "#fdd835";
const plat = "#b6b8c3";
const deletetedId = null;
const editedHotelId = null;
hotels = [];
lieux = [];

$(function() {
	$('.select-stateForm').selectize({
		sortField: 'text'
	});
});

function deleteHotel(idHotel) {
	deletetedId = idHotel;
}

function editHotel(idHotel) {
	editedHotelId = idHotel;
}

function deleteAll() {
	console.log("start");
	for (hotel of hotels) {
		console.log(hotel);
		console.log($('#checkbox' + hotel.id));
		if ($('#checkbox' + hotel.id).is(":checked")) {
			$.ajax({
				type: "Delete",
				url: "/api/hotel?id=" + hotel.id,
				success: function(response) {
					refreshotels();
				}
			});
		}
	}
	refreshotels();
}

function updateStar(number) {
	$('input[name=star]').val(number);
}
function starManagement() {
	$('#star1').click(function() {
		$('#star1').css("color", gold);
		$('#star2').css("color", plat);
		$('#star3').css("color", plat);
		$('#star4').css("color", plat);
		$('#star5').css("color", plat);
		updateStar(1);
	});

	$('#star2').click(function() {
		$('#star1').css("color", gold);
		$('#star2').css("color", gold);
		$('#star3').css("color", plat);
		$('#star4').css("color", plat);
		$('#star5').css("color", plat);
		updateStar(2);
	});

	$('#star3').click(function() {
		$('#star1').css("color", gold);
		$('#star2').css("color", gold);
		$('#star3').css("color", gold);
		$('#star4').css("color", plat);
		$('#star5').css("color", plat);
		updateStar(3);
	});

	$('#star4').click(function() {
		$('#star1').css("color", gold);
		$('#star2').css("color", gold);
		$('#star3').css("color", gold);
		$('#star4').css("color", gold);
		$('#star5').css("color", plat);
		updateStar(4);
	});
	$('#star5').click(function() {
		$('#star1').css("color", gold);
		$('#star2').css("color", gold);
		$('#star3').css("color", gold);
		$('#star4').css("color", gold);
		$('#star5').css("color", gold);
		updateStar(5);
	});
}

function clearAddCache() {

	$('input[name=hotelname]').val("");
	$('input[name=star]').val("1");
	$('#star1').css("color", gold);
	$('#star2').css("color", plat);
	$('#star3').css("color", plat);
	$('#star4').css("color", plat);
	$('#star5').css("color", plat);
	updateStar(1);
	$('#nomHotelError').html("");
	$('#nombreEtoileError').html("");
	$('#villeError').html("");
	refreshLieux();
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
				if (lieu.country.keyCountry === country) {
					contenue = contenue + '<option value="' + lieu.id + '">' + lieu.label + '</option>';
				}
			}
			$('select[name=state]').html(contenue);
		}
	});

}

function refreshotels() {
	$.ajax({
		url: '/api/hotel',
		type: 'get',
		data: {},
		success: function(response) {
			hotels = response;
			var contenue = "";
			for (hotel of hotels) {
				contenue = contenue + '<tr>\n';
				contenue = contenue + '<td><span class="custom-checkbox"> <input type="checkbox" id="checkbox' + hotel.id + '" name="options[]" value="1"> <label for="checkbox1"></label></span></td>\n';
				contenue = contenue + '<td>' + hotel.nomHotel + '</td>\n'
				contenue = contenue + '<td>' + hotel.nombreEtoile + '</td>\n'
				contenue = contenue + '<td>' + hotel.ville.label + '</td>\n'
				contenue = contenue + '<td><a href="#editEmployeeModal" onclick="(' + hotel.id + ')" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a> <a href="#deleteEmployeeModal" onclick="deleteHotel(' + hotel.id + ')" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a></td>\n'
				contenue = contenue + '</tr>\n'
			}
			$('#hotelslist').html(contenue);
		}
	});
}

function initialize() {


	refreshotels();
	refreshLieux();

	$('select[name=country]').change(function() {
		refreshLieux();
	});

	$('input[name=add]').click(function() {
		console.log("click");
		var nomHotel = $('input[name=hotelname]').val();
		var star = $('input[name=star]').val();
		var state = $('select[name=state]').val();
		datas = {
			'nomHotel': nomHotel,
			'nombreEtoile': star,
			'idLieu': state
		}
		datas = JSON.stringify(datas);
		$.ajax({
			type: "POST",
			headers: { Accept: "application/json" },
			contentType: "application/json",
			url: "/api/hotel",
			data: datas,
			success: function(response) {
				hotel = response;
				refreshotels();
				clearAddCache();
			}, error: function(xhr, ajaxOptions, thrownError) {
				var message = xhr['responseJSON'].message;
				message = JSON.parse(message);
				keys = Object.keys(message);
				for (let i = 0; i < keys.length; i++) {
					$('#' + keys[i] + 'Error').html(message[keys[i]]);
				}
			}
		});
	});
	starManagement();
}

jQuery(document).ready(function() {
	initialize();
	$('input[name=delete]').click(function() {
		$.ajax({
			type: "Delete",
			url: "/api/hotel?id=" + deletetedId,
			success: function(response) {
				refreshotels();
			}
		});
	});
	$('#cancelAdd').click(function() {
		clearAddCache();
	});
	$('input[name=deleteAll]').click(function(){
		deleteAll();
	});
});



