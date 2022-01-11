<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
	prefix="layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<layout:extends name="base.jsp">
	<layout:put block="content" type="REPLACE">
		<!--about-us start -->
		<section id="home" class="about-us">
			<div class="container">
				<div class="about-us-content">
					<div class="row">
						<div class="col-sm-12">
							<div class="single-about-us">
								<div class="about-us-txt">
									<h2>Explore the Beauty of the Beautiful World</h2>
									<div class="about-btn">
										<button class="about-view">explore now</button>
									</div>
									<!--/.about-btn-->
								</div>
								<!--/.about-us-txt-->
							</div>
							<!--/.single-about-us-->
						</div>
						<!--/.col-->
						<div class="col-sm-0">
							<div class="single-about-us"></div>
							<!--/.single-about-us-->
						</div>
						<!--/.col-->
					</div>
					<!--/.row-->
				</div>
				<!--/.about-us-content-->
			</div>
			<!--/.container-->

		</section>
		<!--/.about-us-->
		<!--about-us end -->

		<jsp:include page="search.jsp" />
		<!--/.travel-box-->
		<!--travel-box end-->

		<!--service start-->
		<section id="service" class="service">
			<div class="container">

				<div class="service-counter text-center">

					<div class="col-md-4 col-sm-4">
						<div class="single-service-box">
							<div class="service-img">
								<img src="assets/images/service/s1.png" alt="service-icon" />
							</div>
							<!--/.service-img-->
							<div class="service-content">
								<h2>
									<a href="#"> amazing tour packages </a>
								</h2>
								<p>Duis aute irure dolor in velit esse cillum dolore eu
									fugiat nulla.</p>
							</div>
							<!--/.service-content-->
						</div>
						<!--/.single-service-box-->
					</div>
					<!--/.col-->

					<div class="col-md-4 col-sm-4">
						<div class="single-service-box">
							<div class="service-img">
								<img src="assets/images/service/s2.png" alt="service-icon" />
							</div>
							<!--/.service-img-->
							<div class="service-content">
								<h2>
									<a href="#"> book top class hotel </a>
								</h2>
								<p>Duis aute irure dolor in velit esse cillum dolore eu
									fugiat nulla.</p>
							</div>
							<!--/.service-content-->
						</div>
						<!--/.single-service-box-->
					</div>
					<!--/.col-->

					<div class="col-md-4 col-sm-4">
						<div class="single-service-box">
							<div class="statistics-img">
								<img src="assets/images/service/s3.png" alt="service-icon" />
							</div>
							<!--/.service-img-->
							<div class="service-content">

								<h2>
									<a href="#"> online flight booking </a>
								</h2>
								<p>Duis aute irure dolor in velit esse cillum dolore eu
									fugiat nulla.</p>
							</div>
							<!--/.service-content-->
						</div>
						<!--/.single-service-box-->
					</div>
					<!--/.col-->

				</div>
				<!--/.statistics-counter-->
			</div>
			<!--/.container-->

		</section>
		<!--/.service-->
		<!--service end-->

		<!--galley start-->
		<section id="gallery" class="gallery">
			<div class="container">
				<div class="gallery-details">
					<div class="gallary-header text-center">
						<h2>top destination</h2>
						<p>Duis aute irure dolor in velit esse cillum dolore eu fugiat
							nulla.</p>
					</div>
					<!--/.gallery-header-->
					<div class="gallery-box">
						<div class="gallery-content">
							<div class="filtr-container">
								<div class="row">

									<div class="col-md-6">
										<div class="filtr-item">
											<img src="assets/images/gallary/g1.jpg" alt="portfolio image" />
											<div class="item-title">
												<a href="#"> china </a>
												<p>
													<span>${China} tours</span>
												</p>
											</div>
											<!-- /.item-title -->
										</div>
										<!-- /.filtr-item -->
									</div>
									<!-- /.col -->

									<div class="col-md-6">
										<div class="filtr-item">
											<img src="assets/images/gallary/g2.jpg" alt="portfolio image" />
											<div class="item-title">
												<a href="#"> venuzuala </a>
												<p>
													<span>${Venuzuala} tours</span>
												</p>
											</div>
											<!-- /.item-title-->
										</div>
										<!-- /.filtr-item -->
									</div>
									<!-- /.col -->

									<div class="col-md-4">
										<div class="filtr-item">
											<img src="assets/images/gallary/g3.jpg" alt="portfolio image" />
											<div class="item-title">
												<a href="#"> brazil </a>
												<p>
													<span>${Brazil} tours</span>
												</p>
											</div>
											<!-- /.item-title -->
										</div>
										<!-- /.filtr-item -->
									</div>
									<!-- /.col -->

									<div class="col-md-4">
										<div class="filtr-item">
											<img src="assets/images/gallary/g4.jpg" alt="portfolio image" />
											<div class="item-title">
												<a href="#"> australia </a>
												<p>
													<span>${Australia} tours</span>
												</p>
											</div>
											<!-- /.item-title-->
										</div>
										<!-- /.filtr-item -->
									</div>
									<!-- /.col -->

									<div class="col-md-4">
										<div class="filtr-item">
											<img src="assets/images/gallary/g5.jpg" alt="portfolio image" />
											<div class="item-title">
												<a href="#"> netharland </a>
												<p>
													<span>${Netharland} tours</span>
												</p>
											</div>
											<!-- /.item-title-->
										</div>
										<!-- /.filtr-item -->
									</div>
									<!-- /.col -->

									<div class="col-md-8">
										<div class="filtr-item">
											<img src="assets/images/gallary/g6.jpg" alt="portfolio image" />
											<div class="item-title">
												<a href="#"> turkey </a>
												<p>
													<span>${Turkey} tours</span>
												</p>
											</div>
											<!-- /.item-title-->
										</div>
										<!-- /.filtr-item -->
									</div>
									<!-- /.col -->

								</div>
								<!-- /.row -->

							</div>
							<!-- /.filtr-container-->
						</div>
						<!-- /.gallery-content -->
					</div>
					<!--/.galley-box-->
				</div>
				<!--/.gallery-details-->
			</div>
			<!--/.container-->

		</section>
		<!--/.gallery-->
		<!--gallery end-->

		<!--discount-offer start-->
		<section class="discount-offer">
			<c:if test="${voyageReduction ne null }">
				<div class="container">
					<input type="hidden" name="timelong" value="${timelong}" />
					<div class="row">
						<div class="col-sm-12">
							<div class="dicount-offer-content text-center">
								<h2>Notre offre est près de finir
									${voyageReduction.reduction}% Discount</h2>
								<div class="campaign-timer">
									<div id="timer">
										<div class="time time-after" id="days">
											<span></span>
										</div>
										<!--/.time-->
										<div class="time time-after" id="hours"></div>
										<!--/.time-->
										<div class="time time-after" id="minutes"></div>
										<!--/.time-->
										<div class="time" id="seconds"></div>
										<!--/.time-->
									</div>
									<!--/.timer-->
								</div>
								<!--/.campaign-timer-->
								<div class="about-btn">
									<button onclick="addToChart(${voyageReduction.id})"
										class="about-view discount-offer-btn">join now</button>
								</div>
								<!--/.about-btn-->


							</div>
							<!-- /.dicount-offer-content-->
						</div>
						<!-- /.col-->
					</div>
					<!-- /.row-->
				</div>
				<!-- /.container-->
			</c:if>
		</section>

		<!-- /.discount-offer-->
		<!--discount-offer end-->

		<!--packages start-->
		<section id="pack" class="packages">
			<jsp:include page="packages.jsp" />
		</section>
		<!--/.packages-->
		<!--packages end-->

		<!-- testemonial Start -->
		<section class="testemonial">

			<jsp:include page="equipes.jsp" />
		</section>

		<!--/.testimonial-->
		<!-- testemonial End -->


		<!--special-offer start-->
		<section id="spo" class="special-offer"
			style="background:url(data:image/jpeg;base64,${voyageReduction.banner}) no-repeat center;">
			<c:if test="${voyageReduction ne null}">
				<jsp:include page="reduction.jsp"></jsp:include>
			</c:if>

		</section>
		<!--/.special-offer end-->
		<!--special-offer end-->

		<jsp:include page="trends.jsp"/>


		<!--subscribe start-->
		<section id="subs" class="subscribe">
			<div class="container">
				<div class="subscribe-title text-center">
					<h2>Join our Subscribers List to Get Regular Update</h2>
					<p>Subscribe Now. We will send you Best offer for your Trip</p>
				</div>
				<form>
					<div class="row">
						<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
							<div class="custom-input-group">
								<input type="email" class="form-control"
									placeholder="Contact us" disabled>
								<button formAction="mailto:ziadbougrine@gmail.com" class="appsLand-btn subscribe-btn">Mail to</button>
								<div class="clearfix"></div>
								<i class="fa fa-envelope"></i>
							</div>

						</div>
					</div>
				</form>
			</div>

		</section>
		<!--subscribe end-->
	</layout:put>
	<layout:put block="scriptsfile">
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
		<script src="/delibdesign/js/Reservation/template.js"></script>

		<script src="js/home.js"></script>
	</layout:put>
	<layout:put block="cssfiles">
		<link rel="stylesheet"
			href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="/delibdesign/css/reservation/style.css" />
		
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
	</layout:put>
	<layout:put block="modalFiles">
		<div id="addImageModal" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Panier</h4>
					</div>
					<div class="modal-body">
						<div id="carouselExampleControls" class="carousel slide"
							data-ride="carousel">
							<div id="galerie" class="carousel-inner">
								<div class="carousel-item active">
									<img class="d-block w-100" src="/images/notfound.jpg"
										alt="First slide">
								</div>
							</div>
							<a class="carousel-control-prev" href="#carouselExampleControls"
								role="button" data-slide="prev"> <span
								class="carousel-control-prev-icon" aria-hidden="true"></span> <span
								class="sr-only">Previous</span>
							</a> <a class="carousel-control-next" href="#carouselExampleControls"
								role="button" data-slide="next"> <span
								class="carousel-control-next-icon" aria-hidden="true"></span> <span
								class="sr-only">Next</span>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</layout:put>
</layout:extends>