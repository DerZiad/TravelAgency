var activites = []
$(document).ready(function() {
	$('ul.nav li.dropdown').hover(function() {
		$(this).find('.dropdown-menu').stop(true, true).delay(200).fadeIn(500);
		refreshActivite();
	}, function() {
		$(this).find('.dropdown-menu').stop(true, true).delay(200).fadeOut(500);
	});

});
function refreshActivite() {
	$.ajax({
		url: '/api/activite/all',
		type: 'get',
		data: {},
		success: function(response) {
			activites = response;
			var contenue = "";
			for (act of activites) {
				contenue = contenue + '<li value="act[\'nomActivite\']">' + act['nomActivite'] + '</li>';
			}
			console.log(activites);
		
		$('.dropdown-menu').html(contenue);
	}
	})
}
