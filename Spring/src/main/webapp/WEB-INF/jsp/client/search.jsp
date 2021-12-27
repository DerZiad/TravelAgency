<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
	prefix="layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.Date"%>
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
													<select name="country" class="form-control ">

														<option value="default">enter your destination
															country</option>
														<!-- /.option-->
														<c:forEach items="${countries}" var="c">
															<option value="${c.valueCountry}">${c.valueCountry}</option>
															<!-- /.option-->


															<!-- /.option-->
														</c:forEach>
													</select>
													<!-- /.select-->
												</div>
												<!-- /.travel-select-icon -->

												<div class="travel-select-icon">
													<select name="state" class="form-control ">

														<!-- /.option-->


														<!-- /.option-->

													</select>
													<!-- /.select-->
												</div>
												<!-- /.travel-select-icon -->

											</div>
											<!--/.single-tab-select-box-->
										</div>
										<!--/.col-->

										<div class="col-md-6">
											<div class="single-tab-select-box">
												<div class="form-group row">
													<label class="col-sm-3 col-form-label">Date de
														depart</label>
													<div class="col-sm-9">
														<input placeholder="dd/mm/yyyy" type="date"
															min="<%=new java.sql.Date(System.currentTimeMillis())%>"
															name="date_depart" class="form-control date" />
													</div>
												</div>

												<!-- /.travel-check-icon -->
											</div>
											<!--/.single-tab-select-box-->
										</div>
										<!--/.col-->

										<div class="col-md-6">
											<div class="form-group row">
												<label class="col-sm-3 col-form-label">Date de
													retour</label>
												<div class="col-sm-9">
													<input id="dr" class="form-control date" type="date"
														name="date_arrive" placeholder="dd/mm/yyyy" />
												</div>
											</div>

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
											<div class="budget-wrap">
												<div class="budget">
													<div class="header">
														<div class="title clearfix">
															Set your budget! <span class="pull-right"></span>
														</div>
													</div>
													<div class="content">
														<input name="budget" type="range" min="10" max="1000"
															value="30" data-rangeslider>
													</div>
													<div class="footer clearfix">
														<div class="pull-right">
															<a href="javascript:void(0)" class="btn btn-def">Back</a>
															<a href="javascript:void(0)" class="btn btn-pri">Next</a>
														</div>
													</div>
												</div>
											</div>
											<!--/.travel-budget-->
										</div>
										<!--/.col-->
										<div class="clo-sm-7">
											<div class="about-btn travel-mrt-0 pull-right">
												<input id="srch" name="srch" type="submit"
													class="about-view travel-btn" value="SEARCH ">
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
												for="radio01"> <span class="round-boarder"> <span
													class="round-boarder1"></span>
											</span>round trip
											</label>
										</div>
										<!--/.single-trip-circle-->
										<div class="single-trip-circle">
											<input type="radio" id="radio02" name="radio" /> <label
												for="radio02"> <span class="round-boarder"> <span
													class="round-boarder1"></span>
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