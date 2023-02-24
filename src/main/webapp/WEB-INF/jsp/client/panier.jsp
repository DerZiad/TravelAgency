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
html {
	background: #bbc3c6;
	font: 62.5%/1.5em "Trebuchet Ms", helvetica;
}

* {
	box-sizing: border-box;
	-webkit-font-smoothing: antialiased;
	font-smoothing: antialiased;
}

@font-face {
	font-family: 'Shopper';
	src: url('http://www.shopperfont.com/font/Shopper-Std.ttf');
}

.shopper {
	text-transform: lowercase;
	font: 2em 'Shopper', sans-serif;
	line-height: 0.5em;
	display: inline-block;
}

h1 {
	text-transform: uppercase;
	font-weight: bold;
	font-size: 2.5em;
}

p {
	font-size: 1.5em;
	color: #8a8a8a;
}

input {
	border: 0.3em solid #bbc3c6;
	padding: 0.5em 0.3em;
	font-size: 1.4em;
	color: #8a8a8a;
	text-align: center;
}

img {
	max-width: 9em;
	width: 100%;
	overflow: hidden;
	margin-right: 1em;
}

a {
	text-decoration: none;
}

.container {
	max-width: 75em;
	width: 95%;
	margin: 40px auto;
	overflow: hidden;
	position: relative;
	border-radius: 0.6em;
	background: #ecf0f1;
	box-shadow: 0 0.5em 0 rgba(138, 148, 152, 0.2);
}

.heading {
	padding: 1em;
	position: relative;
	z-index: 1;
	color: #f7f7f7;
	background: #f34d35;
}

.cart {
	margin: 2.5em;
	overflow: hidden;
}

.cart.is-closed {
	height: 0;
	margin-top: -2.5em;
}

.table {
	background: #ffffff;
	border-radius: 0.6em;
	overflow: hidden;
	clear: both;
	margin-bottom: 1.8em;
}

.layout-inline>* {
	display: inline-block;
}

.align-center {
	text-align: center;
}

.th {
	background: #f34d35;
	color: #fff;
	text-transform: uppercase;
	font-weight: bold;
	font-size: 1.5em;
}

.tf {
	background: #f34d35;
	text-transform: uppercase;
	text-align: right;
	font-size: 1.2em;
}

.tf p {
	color: #fff;
	font-weight: bold;
}

.col {
	padding: 1em;
	width: 12%;
}

.col-pro {
	width: 44%;
}

.col-pro>* {
	vertical-align: middle;
}

.col-qty {
	text-align: center;
	width: 17%;
}

.col-numeric p {
	font: bold 1.8em helvetica;
}

.col-total p {
	color: #12c8b1;
}

.tf .col {
	width: 20%;
}

.row>div {
	vertical-align: middle;
}

.row-bg2 {
	background: #f7f7f7;
}

.visibility-cart {
	position: absolute;
	color: #fff;
	top: 0.5em;
	right: 0.5em;
	font: bold 2em arial;
	border: 0.16em solid #fff;
	border-radius: 2.5em;
	padding: 0 0.22em 0 0.25em;
}

.col-qty>* {
	vertical-align: middle;
}

.col-qty>input {
	max-width: 2.6em;
}

a.qty {
	width: 1em;
	line-height: 1em;
	border-radius: 2em;
	font-size: 2.5em;
	font-weight: bold;
	text-align: center;
	background: #43ace3;
	color: #fff;
}

a.qty:hover {
	background: #3b9ac6;
}

.btn {
	padding: 10px 30px;
	border-radius: 0.3em;
	font-size: 1.4em;
	font-weight: bold;
	background: #43ace3;
	color: #fff;
	box-shadow: 0 3px 0 rgba(59, 154, 198, 1)
}

.btn:hover {
	box-shadow: 0 3px 0 rgba(59, 154, 198, 0)
}

.btn-update {
	float: right;
	margin: 0 0 1.5em 0;
}

.transition {
	transition: all 0.3s ease-in-out;
}

@media screen and ( max-width: 755px) {
	.container {
		width: 98%;
	}
	.col-pro {
		width: 35%;
	}
	.col-qty {
		width: 22%;
	}
	img {
		max-width: 100%;
		margin-bottom: 1em;
	}
}

@media screen and ( max-width: 591px) {
}
</style>
</head>

<body>
	<div class="topnav">
		<a class="active" href="/">Home</a><a
			href="/#blog">Contact</a>
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
	<div class="heading">
		<h1>
			<span class="shopper">s</span> Shopping Cart
		</h1>
	</div>

	<div class="cart transition is-open">
		<table class="table">
			<thead class="mb-0 table table-striped">
				<th>Picture</th>
				<th>Titre</th>
				<th>Description</th>
				<th>Destination</th>
				<th>Price</th>
				<th>Date depart</th>
			</thead>
			<tbody>
				<c:forEach items="${reservations}" var="reserv">
					<tr>

						<td><img src="data:image/jpeg;base64,${reserv.voyage.header}"
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
						<td><a href="/panier/delete?idVoyage=${reserv.voyage.id}"
							class="delete">DROP</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div class="tf">
			<div class="row layout-inline">
				<div class="col">
					<p>Total</p>
				</div>
				<div class="col">${total}EUR</div>
			</div>
		</div>

		<a href="/panier/payer" class="btn btn-update">Payer</a>

	</div>
</body>
<script>
	$('.visibility-cart').on('click', function() {

		var $btn = $(this);
		var $cart = $('.cart');
		console.log($btn);

		if ($btn.hasClass('is-open')) {
			$btn.removeClass('is-open');
			$btn.text('O')
			$cart.removeClass('is-open');
			$cart.addClass('is-closed');
			$btn.addClass('is-closed');
		} else {
			$btn.addClass('is-open');
			$btn.text('X')
			$cart.addClass('is-open');
			$cart.removeClass('is-closed');
			$btn.removeClass('is-closed');
		}

	});

	// SHOPPING CART PLUS OR MINUS
	$('a.qty-minus').on('click', function(e) {
		e.preventDefault();
		var $this = $(this);
		var $input = $this.closest('div').find('input');
		var value = parseInt($input.val());

		if (value > 1) {
			value = value - 1;
		} else {
			value = 0;
		}

		$input.val(value);

	});

	$('a.qty-plus').on('click', function(e) {
		e.preventDefault();
		var $this = $(this);
		var $input = $this.closest('div').find('input');
		var value = parseInt($input.val());

		if (value < 100) {
			value = value + 1;
		} else {
			value = 100;
		}

		$input.val(value);
	});

	// RESTRICT INPUTS TO NUMBERS ONLY WITH A MIN OF 0 AND A MAX 100
	$('input').on('blur', function() {

		var input = $(this);
		var value = parseInt($(this).val());

		if (value < 0 || isNaN(value)) {
			input.val(0);
		} else if (value > 100) {
			input.val(100);
		}
	});
</script>
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
</html>
