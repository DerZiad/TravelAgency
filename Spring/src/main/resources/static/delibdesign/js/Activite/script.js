activites = []
var x = 1;
actv = [];
$(document).ready(function() {
	refreshActivite();
	addActivite();

	$('button[id=rst]').click(function() {
		clearAddCache();
		window.history.back();

	});
	/************** */
	$('input[name=mdf]').click(function() {
		console.log("pput")
		var idactivite = $('input[name=id]').val();
		var idVoyage = $('input[name=idVoyage]').val();
		var label = $('input[name=name]').val();
		var description = $('input[name=description]').val();
		let sas = [];
		console.log("amoud" + x);
		for (let pas = 1; pas <= x; pas++) {
			var sid = $("input[name=sid]").val();
			var labelsa = $('input[name=myparams' + pas + ']').val();
			console.log(labelsa);
			var descr = $('input[name=SousActdescrip' + pas + ']').val()
			console.log(descr);
			let sa = new Object();
			sa['id'] = sid;
			sa['titre'] = labelsa;
			sa['description'] = descr;
			sas.push(sa);
		}
		datas = {
			'id': idactivite,
			'nomActivite': label,
			'description': description,
			'sousActivites': sas,
			'idVoyage': idVoyage
		}
		console.log(datas);
		datas = JSON.stringify(datas);
		$.ajax({
			type: "PUT",
			headers: { Accept: "application/json" },
			contentType: "application/json",
			url: "/api/activite",
			data: datas,
			success: function(response) {
				activites = response;
				clearAddCache();

				refreshActivite();
			}, error: function(xhr, ajaxOptions, thrownError) {
				var message = xhr['responseJSON'].message;
				message = JSON.parse(message);
				keys = Object.keys(message);
				for (let i = 0; i < keys.length; i++) {
					$('#' + keys[i] + 'ErrorEdit').html(message[keys[i]]);
					console.log("key   " + keys[i]);
				}
			}
		});


	});
	/******************/
	var max_fields = 10;
	var wrapper = $(".container1");
	var add_button = $(".add_form_field");

	$(add_button).click(function(e) {
		e.preventDefault();
		if (x < max_fields) {
			x++;
			$(wrapper).append('<div class="form-row"><div class="col-md-6"><div class="position-relative form-group"><label for="name" class="">Label SousActivite</label><input id="ssa" type="text" value=""name="myparams' + x + '" class="form-control"/><p id="description' + x + 'Error" class="error"></p></br><label for="name" class="">Description SousActivite</label><input type="text" id="dess" value=""name="SousActdescrip' + x + '" class="form-control"/><p id="description' + x + 'Error" class="error"></p><a class="btn btn-danger delete" href="#"><i class="fas fa-backspace"></i></a></div></div></div>'); //add input box
		} else {
			alert('Ca se suffit ?!!');
		}
	});

	$(wrapper).on("click", ".delete", function(e) {
		e.preventDefault();
		$(this).parent('div').remove();
		x--;
	})
});
function clearAddCache() {
	$('input[name=id]').val("");
	$('input[name=name]').val("");
	$('input[name=description]').val("");
	$('input[name=myparams]').val("");
	$('input[name=SousActdescrip]').val("");
	for (let pas = 1; pas <= x; pas++) {
		$('input[name=myparams' + pas + ']').val("");
		$('input[name=SousActdescrip' + pas + ']').val("")

	}
}
function refreshActivite() {
	$.ajax({
		url: '/api/activite?id=' + $('input[name=idVoyage]').val(),
		type: 'get',
		data: {},
		success: function(response) {
			activites = response;
			var contenue = "";
			for (act of activites) {
				contenue = contenue + '<tr>\n';
				contenue = contenue + '<td>' + act['nomActivite'] + '</td>\n'
				contenue = contenue + '<td>' + act['description'] + '</td>\n'
				console.log(act['sousActivites'].length);
				contenue = contenue + '<td>';
				for (let pas = 0; pas < act['sousActivites'].length; pas++) {
					console.log("IN")
					console.log(act['sousActivites'][pas]['titre']);
					contenue = contenue + '<li>' + act['sousActivites'][pas]['titre'] + '</li>';

				}
				contenue = contenue + '</td>\n';
				contenue = contenue + '<td><a style="color: black" href="/admin/activite/' + act['id'] + '?idVoyage=' + $('input[name=idVoyage]').val() + '"><i class="material-icons" data-toggle="tooltip" title="Edit"	style="color: #1de9b6">&#xE254;</i></a> <a href="/admin/activite/deleteActivite/' + act['id'] + '?idVoyage=' + $('input[name=idVoyage]').val() + '	class="delete"><i class="material-icons"	data-toggle="tooltip" title="Delete" style="color: #f44336;">&#xE872;</i></a>';
			}
			$('#activiteslist').html(contenue);

		}
	})

}


function addActivite() {
	$('input[name=add]').click(function() {
		/*var idactivite = $('input[name=id]').val();*/
		var idVoyage = $('input[name=idVoyage]').val();
		console.log(idVoyage);
		var label = $('input[name=name]').val();
		console.log("LABEL" + label);
		var description = $('input[name=description]').val();
		console.log("DESC" + description);
		console.log('x' + x);
		let sas = [];
		for (let pas = 1; pas <= x; pas++) {
			var labelsa = $('input[name=myparams' + pas + ']').val();
			var descr = $('input[name=SousActdescrip' + pas + ']').val()
			let sa = new Object();
			sa['titre'] = labelsa;
			sa['description'] = descr;
			sas.push(sa);
		}
		datas = {
			'nomActivite': label,
			'description': description,
			'sousActivites': sas,
			'idVoyage': idVoyage
		}

		datas = JSON.stringify(datas)
		console.log(datas)

		$.ajax({
			type: "POST",
			headers: { Accept: "application/json" },
			contentType: "application/json",
			url: "/api/activite",
			data: datas,
			success: function(response) {
				activites = response;
				clearAddCache();

				refreshActivite();
			}, error: function(xhr, ajaxOptions, thrownError) {
				var message = xhr['responseJSON'].message;
				message = JSON.parse(message);
				keys = Object.keys(message);
				for (let i = 0; i < keys.length; i++) {
					$('#' + keys[i] + 'Error').html(message[keys[i]]);
					console.log(keys[i]);
					console.log(message);
				}
			}
		});
	});
}

function editActivite() {
	$('input[name=mdf]').click(function() {
		console.log("pput")
		var idactivite = $('input[name=id]').val();
		var idVoyage = $('input[name=idVoyage]').val();
		var label = $('input[name=name]').val();
		var description = $('input[name=description]').val();
		let sas = [];
		console.log("amoud" + x);
		for (let pas = 1; pas <= x; pas++) {
			var labelsa = $('input[name=myparams' + pas + ']').val();
			console.log(labelsa);
			var descr = $('input[name=SousActdescrip' + pas + ']').val()
			console.log(descr);
			let sa = new Object();
			sa['titre'] = labelsa;
			sa['description'] = descr;
			sas.push(sa);
		}
		datas = {
			'id': idactivite,
			'nomActivite': label,
			'description': description,
			'sousActivites': sas,
			'idVoyage': idVoyage
		}
		datas = JSON.stringify(datas);
		$.ajax({
			type: "PUT",
			headers: { Accept: "application/json" },
			contentType: "application/json",
			url: "/api/activite",
			data: datas,
			success: function(response) {
				actv = response;
				refreshActivite();
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

