<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags-->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Colorlib Templates">
<meta name="author" content="Colorlib">
<meta name="keywords" content="Colorlib Templates">

<!-- Title Page-->
<title>Inscription</title>

<!-- Icons font CSS-->
<link href="/vendor/mdi-font/css/material-design-iconic-font.min.css"
	rel="stylesheet" media="all">
<link href="/vendor/font-awesome-4.7/css/font-awesome.min.css"
	rel="stylesheet" media="all">
<!-- Font special for pages-->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i"
	rel="stylesheet">

<!-- Vendor CSS-->
<link href="/vendor/select2/select2.min.css" rel="stylesheet"
	media="all">
<link href="/vendor/datepicker/daterangepicker.css" rel="stylesheet"
	media="all">

<!-- Main CSS-->
<link href="/css/main.css" rel="stylesheet" media="all">
<link href="/css/header.css" rel="stylesheet" media="all">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/animate.css" />
<link rel="stylesheet" href="assets/css/hover-min.css">
<link rel="stylesheet" href="assets/css/datepicker.css">
<link rel="stylesheet" href="assets/css/owl.carousel.min.css">
<link rel="stylesheet" href="assets/css/owl.theme.default.min.css" />
<link rel="stylesheet" href="assets/css/jquery-ui.min.css" />
<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="assets/css/bootsnav.css" />
<link rel="stylesheet" href="assets/css/style.css" />
<link rel="stylesheet" href="assets/css/responsive.css" />
<style>
.row {
	margin-top: 40px;
	padding: 0 10px;
}

.clickable {
	cursor: pointer;
}

.panel-heading div {
	margin-top: -18px;
	font-size: 15px;
}

.panel-heading div span {
	margin-left: 5px;
}

.panel-body {
	display: none;
}
</style>
</head>
<body>
	<div class="topnav">
		<a class="active" href="/">Home</a><a href="/#blog">Contact</a>
		<div class="row">
			<div class="col-sm-12">
				<div class="logo">
					<a href=""> WIE<span>BATOUTA</span>
					</a>
				</div>
				<!-- /.logo-->
			</div>
		</div>

	</div>
	<div class="container">
		
		<h1>Les Reservations faites par ${personne}</h1>
		<div class="row">
			<div class="col-md-8">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Reservations</h3>
						<div class="pull-right">
							<span class="clickable filter" data-toggle="tooltip"
								title="Toggle table filter" data-container="body"> <i
								class="glyphicon glyphicon-filter"></i>
							</span>
						</div>
					</div>
					<div class="panel-body">
						<input type="text" class="form-control" id="dev-table-filter"
							data-action="filter" data-filters="#dev-table"
							placeholder="Filter Developers" />
					</div>
					<table class="table table-hover" id="dev-table">
						<thead>
							<tr>
								<th>Picture</th>
								<th>Titre</th>
								<th>Description</th>
								<th>Destination</th>
								<th>Price</th>
								<th>Date depart</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${reservations}" var="reserv">
								<tr>

									<td><img
										src="data:image/jpeg;base64,${reserv.voyage.header}"
										alt="Not found" />
									<td><p>${reserv.voyage.titre}</p></td>
									<td>
										<p>${reserv.voyage.description}</p>
									</td>
									<td>
										<p>${reserv.voyage.destination}</p>
									</td>
									<td>
										<p>${reserv.voyage.prix}EUR</p>
									</td>
									<td>
										<p>${reserv.voyage.dateDepartDate}</p>
									</td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

		</div>
	</div>
</head>

<script src="assets/js/jquery.js"></script>
<script src="/delibdesign/js/Search/script.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/bootsnav.js"></script>
<script src="assets/js/jquery.filterizr.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
<script src="assets/js/jquery-ui.min.js"></script>
<script src="assets/js/jquery.counterup.min.js"></script>
<script src="assets/js/waypoints.min.js"></script>
<script src="assets/js/owl.carousel.min.js"></script>
<script src="assets/js/jquery.sticky.js"></script>
<script src="assets/js/datepicker.js"></script>
<script src="assets/js/custom.js"></script>
<script src="js/home.js"></script>
<script>
	/**
	 *   I don't recommend using this plugin on large tables, I just wrote it to make the demo useable. It will work fine for smaller tables 
	 *   but will likely encounter performance issues on larger tables.
	 *
	 *		<input type="text" class="form-control" id="dev-table-filter" data-action="filter" data-filters="#dev-table" placeholder="Filter Developers" />
	 *		$(input-element).filterTable()
	 *		
	 *	The important attributes are 'data-action="filter"' and 'data-filters="#table-selector"'
	 */
	(function() {
		'use strict';
		var $ = jQuery;
		$.fn
				.extend({
					filterTable : function() {
						return this
								.each(function() {
									$(this)
											.on(
													'keyup',
													function(e) {
														$(
																'.filterTable_no_results')
																.remove();
														var $this = $(this), search = $this
																.val()
																.toLowerCase(), target = $this
																.attr('data-filters'), $target = $(target), $rows = $target
																.find('tbody tr');

														if (search == '') {
															$rows.show();
														} else {
															$rows
																	.each(function() {
																		var $this = $(this);
																		$this
																				.text()
																				.toLowerCase()
																				.indexOf(
																						search) === -1 ? $this
																				.hide()
																				: $this
																						.show();
																	})
															if ($target
																	.find(
																			'tbody tr:visible')
																	.size() === 0) {
																var col_count = $target
																		.find(
																				'tr')
																		.first()
																		.find(
																				'td')
																		.size();
																var no_results = $('<tr class="filterTable_no_results"><td colspan="'+col_count+'">No results found</td></tr>')
																$target
																		.find(
																				'tbody')
																		.append(
																				no_results);
															}
														}
													});
								});
					}
				});
		$('[data-action="filter"]').filterTable();
	})(jQuery);

	$(function() {
		// attach table filter plugin to inputs
		$('[data-action="filter"]').filterTable();

		$('.container').on('click', '.panel-heading span.filter', function(e) {
			var $this = $(this), $panel = $this.parents('.panel');

			$panel.find('.panel-body').slideToggle();
			if ($this.css('display') != 'none') {
				$panel.find('.panel-body input').focus();
			}
		});
		$('[data-toggle="tooltip"]').tooltip();
	})
</script>
</html>
