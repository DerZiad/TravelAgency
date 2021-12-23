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

		<!--travel-box start-->
		<section class="travel-box">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="single-travel-boxes">
							<div id="desc-tabs" class="desc-tabs">

								<ul class="nav nav-tabs" role="tablist">

									<li role="presentation" class="active"><a href="#tours"
										aria-controls="tours" role="tab" data-toggle="tab"> <i
											class="fa fa-tree"></i> Voyages
									</a></li>
								</ul>

								<!-- Tab panes -->
								<div class="tab-content">

									<div role="tabpanel" class="tab-pane active fade in" id="tours">
										<div class="tab-para">

											<div class="row">
												<div class="col-lg-4 col-md-4 col-sm-12">
													<div class="single-tab-select-box">

														<h2>destination</h2>

														<div class="travel-select-icon">
															<select class="form-control ">

																<option value="default">enter your destination
																	country</option>
																<!-- /.option-->

																<option value="turkey">turkey</option>
																<!-- /.option-->

																<option value="russia">russia</option>
																<!-- /.option-->
																<option value="egept">egypt</option>
																<!-- /.option-->

															</select>
															<!-- /.select-->
														</div>
														<!-- /.travel-select-icon -->

														<div class="travel-select-icon">
															<select class="form-control ">

																<option value="default">enter your destination
																	location</option>
																<!-- /.option-->

																<option value="istambul">istambul</option>
																<!-- /.option-->

																<option value="mosko">mosko</option>
																<!-- /.option-->
																<option value="cairo">cairo</option>
																<!-- /.option-->

															</select>
															<!-- /.select-->
														</div>
														<!-- /.travel-select-icon -->

													</div>
													<!--/.single-tab-select-box-->
												</div>
												<!--/.col-->

												<div class="col-lg-2 col-md-3 col-sm-4">
													<div class="single-tab-select-box">
														<h2>check in</h2>
														<div class="travel-check-icon">
															<form action="#">
																<input type="text" name="check_in" class="form-control"
																	data-toggle="datepicker" placeholder="12 -01 - 2017 ">
															</form>
														</div>
														<!-- /.travel-check-icon -->
													</div>
													<!--/.single-tab-select-box-->
												</div>
												<!--/.col-->

												<div class="col-lg-2 col-md-3 col-sm-4">
													<div class="single-tab-select-box">
														<h2>check out</h2>
														<div class="travel-check-icon">
															<form action="#">
																<input type="text" name="check_out" class="form-control"
																	data-toggle="datepicker" placeholder="22 -01 - 2017 ">
															</form>
														</div>
														<!-- /.travel-check-icon -->
													</div>
													<!--/.single-tab-select-box-->
												</div>
												<!--/.col-->

												<div class="col-lg-2 col-md-1 col-sm-4">
													<div class="single-tab-select-box">
														<h2>duration</h2>
														<div class="travel-select-icon">
															<select class="form-control ">

																<option value="default">5</option>
																<!-- /.option-->

																<option value="10">10</option>
																<!-- /.option-->

																<option value="15">15</option>
																<!-- /.option-->
																<option value="20">20</option>
																<!-- /.option-->

															</select>
															<!-- /.select-->
														</div>
														<!-- /.travel-select-icon -->
													</div>
													<!--/.single-tab-select-box-->
												</div>
												<!--/.col-->

												<div class="col-lg-2 col-md-1 col-sm-4">
													<div class="single-tab-select-box">
														<h2>members</h2>
														<div class="travel-select-icon">
															<select class="form-control ">

																<option value="default">1</option>
																<!-- /.option-->

																<option value="2">2</option>
																<!-- /.option-->

																<option value="4">4</option>
																<!-- /.option-->
																<option value="8">8</option>
																<!-- /.option-->

															</select>
															<!-- /.select-->
														</div>
														<!-- /.travel-select-icon -->
													</div>
													<!--/.single-tab-select-box-->
												</div>
												<!--/.col-->

											</div>
											<!--/.row-->

											<div class="row">
												<div class="col-sm-5">
													<div class="travel-budget">
														<div class="row">
															<div class="col-md-3 col-sm-4">
																<h3>budget :</h3>
															</div>
															<!--/.col-->
															<div class="co-md-9 col-sm-8">
																<div class="travel-filter">
																	<div class="info_widget">
																		<div class="price_filter">

																			<div id="slider-range"></div>
																			<!--/.slider-range-->

																			<div class="price_slider_amount">
																				<input type="text" id="amount" name="price"
																					placeholder="Add Your Price" />
																			</div>
																			<!--/.price_slider_amount-->
																		</div>
																		<!--/.price-filter-->
																	</div>
																	<!--/.info_widget-->
																</div>
																<!--/.travel-filter-->
															</div>
															<!--/.col-->
														</div>
														<!--/.row-->
													</div>
													<!--/.travel-budget-->
												</div>
												<!--/.col-->
												<div class="clo-sm-7">
													<div class="about-btn travel-mrt-0 pull-right">
														<button class="about-view travel-btn">search</button>
														<!--/.travel-btn-->
													</div>
													<!--/.about-btn-->
												</div>
												<!--/.col-->

											</div>
											<!--/.row-->

										</div>
										<!--/.tab-para-->

									</div>
									<!--/.tabpannel-->

									<div role="tabpanel" class="tab-pane fade in" id="hotels">
										<div class="tab-para">

											<div class="row">
												<div class="col-lg-4 col-md-4 col-sm-12">
													<div class="single-tab-select-box">

														<h2>destination</h2>

														<div class="travel-select-icon">
															<select class="form-control ">

																<option value="default">enter your destination
																	country</option>
																<!-- /.option-->

																<option value="turkey">turkey</option>
																<!-- /.option-->

																<option value="russia">russia</option>
																<!-- /.option-->
																<option value="egept">egypt</option>
																<!-- /.option-->

															</select>
															<!-- /.select-->
														</div>
														<!-- /.travel-select-icon -->

														<div class="travel-select-icon">
															<select class="form-control ">

																<option value="default">enter your destination
																	location</option>
																<!-- /.option-->

																<option value="istambul">istambul</option>
																<!-- /.option-->

																<option value="mosko">mosko</option>
																<!-- /.option-->
																<option value="cairo">cairo</option>
																<!-- /.option-->

															</select>
															<!-- /.select-->
														</div>
														<!-- /.travel-select-icon -->

													</div>
													<!--/.single-tab-select-box-->
												</div>
												<!--/.col-->

												<div class="col-lg-2 col-md-3 col-sm-4">
													<div class="single-tab-select-box">
														<h2>check in</h2>
														<div class="travel-check-icon">
															<form action="#">
																<input type="text" name="check_in" class="form-control"
																	data-toggle="datepicker" placeholder="12 -01 - 2017 ">
															</form>
														</div>
														<!-- /.travel-check-icon -->
													</div>
													<!--/.single-tab-select-box-->
												</div>
												<!--/.col-->

												<div class="col-lg-2 col-md-3 col-sm-4">
													<div class="single-tab-select-box">
														<h2>check out</h2>
														<div class="travel-check-icon">
															<form action="#">
																<input type="text" name="check_out" class="form-control"
																	data-toggle="datepicker" placeholder="22 -01 - 2017 ">
															</form>
														</div>
														<!-- /.travel-check-icon -->
													</div>
													<!--/.single-tab-select-box-->
												</div>
												<!--/.col-->

												<div class="col-lg-2 col-md-1 col-sm-4">
													<div class="single-tab-select-box">
														<h2>duration</h2>
														<div class="travel-select-icon">
															<select class="form-control ">

																<option value="default">5</option>
																<!-- /.option-->

																<option value="10">10</option>
																<!-- /.option-->

																<option value="15">15</option>
																<!-- /.option-->
																<option value="20">20</option>
																<!-- /.option-->

															</select>
															<!-- /.select-->
														</div>
														<!-- /.travel-select-icon -->
													</div>
													<!--/.single-tab-select-box-->
												</div>
												<!--/.col-->

												<div class="col-lg-2 col-md-1 col-sm-4">
													<div class="single-tab-select-box">
														<h2>members</h2>
														<div class="travel-select-icon">
															<select class="form-control ">

																<option value="default">1</option>
																<!-- /.option-->

																<option value="2">2</option>
																<!-- /.option-->

																<option value="4">4</option>
																<!-- /.option-->
																<option value="8">8</option>
																<!-- /.option-->

															</select>
															<!-- /.select-->
														</div>
														<!-- /.travel-select-icon -->
													</div>
													<!--/.single-tab-select-box-->
												</div>
												<!--/.col-->

											</div>
											<!--/.row-->

											<div class="row">
												<div class="col-sm-5"></div>
												<!--/.col-->
												<div class="clo-sm-7">
													<div class="about-btn travel-mrt-0 pull-right">
														<button class="about-view travel-btn">search</button>
														<!--/.travel-btn-->
													</div>
													<!--/.about-btn-->
												</div>
												<!--/.col-->

											</div>
											<!--/.row-->

										</div>
										<!--/.tab-para-->

									</div>
									<!--/.tabpannel-->

									<div role="tabpanel" class="tab-pane fade in" id="flights">
										<div class="tab-para">
											<div class="trip-circle">
												<div class="single-trip-circle">
													<input type="radio" id="radio01" name="radio" /> <label
														for="radio01"> <span class="round-boarder">
															<span class="round-boarder1"></span>
													</span>round trip
													</label>
												</div>
												<!--/.single-trip-circle-->
												<div class="single-trip-circle">
													<input type="radio" id="radio02" name="radio" /> <label
														for="radio02"> <span class="round-boarder">
															<span class="round-boarder1"></span>
													</span>on way
													</label>
												</div>
												<!--/.single-trip-circle-->
											</div>
											<!--/.trip-circle-->
											<div class="row">
												<div class="col-lg-4 col-md-4 col-sm-12">
													<div class="single-tab-select-box">

														<h2>from</h2>

														<div class="travel-select-icon">
															<select class="form-control ">

																<option value="default">enter your location</option>
																<!-- /.option-->

																<option value="turkey">turkey</option>
																<!-- /.option-->

																<option value="russia">russia</option>
																<!-- /.option-->
																<option value="egept">egypt</option>
																<!-- /.option-->

															</select>
															<!-- /.select-->
														</div>
														<!-- /.travel-select-icon -->
													</div>
													<!--/.single-tab-select-box-->
												</div>
												<!--/.col-->

												<div class="col-lg-2 col-md-3 col-sm-4">
													<div class="single-tab-select-box">
														<h2>departure</h2>
														<div class="travel-check-icon">
															<form action="#">
																<input type="text" name="departure" class="form-control"
																	data-toggle="datepicker" placeholder="12 -01 - 2017 ">
															</form>
														</div>
														<!-- /.travel-check-icon -->
													</div>
													<!--/.single-tab-select-box-->
												</div>
												<!--/.col-->

												<div class="col-lg-2 col-md-3 col-sm-4">
													<div class="single-tab-select-box">
														<h2>return</h2>
														<div class="travel-check-icon">
															<form action="#">
																<input type="text" name="return" class="form-control"
																	data-toggle="datepicker" placeholder="22 -01 - 2017 ">
															</form>
														</div>
														<!-- /.travel-check-icon -->
													</div>
													<!--/.single-tab-select-box-->
												</div>
												<!--/.col-->

												<div class="col-lg-2 col-md-1 col-sm-4">
													<div class="single-tab-select-box">
														<h2>adults</h2>
														<div class="travel-select-icon">
															<select class="form-control ">

																<option value="default">5</option>
																<!-- /.option-->

																<option value="10">10</option>
																<!-- /.option-->

																<option value="15">15</option>
																<!-- /.option-->
																<option value="20">20</option>
																<!-- /.option-->

															</select>
															<!-- /.select-->
														</div>
														<!-- /.travel-select-icon -->
													</div>
													<!--/.single-tab-select-box-->
												</div>
												<!--/.col-->

												<div class="col-lg-2 col-md-1 col-sm-4">
													<div class="single-tab-select-box">
														<h2>childs</h2>
														<div class="travel-select-icon">
															<select class="form-control ">

																<option value="default">1</option>
																<!-- /.option-->

																<option value="2">2</option>
																<!-- /.option-->

																<option value="4">4</option>
																<!-- /.option-->
																<option value="8">8</option>
																<!-- /.option-->

															</select>
															<!-- /.select-->
														</div>
														<!-- /.travel-select-icon -->
													</div>
													<!--/.single-tab-select-box-->
												</div>
												<!--/.col-->

											</div>
											<!--/.row-->

											<div class="row">
												<div class="col-lg-4 col-md-4 col-sm-12">
													<div class="single-tab-select-box">

														<h2>to</h2>

														<div class="travel-select-icon">
															<select class="form-control ">

																<option value="default">enter your destination
																	location</option>
																<!-- /.option-->

																<option value="istambul">istambul</option>
																<!-- /.option-->

																<option value="mosko">mosko</option>
																<!-- /.option-->
																<option value="cairo">cairo</option>
																<!-- /.option-->

															</select>
															<!-- /.select-->
														</div>
														<!-- /.travel-select-icon -->

													</div>
													<!--/.single-tab-select-box-->
												</div>
												<!--/.col-->
												<div class="col-lg-3 col-md-3 col-sm-4">
													<div class="single-tab-select-box">

														<h2>class</h2>
														<div class="travel-select-icon">
															<select class="form-control ">

																<option value="default">enter class</option>
																<!-- /.option-->

																<option value="A">A</option>
																<!-- /.option-->

																<option value="B">B</option>
																<!-- /.option-->
																<option value="C">C</option>
																<!-- /.option-->

															</select>
															<!-- /.select-->
														</div>
														<!-- /.travel-select-icon -->
													</div>
													<!--/.single-tab-select-box-->
												</div>
												<!--/.col-->
												<div class="clo-sm-5">
													<div class="about-btn pull-right">
														<button class="about-view travel-btn">search</button>
														<!--/.travel-btn-->
													</div>
													<!--/.about-btn-->
												</div>
												<!--/.col-->

											</div>
											<!--/.row-->

										</div>

									</div>
									<!--/.tabpannel-->

								</div>
								<!--/.tab content-->
							</div>
							<!--/.desc-tabs-->
						</div>
						<!--/.single-travel-box-->
					</div>
					<!--/.col-->
				</div>
				<!--/.row-->
			</div>
			<!--/.container-->

		</section>
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
													<span>20 tours</span><span>15 places</span>
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
													<span>12 tours</span><span>9 places</span>
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
													<span>25 tours</span><span>10 places</span>
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
													<span>18 tours</span><span>9 places</span>
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
													<span>14 tours</span><span>12 places</span>
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
													<span>14 tours</span><span>6 places</span>
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
								<h2>Notre offre est pr�s de finir
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

		<!--blog start-->
		<section id="blog" class="blog">
			<div class="container">
				<div class="blog-details">
					<div class="gallary-header text-center">
						<h2>latest news</h2>
						<p>Travel News from all over the world</p>
					</div>
					<!--/.gallery-header-->
					<div class="blog-content">
						<div class="row">

							<div class="col-sm-4 col-md-4">
								<div class="thumbnail">
									<h2>
										trending news <span>15 november 2017</span>
									</h2>
									<div class="thumbnail-img">
										<img src="assets/images/blog/b1.jpg" alt="blog-img">
										<div class="thumbnail-img-overlay"></div>
										<!--/.thumbnail-img-overlay-->

									</div>
									<!--/.thumbnail-img-->

									<div class="caption">
										<div class="blog-txt">
											<h3>
												<a href="#"> Discover on beautiful weather, Fantastic
													foods and historical place in Prag </a>
											</h3>
											<p>Lorem ipsum dolor sit amet, contur adip elit, sed do
												mod incid ut labore et dolore magna aliqua. Ut enim ad minim
												veniam</p>
											<a href="#">Read More</a>
										</div>
										<!--/.blog-txt-->
									</div>
									<!--/.caption-->
								</div>
								<!--/.thumbnail-->

							</div>
							<!--/.col-->

							<div class="col-sm-4 col-md-4">
								<div class="thumbnail">
									<h2>
										trending news <span>15 november 2017</span>
									</h2>
									<div class="thumbnail-img">
										<img src="assets/images/blog/b2.jpg" alt="blog-img">
										<div class="thumbnail-img-overlay"></div>
										<!--/.thumbnail-img-overlay-->

									</div>
									<!--/.thumbnail-img-->
									<div class="caption">
										<div class="blog-txt">
											<h3>
												<a href="#"> Discover on beautiful weather, Fantastic
													foods and historical place in india </a>
											</h3>
											<p>Lorem ipsum dolor sit amet, contur adip elit, sed do
												mod incid ut labore et dolore magna aliqua. Ut enim ad minim
												veniam</p>
											<a href="#">Read More</a>
										</div>
										<!--/.blog-txt-->
									</div>
									<!--/.caption-->
								</div>
								<!--/.thumbnail-->

							</div>
							<!--/.col-->

							<div class="col-sm-4 col-md-4">
								<div class="thumbnail">
									<h2>
										trending news <span>15 november 2017</span>
									</h2>
									<div class="thumbnail-img">
										<img src="assets/images/blog/b3.jpg" alt="blog-img">
										<div class="thumbnail-img-overlay"></div>
										<!--/.thumbnail-img-overlay-->

									</div>
									<!--/.thumbnail-img-->
									<div class="caption">
										<div class="blog-txt">
											<h3>
												<a href="#">10 Most Natural place to Discover</a>
											</h3>
											<p>Lorem ipsum dolor sit amet, contur adip elit, sed do
												mod incid ut labore et dolore magna aliqua. Ut enim ad minim
												veniam</p>
											<a href="#">Read More</a>
										</div>
										<!--/.blog-txt-->
									</div>
									<!--/.caption-->
								</div>
								<!--/.thumbnail-->

							</div>
							<!--/.col-->

						</div>
						<!--/.row-->
					</div>
					<!--/.blog-content-->
				</div>
				<!--/.blog-details-->
			</div>
			<!--/.container-->

		</section>
		<!--/.blog-->
		<!--blog end-->


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
									placeholder="Enter your Email Here">
								<button class="appsLand-btn subscribe-btn">Subscribe</button>
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
	</layout:put>
	<layout:put block="cssfiles">
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