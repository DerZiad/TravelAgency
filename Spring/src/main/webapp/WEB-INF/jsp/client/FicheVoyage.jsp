<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>WIEBATOUTA</title>
<meta content="" name="description">
<meta content="" name="keywords">
<link rel="shortcut icon" type="image/icon"
	href="/assets/logo/favicon.png" />
<!-- Favicons -->
<link href="/css/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Vendor CSS Files -->
<link href="/css/assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/css/assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="/css/assets/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet">
<link href="/css/assets/vendor/swiper/swiper-bundle.min.css"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link href="/css/assets/css/style.css" rel="stylesheet">

<!-- =======================================================
  * Template Name: DevFolio - v4.7.1
  * Template URL: https://bootstrapmade.com/devfolio-bootstrap-portfolio-html-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

	<!-- ======= Header ======= -->
	<header id="header" class="fixed-top">
		<div
			class="container d-flex align-items-center justify-content-between">

			<h1 class="logo">
				<a href="/">WIEBATOUTA</a>
			</h1>
			<nav id="navbar" class="navbar">
				<ul>
					<li><a class="nav-link scrollto " href="/">Home</a></li>
					<li><a class="nav-link scrollto" href="/#about">About</a></li>
					<li><a class="nav-link scrollto" href="/#pack">Destination</a></li>
					<li><a class="nav-link scrollto " href="/#spo">Special
							offers</a></li>
					<c:if test="${not authentificated}">
						<li class="btn btn-primary"><a href="/login">Login</a></li>
						<li class="btn btn-primary"><a href="/signup">Sign up</a></li>
					</c:if>
					<c:if test="${authentificated}">
						<input type="hidden" name="username" value="${username}" />
						<input type="hidden" name="idPerson" value="${idPerson}" />
						<li><a href="/panier" data-toggle="modal"> <img
								src="https://img.icons8.com/external-vitaliy-gorbachev-blue-vitaly-gorbachev/60/000000/external-shopping-cart-cyber-monday-vitaliy-gorbachev-blue-vitaly-gorbachev.png"
								style="height: 20px; width: 20px;" /> <span
								style="margin-left: 10px;" id="numberPanier"></span><input
								type="hidden" name="reservationNumber"
								value="${reservationNumber}" />
						</a></li>

						<li class="btn btn-primary"><a href="/logout">Deconnecter
								<br> ${username}
						</a></li>

					</c:if>
				</ul>
				<i class="bi bi-list mobile-nav-toggle"></i>
			</nav>
			<!-- .navbar -->


		</div>
	</header>
	<!-- End Header -->

	<div class="hero hero-single route bg-image"
		style="background-image: url(data:image/jpeg;base64,${voyage.banner})">
		<div class="overlay-mf"></div>
		<div class="hero-content display-table">
			<div class="table-cell">
				<div class="container">
					<h2 class="hero-title mb-4">${voyage.titre}</h2>
					<ol class="breadcrumb d-flex justify-content-center">
						<li class="breadcrumb-item"><a href="/">Home</a></li>
					</ol>
				</div>
			</div>
		</div>
	</div>

	<main id="main">

		<!-- ======= Portfolio Details Section ======= -->
		<section id="portfolio-details" class="portfolio-details">
			<div class="container">

				<div class="row gy-4">

					<div class="col-lg-8">
						<div class="portfolio-details-slider swiper">
							<div class="swiper-wrapper align-items-center">

								<c:forEach var="picture" items="${voyage.pictures}">
									<div class="swiper-slide">
										<img src="data:image/jpeg;base64,${picture.base64}"
											alt="voyage">
									</div>
								</c:forEach>
							</div>
							<div class="swiper-pagination"></div>
						</div>
					</div>

					<div class="col-lg-4">
						<div class="portfolio-info">
							<h3>Project information</h3>
							<ul>
								<li><strong>Category :</strong>${voyage.typeVoyage.toString()}</li>
								<li><strong>Nombre kilomètres : </strong>${voyage.nbKilometres}</li>
								<li><strong>Nombre personnes : </strong>${voyage.nombrePersonneTotal}</li>
								<li><strong>Nombre places plein : </strong>${voyage.nbrPersonnes}</li>
								<li><strong>Date départ :</strong>${voyage.dateDepartDate}</li>
								<li><strong>Date Arrivée :</strong>${voyage.dateArriveeDate}</li>
								<li><strong>Equipe :</strong>${voyage.equipe.label} :
									${voyage.equipe.personne.nom} ${voyage.equipe.personne.prenom}</li>
								<li><strong>Prix :</strong>${voyage.prix}</li>
								<li><strong>Age maximal :</strong>${voyage.ageMax}</li>
								<li><strong>Age minimal :</strong>${voyage.ageMin}</li>
								<li><strong>Review :</strong>${voyage.review}</li>
								<c:if test="${voyage.isSolded() }">
									<li style="color: red"><strong>Solde :</strong>${voyage.reduction}%</li>
								</c:if>
								<li><button class="btn btn-primary" onclick="addToChart(${voyage.id})">Book now</button></li>
							</ul>
						</div>
						<div class="portfolio-description">
							<h2>${voyage.destination}</h2>
							<p>${voyage.description}</p>
						</div>
					</div>

				</div>

			</div>
		</section>
		<section id="work" class="portfolio-mf sect-pt4 route">
			<div class="container">
				<div class="row">
					<div class="col-sm-12">
						<div class="title-box text-center">
							<h3 class="title-a">Hoteles</h3>

							<div class="line-mf"></div>
						</div>
					</div>
				</div>
				<div class="row">
					<c:forEach items="${voyage.hoteles}" var="hotel">
						<div class="col-md-4">
							<div class="work-box">
								<div class="work-img">
									<img src="data:image/jpeg;base64,${voyage.header}" alt=""
										class="img-fluid">
								</div>
								<div class="work-content">
									<div class="row">
										<div class="col-sm-8">
											<h2 class="w-title">${hotel.nomHotel}</h2>
											<div class="w-more">
												<span class="w-ctegory">${hotel.nombreEtoile}</span> / <span
													class="w-date">${hotel.ville.label}</span>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<div></div>
		</section>

		<section id="work" class="portfolio-mf sect-pt4 route">
			<div class="container">
				<div class="row">
					<div class="col-sm-12">
						<div class="title-box text-center">
							<h3 class="title-a">Themes</h3>
							<div class="line-mf"></div>
						</div>
					</div>
				</div>
				<div class="row">
					<c:forEach items="${voyage.themes}" var="theme">
						<div class="col-md-4">
							<div class="work-box">
								<div class="work-img">
									<img src="data:image/jpeg;base64,${theme.base64}" alt=""
										class="img-fluid">
								</div>
								<div class="work-content">
									<div class="row">
										<div class="col-sm-8">
											<h2 class="w-title$">${theme.label}</h2>
											<div class="w-more">
												<span class="w-ctegory">${theme.description}</span>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<div></div>
		</section>
		<section id="work" class="portfolio-mf sect-pt4 route">
			<div class="container">
				<div class="row">
					<div class="col-sm-12">
						<div class="title-box text-center">
							<h3 class="title-a">Activités</h3>
							<div class="line-mf"></div>
						</div>
					</div>
				</div>
				<div class="row">
					<c:forEach items="${voyage.activites}" var="activite">
						<div class="col-md-4">
							<div class="work-box">
								<div class="work-content">
									<div class="row">
										<div class="col-sm-8">
											<h2 class="w-title">${activite.nomActivite}</h2>
											<c:forEach items="${acitvite.sousActivites}" var="sactivite">
												<div class="w-more">
													<span class="w-ctegory">${sactivite.titre}</span>
												</div>
											</c:forEach>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			</div>
			<div></div>
		</section>
		<!-- End Portfolio Details Section -->

	</main>
	<!-- End #main -->

	<!-- ======= Footer ======= -->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<div class="copyright-box">
						<p class="copyright">
							&copy; Copyright <strong>DevFolio</strong>. All Rights Reserved
						</p>
						<div class="credits">
							<!--
              All the links in the footer should remain intact.
              You can delete the links only if you purchased the pro version.
              Licensing information: https://bootstrapmade.com/license/
              Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=DevFolio
            -->
							Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- End  Footer -->

	<div id="preloader"></div>
	<a href="#"
		class="back-to-top d-flex align-items-center justify-content-center"><i
		class="bi bi-arrow-up-short"></i></a>

	<!-- Vendor JS Files -->
	<script src="/css/assets/vendor/purecounter/purecounter.js"></script>
	<script src="/css/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="/css/assets/vendor/glightbox/js/glightbox.min.js"></script>
	<script src="/css/assets/vendor/swiper/swiper-bundle.min.js"></script>
	<script src="/css/assets/vendor/typed.js/typed.min.js"></script>
	<script src="/css/assets/vendor/php-email-form/validate.js"></script>
			<script src="/assets/js/jquery.js"></script>
	
	<!-- Template Main JS File -->
	<script src="/css/assets/js/main.js"></script>
	<script>
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
	</script>

</body>

</html>