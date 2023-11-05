<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
	prefix="layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="fr">

<head>

	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Language" content="en">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<title>WIEBATOUTA</title>
	<link rel="shortcut icon" type="image/icon" href="assets/logo/favicon.png"/>
	<meta name="viewport"
		  content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no" />
	<meta name="description"
		  content="This is an example dashboard created using build-in elements and components.">
	<meta name="msapplication-tap-highlight" content="no">
	<link href="/delibdesign/css/main.css" rel="stylesheet">
	<link rel="stylesheet"
		  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<layout:block name="cssfiles"></layout:block>
	<script type="text/javascript"
			src="https://www.gstatic.com/charts/loader.js"></script>
	<script type="text/javascript">
		google.charts.load('current', {
			'packages' : [ 'bar' ]
		});
		google.charts.setOnLoadCallback(drawChart);




		function drawChart() {
			var data = google.visualization.arrayToDataTable([
				[ 'Pays', 'Reservations Confirmed'],
				[ 'Confirmed Reservation', ${reservationsdonenumber}],
				[ 'Not Confirmed Reservation', ${reservationsnotdonenumber}]]);

			var options = {
				chart : {
					title : 'Reservations Chart',
					subtitle : 'Here, you\'ll find a chart displaying all reservations, categorized by whether they have confirmed the reservation or not, based on the respective country.',
				}
			};

			var chart = new google.charts.Bar(document
					.getElementById('columnchart_material'));

			chart.draw(data, google.charts.Bar.convertOptions(options));
		}
	</script>



</head>


<body>
	<div class="app-container app-theme-white body-tabs-shadow fixed-sidebar fixed-header">
		
		
		<!-- header / search-bar -->
		<div class="app-header header-shadow" style="background: radial-gradient(circle at 10% 20%, #FD6585 0%,  #FFD3A5 90%);">

			<div class="app-header__mobile-menu">
				<div>
					<button type="button"
							class="hamburger hamburger--elastic mobile-toggle-nav">
				<span class="hamburger-box"> <span class="hamburger-inner"></span>
				</span>
					</button>
				</div>
			</div>
			<div class="app-header__content">
				<div class="app-header-right">
					<div class="header-btn-lg pr-0">
						<div class="widget-content p-0">
							<div class="widget-content-wrapper">
								<div class="widget-content-left">
									<div class="btn-group">
										<a data-toggle="dropdown" aria-haspopup="true"
										   aria-expanded="false" class="p-0 btn"> <img width="42"
																					   class="rounded-circle"
																					   src="assets/images/avatars/default-profile.jpg" alt=""> <i
												class="fa fa-angle-down ml-2 opacity-8"></i>
										</a>
										<div tabindex="-1" role="menu" aria-hidden="true"
											 class="dropdown-menu dropdown-menu-right">
											<a href="/logout" tabindex="0" class="dropdown-item">Logout</a>
										</div>
									</div>
								</div>
								<div class="widget-content-left  ml-3 header-user-info">
									<div class="widget-heading">Admin</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		
		<div class="app-main">
			
			<!-- nav-bar -->
			<div class="app-sidebar sidebar-shadow " style="background: radial-gradient(circle at 10% 20%, #FFD3A5 0%, #FD6585 90%);">
				<div class="app-header__logo">
					<div class="logo-src"></div>
					<div class="header__pane ml-auto">
						<div>
							<button type="button"
									class="hamburger close-sidebar-btn hamburger--elastic"
									data-class="closed-sidebar">
					<span class="hamburger-box"> <span class="hamburger-inner"></span>
					</span>
							</button>
						</div>
					</div>
				</div>
				<div class="app-header__mobile-menu">
					<div>
						<button type="button">
				<span class="hamburger-box"> <span class="hamburger-inner"></span>
				</span>
						</button>
					</div>
				</div>
				<div class="app-header__menu">
		<span>
			<button type="button"
					class="btn-icon btn-icon-only btn btn-primary btn-sm mobile-toggle-header-nav">
				<span class="btn-icon-wrapper"> <i
						class="fa fa-ellipsis-v fa-w-6"></i>
				</span>
			</button>
		</span>
				</div>
				<div class="scrollbar-sidebar">
					<div class="app-sidebar__inner">
						<ul class="vertical-nav-menu">
							<li class="app-sidebar__heading">WIEBATOUTA Admin Panel</li>
							<li><a href="/admin" class="${dashboard}"> <i
									class="metismenu-icon pe-7s-rocket"></i> Dashboard
							</a></li>

							<li><a href="/admin/lieux" class="${lieuAjout}"> <i
									class="metismenu-icon pe-7s-rocket"></i> Destinations
							</a></li>

							<li><a href="/admin/theme" class="${themeAjout}"> <i
									class="metismenu-icon pe-7s-rocket"></i> Topics
							</a></li>

							<li><a href="/admin/hotel" class="${hotelActive}"> <i
									class="metismenu-icon pe-7s-rocket"></i> Hotels
							</a></li>

							<li><a href="/admin/voyage" class="${voyage}"> <i
									class="metismenu-icon pe-7s-rocket"></i> Travels
							</a></li>

							<li><a href="/admin/reservation" class="${reservationAjout}"> <i
									class="metismenu-icon pe-7s-rocket"></i> Reservations
							</a></li>

							<li><a href="/admin/ressources" class="${ressourceHumaine}"> <i
									class="metismenu-icon pe-7s-rocket"></i> Human Resources
							</a></li>

							<li><a href="/admin/historiques" class="${pathhistory}"> <i
									class="metismenu-icon pe-7s-rocket"></i> Actions History
							</a></li>
						</ul>
					</div>
				</div>
			</div>
			
			
			<div class="app-main__outer" style="background: white">
				<div class="app-main__inner">
				
				
					<!-- content -->
					<layout:block name="content"></layout:block>
				
					
				</div>
				<div class="app-wrapper-footer">
					
					
					<!-- footer -->
					<div class="app-footer">
						<div class="app-footer__inner">
							<div class="col-xs-1 text-center">
								<ul class="nav">
									<li class="nav-item"><a href="javascript:void(0);"
															class="nav-link"> Université Moulay Ismaïl </a></li>
								</ul>
							</div>
						</div>
					</div>
					
				</div>
			</div>
			
			<!-- scripts -->
		</div>
		<!-- Modals -->
		<layout:block name="modals"></layout:block>
	</div>
	<script type="text/javascript" src="/delibdesign/assets/scripts/main.js"></script>
	<script src="http://maps.google.com/maps/api/js?sensor=true"></script>
	<link rel="stylesheet"
		  href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
	<link rel="stylesheet"
		  href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link rel="stylesheet"
		  href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet"
		  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/selectize.js/0.12.6/js/standalone/selectize.min.js" integrity="sha256-+C0A5Ilqmu4QcSPxrlGpaZxJ04VjsRjKu+G82kl5UJk=" crossorigin="anonymous"></script>

	<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<layout:block name="scriptsfile"></layout:block>
	
</body>
</html>
