// Ziad Bougrine
deletetedId = null;
voyages = [];
lieux = [];
countries = [];

function deleteHotel(idHotel) {
	deletetedId = idHotel;
}

function refreshCountryByVoyage(keyCountry) {
	var contenue = "";
	for (country of countries) {
		if (keyCountry == country.keyCountry) {
			contenue = contenue + '<option value="' + country.keyCountry + '" selected >' + country.valueCountry + '</option>';
		} else {
			contenue = contenue + '<option value="' + country.keyCountry + '">' + country.valueCountry + '</option>';
		}
	}
	$('select[name=destinationEdit]').html(contenue);
}

function makeEditHotel(idVoyage) {
	var selectedVoyage = null;
	for (voyage of voyages) {
		if (voyage.id == idVoyage) {
			selectedVoyage = voyage;
		}
	}
	voyage = selectedVoyage;
	
	var titre = $('input[name=titre]').val();
	var destination = $('select[name=destination]').val();
		var prix = $('input[name=prix]').val();
		var nbrPersonnes = $('input[name=nbrPersonnes]').val();
		var nbKilometres = $('input[name=nbKilometres]').val();
		var ageMin = $('input[name=ageMin]').val();
		var ageMax = $('input[name=ageMax]').val();
		var dateDepartDate = $('input[name=dateDepartDate]').val();
		var dateArriveeDate  = $('input[name=dateArriveeDate]').val();
		var description = $('input[name=description]').val();
	
	
	$("input[name=titreEdit]").val(voyage.titre);
	$("input[name=destinationEdit]").val(hotel.destination);
	$("input[name=prixEdit]").val(hotel.prix);
	$("input[name=nbrPersonnesEdit]").val(hotel.nbrPersonnes);
	$("input[name=nbKilometresEdit]").val(hotel.nbKilometres);
	$("input[name=ageMinEdit]").val(hotel.ageMin);
	$("input[name=ageMaxEdit]").val(hotel.ageMax);
	$("input[name=dateDepartDateEdit]").val(hotel.dateDepartDate);
	$("input[name=dateArriveeDateEdit]").val(hotel.dateArriveeDate);
	$("input[name=descriptionEdit]").val(hotel.description);
	refreshCountryByVoyage(hotel.ville.country.keyCountry);
	$('#editEdit').click(function() {
		var nomHotel = $('input[name=hotelnameEdit]').val();
		var star = $('input[name=starEdit]').val();
		var state = $('select[name=stateEdit]').val();
		datas = {
			'id': "" + idHotel,
			'nomHotel': nomHotel,
			'nombreEtoile': star,
			'idLieu': state
		}
		datas = JSON.stringify(datas);
		$.ajax({
			type: "PUT",
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
					$('#' + keys[i] + 'ErrorEdit').html(message[keys[i]]);
				}
			}
		});
	});
}



function deleteAll() {
	for (hotel of hotels) {
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

function clearAddCache() {

	$('input[name=hotelname]').val("");
	$('input[name=star]').val("1");
	$('#nomHotelError').html("");
	$('#nombreEtoileError').html("");
	$('#villeError').html("");
	refreshLieux();
	refreshCountry();
}

function refreshCountry() {
	var contenue = "";
	for (country of countries) {
		contenue = contenue + '<option value="' + country.valueCountry + '">' + country.valueCountry + '</option>';
	}
	$('select[name=destination]').html(contenue);
}

function getPictures(idHotel) {
	$.ajax({
		url: '/api/hotel/pictures?id=' + idHotel,
		type: 'get',
		data: {},
		success: function(response) {
			pictures = response;
			var contenue = "";
			var i = 0;
			for (picture of pictures) {
				if (i == 0) {
					contenue = contenue + '<div class="carousel-item active"><img class="d-block w-100" style="height:200px;width:100px" src="data:image/jpeg;base64,' + picture.base64 + '" alt="' + picture.id + '"></div>\n';

				} else {
					contenue = contenue + '<div class="carousel-item"><img class="d-block w-100" style="height:200px;width:100px" src="data:image/jpeg;base64,' + picture.base64 + '" alt="' + picture.id + '"></div>\n';
				}
				i++;
			}

			$('#galerie').html(contenue);
		}, error: function(xhr, ajaxOptions, thrownError) {
			var contenue = "";
			contenue = contenue + '<div class="carousel-item active"><img class="d-block w-100" src="/images/notfound.jpg" alt="Not found"></div>\n';
			$('#galerie').html(contenue);
		}
	});
}

function refreshvoyages() {
	$.ajax({
		url: '/api/voyage',
		type: 'get',
		data: {},
		success: function(response) {
			voyages = response;
			var contenue = "";
			for (voyage of voyages) {
				contenue = contenue + '<tr>\n';
				contenue = contenue + '<td><span class="custom-checkbox"> <input type="checkbox" id="checkbox' + voyage.id + '" name="options[]" value="1"> <label for="checkbox1"></label></span></td>\n';
				contenue = contenue + '<td>' + voyage.titre + '</td>\n'
				contenue = contenue + '<td>' + voyage.destination + '</td>\n'
				contenue = contenue + '<td>' + voyage.dateDepart + '</td>\n'
				contenue = contenue + '<td>' + voyage.dateArrivee + '</td>\n'
				contenue = contenue + '<td>' + voyage.description + '</td>\n'
				contenue = contenue + '<td>' + voyage.nombrePersonneEnGroupe+ '</td>\n'
				contenue = contenue + '<td>' + voyage.nombrePersonneTotal+ '</td>\n'
				contenue = contenue + '<td>' + voyage.prix+ '</td>\n'
				contenue = contenue + '<td>' + voyage.reduction+ '</td>\n'
				contenue = contenue + '<td><a href="#addImageModal" onclick="getPictures(' + voyage.id + ')" class="addpicture" data-toggle="modal"><i data-toggle="tooltip" title="Edit" class="fas fa-images"></i></a><a href="#editEmployeeModal" onclick="makeEditHotel(' + voyage.id + ')" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a> <a href="#deleteEmployeeModal" onclick="deleteHotel(' + voyage.id + ')" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a><a href="/admin/hotel/picture?id=' + voyage.id + '" class="edit" data-toggle="modal"><i class="fa fa-plus" aria-hidden="true"></i></a></td>\n'
				contenue = contenue + '</tr>\n'
			}


			$('#voyageslist').html(contenue);
		}
	});
}

function initialize() {
	refreshvoyages();
	$('input[name=add]').click(function() {
		var titre = $('input[name=titre]').val();
		var destination = $('select[name=destination]').val();
		var prix = $('input[name=prix]').val();
		var nbrPersonnes = $('input[name=nbrPersonnes]').val();
		var nbKilometres = $('input[name=nbKilometres]').val();
		var ageMin = $('input[name=ageMin]').val();
		var ageMax = $('input[name=ageMax]').val();
		var dateDepartDate = $('input[name=dateDepartDate]').val();
		var dateArriveeDate  = $('input[name=dateArriveeDate]').val();
		var description = $('input[name=description]').val();
		datas = {
			'titre': titre,
			'destination': destination,
			'prix': prix,
			'nbrPersonnes': nbrPersonnes,
			'nbKilometres': nbKilometres,
			'ageMin': ageMin,
			'ageMax': ageMax,
			'dateDepartDate': dateDepartDate,
			'dateArriveeDate': dateArriveeDate,
			'description':description
		}
		datas = JSON.stringify(datas);
		$.ajax({
			type: "POST",
			headers: { Accept: "application/json" },
			contentType: "application/json",
			url: "/api/voyage",
			data: datas,
			success: function(response) {
				voyages = response;
				refreshvoyages();
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
	$('input[name=deleteAll]').click(function() {
		deleteAll();
	});
	$.ajax({
		url: '/api/country',
		type: 'get',
		data: {},
		success: function(response) {
			countries = response;
			refreshCountry();
		}
	});
});



