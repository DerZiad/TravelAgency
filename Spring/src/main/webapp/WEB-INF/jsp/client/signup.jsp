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

</head>

<body>
	<div class="topnav">
		<a class="active" href="#home">Home</a> <a href="#about">About</a> <a
			href="#contact">Contact</a>
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
	<div class="page-wrapper bg-blue p-t-180 p-b-100 font-robo">
		<div class="wrapper wrapper--w960">
			<div class="card card-2">
				<div class="card-heading">
				
					<!--  <img alt="" src="/images/index.jpg"  height=1180> -->
				</div>
				<div class="card-body">
					<h2 class="title">SIGN UP</h2>
					<form action="/signup" method="POST"
						enctype="multipart/form-data">
						<!--       <div class="input-group">
                           <input class="input--style-2" type="text" placeholder="Nom" name="name">
                       </div>

                       <div class="input-group">
                           <input class="input--style-2" type="text" placeholder="Name" name="name">
                       </div>  -->


						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">
									<input class="input--style-2" type="text" placeholder="Nom"
										name="NomFr">

								</div>
							</div>
							<div class="col-2">
								<div class="input-group">
									<input class="input--style-2" type="text" placeholder="Prenom"
										name="PrenomFr">
								</div>
							</div>
						</div>



						<!-- class="input--style-2 js-datepicker" -->
						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">
									<input type="date" placeholder="Date de naissance" name="dateN">
								</div>
							</div>
							<div class="col-2">
								<div class="input-group">
									<div class="rs-select2 js-select-simple select--no-search">
										<select name="sexe">
											<option  selected="selected">Sexe</option>
											<option value="HOMME">M</option>
											<option value="FEMME">F</option>
										</select>
										<div class="select-dropdown"></div>
									</div>
								</div>
							</div>
						</div>
						<div class="input-group">
							<div  >
								<select name="lieuN_fr">
									<option  selected="selected">Lieu
										de naissance</option>
									<c:forEach var="country" items="${countries}">
										<option value="${country.valueCountry}">${country.valueCountry}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-2">
							<div class="input-group">
								<div class="rs-select2 js-select-simple select--no-search">
									<select name="marie">
										<option disabled="disabled" selected="selected">Marie</option>
										<option value="oui">OUI</option>
										<option value="non">NON</option>
									</select>
									<div class="select-dropdown"></div>
								</div>
							</div>
						</div>
						<div class="input-group">
							<div class="rs-select2 js-select-simple select--no-search">
								<div class="input-group">
									<input type="number" placeholder="Nombre d'enfants"
										name="nbenf">

								</div>
							</div>
						</div>
						<div class="input-group">
							<div class="rs-select2 js-select-simple select--no-search">
								<div class="input-group">
									<input type="text" placeholder="Numero de Telephone" name="tel">

								</div>
							</div>
						</div>
						

						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">
									<input class="input--style-2" type="text" placeholder="cin"
										name="cin">
								</div>
							</div>

						</div>


						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">

									<input type="email" id="email" name="email"
										placeholder="Enter your Email">
								</div>
							</div>
						</div>
						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">

									<input type="number" id="codep" name="codep"
										placeholder="Enter your Code Postal">
								</div>
							</div>
						</div>

						<div class="row row-space">
							<div class="col-2">
								<div class="input-group">
									<div class="rs-select2 js-select-simple select--no-search">
										<select name="etatPhy">
											<option selected="selected">Etat
												physique</option>
											<option value="Sain">Sain</option>
											<option value="DeplacementLimite">Déplacement limité</option>
											<option value="Handicape">Handicape</option>

											<option value="Autres">Autres</option>
										</select>
										<div class="select-dropdown"></div>
									</div>

								</div>
							</div>

							<div class="col-2">
								<div class="input-group">
									<div class="rs-select2 js-select-simple select--no-search">
										<select name="GroupSocio">
											<option  selected="selected">Groupe
												socioprofessionnel</option>
											<option value="AgriculExploi">Agriculteurs
												exploitants</option>
											<option value="Entreprise">
												Artisans, commerçants et chefs d’entreprise</option>
											<option
												value="cadreIntell">
												Cadres et professions intellectuelles supérieures</option>
											<option value="ProfInter">
												Professions intermédiaires</option>
											<option value="Employés">Employés</option>
											<option value="Ouvriers">Ouvriers</option>
											<option value="Retraités">Retraités</option>
											<option
												value="Autres">
												Autres personnes sans activité professionnelle</option>
											<option value="Autres">Autres</option>
										</select>
										<div class="select-dropdown"></div>
									</div>
								</div>
							</div>


						</div>



						<div class="input-group">

							<p class="input--style-2">Photo</p>

							<div class="rs-select2 js-select-simple select--no-search">

								<input type="file" id="avatar" name="photo"
									accept=".png, .jpg, .jpeg" placeholder="photo">
							</div>
						</div>




						<div class="p-t-30">
							<button class="login100-form-btn" type="submit">S'inscrire</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- Jquery JS-->
	<script src="/vendor/jquery/jquery.min.js"></script>
	<!-- Vendor JS-->
	<script src="/vendor/select2/select2.min.js"></script>
	<script src="/vendor/datepicker/moment.min.js"></script>
	<script src="/vendor/datepicker/daterangepicker.js"></script>
	<!-- Main JS-->
	<script src="/js/global.js"></script>

</body>

</html>
<!-- end document-->

