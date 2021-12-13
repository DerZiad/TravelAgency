$(function() {
	$('.select-stateForm').selectize({
		sortField: 'text'
	});
});

function deleteHotel(idHotel){
	deletetedId = idHotel;		
}

var deletetedId = null;

function updateStar(number){
	$('input[name=star]').val(number);
}
function starManagement(){
	var gold = "#fdd835";
	var plat = "#b6b8c3";

	$('#star1').click(function(){
		$('#star1').css("color",gold);
		$('#star2').css("color",plat);
		$('#star3').css("color",plat);
		$('#star4').css("color",plat);
		$('#star5').css("color",plat);
		updateStar(2);
	});

	$('#star2').click(function(){
		$('#star1').css("color",gold);
		$('#star2').css("color",gold);
		$('#star3').css("color",plat);
		$('#star4').css("color",plat);
		$('#star5').css("color",plat);
		updateStar(2);
	});

	$('#star3').click(function(){
		$('#star1').css("color",gold);
		$('#star2').css("color",gold);
		$('#star3').css("color",gold);
		$('#star4').css("color",plat);
		$('#star5').css("color",plat);
		updateStar(3);
	});

	$('#star4').click(function(){
		$('#star1').css("color",gold);
		$('#star2').css("color",gold);
		$('#star3').css("color",gold);
		$('#star4').css("color",gold);
		$('#star5').css("color",plat);
		updateStar(4);
	});
	$('#star5').click(function(){
		$('#star1').css("color",gold);
		$('#star2').css("color",gold);
		$('#star3').css("color",gold);
		$('#star4').css("color",gold);
		$('#star5').css("color",gold);
		updateStar(5);
	});
}


function initializeLieux(lieux){
	var country = $('select[name=country]').val();
	var contenue = "";
	for(lieu of lieux){
		if(lieu.country.keyCountry === country){
			contenue = contenue + '<option value="' + lieu.id + '">' + lieu.label + '</option>';
		}
	}
	$('select[name=state]').html(contenue);						
	
}

hotels = [];
lieux =  []
function initialize(){
	$.ajax({
		url: '/api/hotel',
		type: 'get',
		data: {},
		success: function(response) {
			hotels = response;
			var contenue = "";
			for(hotel of hotels){
				contenue = contenue + '<tr>\n';
				contenue = contenue + '<td><span class="custom-checkbox"> <input type="checkbox" id="checkbox1" name="options[]" value="1"> <label for="checkbox1"></label></span></td>\n';
				contenue = contenue + '<td>' + hotel.nomHotel + '</td>\n'
				contenue = contenue + '<td>'+  hotel.nombreEtoile + '</td>\n'
				contenue = contenue + '<td>' + hotel.ville.label + '</td>\n'
				contenue = contenue + '<td><a class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a> <a href="#deleteEmployeeModal" onclick="deleteHotel(' + hotel.id + ')" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a></td>\n'
				contenue = contenue + '</tr>\n'
			}
			$('#hotelslist').html(contenue);
		}
	});

	$.ajax({
		url: '/api/lieux',
		type: 'get',
		data: {},
		success: function(response) {
			lieux = response;
			initializeLieux(lieux);
		}
	});

	$('select[name=country]').change(function(){
		initializeLieux(lieux);
	});

	$('input[name=add]').click(function(){
		var nomHotel = $('input[name=hotelname]').val();
		var star = $('input[name=star]').val();
		var state = $('select[name=state]').val();
		datas = {
				'nomHotel':nomHotel,
				'nombreEtoile':star,
				'idLieu':state
			}
		datas = JSON.stringify(datas);
		$.ajax({
           //ajax successful send to spring boot endpoint
           type:"POST",
           headers: {Accept : "application/json"},
           contentType:"application/json",
           url:"/api/hotel",
           data:datas,
           success: function(response) {
				hotel = response;
				initialize();
			}
       });
	});
	starManagement();
}

jQuery(document).ready(function() {
	initialize();
	$('input[name=delete]').click(function(){
		$.ajax({
           type:"Delete",
           url:"/api/hotel?id=" + deletetedId,
           success: function(response) {
				initialize();
			}
   	 	});
	});
});



