<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
	prefix="layout"%>
<layout:extends name="base.jsp">
	<layout:put block="content" type="REPLACE">
		<section id="subs" class="subscribe">
			<div class="container">
				<div class="subscribe-title text-center">
					<h2>
						Login to your <strong>Private space</strong>
					</h2>
					<p>This is the secured portal for the Administrator
						authentication</p>
				</div>
				<form method="POST" action="/login">
					<div class="row">
						<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
							<div class="custom-input-group">
								<input type="text" class="form-control inputLogin" name="username"
									placeholder="Enter your username here">
								<div class="clearfix"></div>
							</div>
						</div>

					</div>
					<br> <br> <br> <br> <br>
					<div class="row">
						<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
							<div class="custom-input-group">
								<input type="password" class="form-control" name="password"
									placeholder="Enter your Password">
								<button class="appsLand-btn subscribe-btn">Login</button>
								<div class="clearfix"></div>
							</div>

						</div>
					</div>
					<c:if test="${error ne null}">
						<div class="alert alert-danger" role="alert" style="color: red">
							<p>
								<c:out value="${error}" />
							</p>
						</div>
					</c:if>
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
		<style>
.inputLogin {
	padding: 30px;
}
</style>
	</layout:put>
</layout:extends>


