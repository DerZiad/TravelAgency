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
							<form action="search" method="post">

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



											<div class="">
												<div class="form-row">
													<div class="col-md-6">
														<label>Nombre Personnes</label> <input type="number"
															class="form-control" name="nbrePersonne" />
														<p id="nbrePersonne" class="error"></p>
													</div>
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
										</div>
									</div>
								</div>
								<!--/.col-->
							</form>

						</div>
						<!--/.row-->

					</div>
					<!--/.tab-para-->

				</div>
				<!--/.tabpannel-->


				<!--/.tabpannel-->

				
				<!--/.tabpannel-->

			</div>
			<!--/.tab content-->
		</div>
		<!--/.desc-tabs-->
	</div>
	<!--/.single-travel-box-->
	
	<!--/.container-->

</section>