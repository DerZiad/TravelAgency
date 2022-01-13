<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
	prefix="layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="no-js" lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Rufina:400,700"
	rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900"
	rel="stylesheet" />
<link href="/css/like.css" rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>WIEBATOUTA</title>
<link rel="shortcut icon" type="image/icon"
	href="/assets/logo/favicon.png" />
<meta name="msapplication-tap-highlight" content="no">
<layout:block name="cssfiles"></layout:block>
<style>
	.liked{
		color:red;
	}
</style>
</head>
<script src="/js/home.js"></script>
<body>
	<!--[if lte IE 9]>
		<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade
			your browser</a> to improve your experience and security.</p>
		<![endif]-->

	<!-- main-menu Start -->
	<header class="top-area">
		<div class="header-area">
			<div class="container">
				<div class="row">
					<div class="col-sm-2">
						<div class="logo">
							<a href="/"> WIE<span>BATOUTA</span>
							</a>
						</div>
						<!-- /.logo-->
					</div>
					<!-- /.col-->
					<div class="col-sm-10">
						<div class="main-menu">

							<!-- Brand and toggle get grouped for better mobile display -->
							<div class="navbar-header">
								<button type="button" class="navbar-toggle"
									data-toggle="collapse" data-target=".navbar-collapse">
									<i class="fa fa-bars"></i>
								</button>
								<!-- / button-->
							</div>
							<!-- /.navbar-header-->
							<div class="collapse navbar-collapse">
								<ul class="nav navbar-nav navbar-right">
									<li class="smooth-menu"><a href="/">Home</a></li>
									<c:if test="${not isLogin}">
										<li class="smooth-menu"><a href="#gallery">Destination</a></li>
										<li class="smooth-menu"><a href="#pack">Packages </a></li>
										<li class="smooth-menu"><a href="#spo">Special Offers</a></li>
										<li class="dropdown"><a href="#" class="dropdown-toggle"
											data-toggle="dropdown">Themes <b class="caret"></b></a>
											<ul class="dropdown-menu"></ul>
										<li class="smooth-menu"><a href="#subs">subscription</a></li>
									</c:if>
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
										<li class="btn btn-primary"><a href="/mesreservations?page=0&size=3">Mes reservations</a></li>
										<li class="btn btn-primary"><a href="/logout">Deconnecter
												<br> ${username}
										</a></li>

									</c:if>

								</ul>
							</div>
							<!-- /.navbar-collapse -->
						</div>
						<!-- /.main-menu-->
					</div>
					<!-- /.col-->
				</div>
				<!-- /.row -->
				<div class="home-border"></div>
				<!-- /.home-border-->
			</div>
			<!-- /.container-->
		</div>
		<!-- /.header-area -->

	</header>
	<!-- /.top-area-->
	<!-- main-menu End -->



	<layout:block name="content"></layout:block>
	<!-- footer-copyright start -->
	<footer class="footer-copyright">
		<div class="container">
			<div class="footer-content">
				<div class="row">

					<div class="col-sm-3">
						<div class="single-footer-item">
							<div class="footer-logo">
								<a href="index.html"> tour<span>Nest</span>
								</a>
								<p>best travel agency</p>
							</div>
						</div>
						<!--/.single-footer-item-->
					</div>
					<!--/.col-->

					<div class="col-sm-3">
						<div class="single-footer-item">
							<h2>link</h2>
							<div class="single-footer-txt">
								<p>
									<a href="#">home</a>
								</p>
								<p>
									<a href="#">destination</a>
								</p>
								<p>
									<a href="#">spacial packages</a>
								</p>
								<p>
									<a href="#">special offers</a>
								</p>
								<p>
									<a href="#">blog</a>
								</p>
								<p>
									<a href="#">contacts</a>
								</p>
							</div>
							<!--/.single-footer-txt-->
						</div>
						<!--/.single-footer-item-->

					</div>
					<!--/.col-->

					<div class="col-sm-3">
						<div class="single-footer-item">
							<h2>popular destination</h2>
							<div class="single-footer-txt">
								<p>
									<a href="#">china</a>
								</p>
								<p>
									<a href="#">venezuela</a>
								</p>
								<p>
									<a href="#">brazil</a>
								</p>
								<p>
									<a href="#">australia</a>
								</p>
								<p>
									<a href="#">london</a>
								</p>
							</div>
							<!--/.single-footer-txt-->
						</div>
						<!--/.single-footer-item-->
					</div>
					<!--/.col-->

					<div class="col-sm-3">
						<div class="single-footer-item text-center">
							<h2 class="text-left">contacts</h2>
							<div class="single-footer-txt text-left">
								<p>+1 (300) 1234 6543</p>
								<p class="foot-email">
									<a href="#">info@tnest.com</a>
								</p>
								<p>North Warnner Park 336/A</p>
								<p>Newyork, USA</p>
							</div>
							<!--/.single-footer-txt-->
						</div>
						<!--/.single-footer-item-->
					</div>
					<!--/.col-->

				</div>
				<!--/.row-->

			</div>
			<!--/.footer-content-->
			<hr>
			<div class="foot-icons ">
				<ul class="footer-social-links list-inline list-unstyled">
					<li><a href="#" target="_blank" class="foot-icon-bg-1"><i
							class="fa fa-facebook"></i></a></li>
					<li><a href="#" target="_blank" class="foot-icon-bg-2"><i
							class="fa fa-twitter"></i></a></li>
					<li><a href="#" target="_blank" class="foot-icon-bg-3"><i
							class="fa fa-instagram"></i></a></li>
				</ul>
				<p>
					&copy; 2017 <a href="https://www.themesine.com">ThemeSINE</a>. All
					Right Reserved
				</p>

			</div>
			<!--/.foot-icons-->
			<div id="scroll-Top">
				<i class="fa fa-angle-double-up return-to-top" id="scroll-top"
					data-toggle="tooltip" data-placement="top" title=""
					data-original-title="Back to Top" aria-hidden="true"></i>
			</div>
			<!--/.scroll-Top-->
		</div>
		<!-- /.container-->

	</footer>
	<!-- /.footer-copyright-->
	<!-- footer-copyright end -->
	
	<layout:block name="scriptsfile">
		<script src="/delibdesign/js/Search/navbar.js"></script>
	</layout:block>
</body>

</html>
