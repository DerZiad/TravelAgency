<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
	<div class="gallary-header text-center">
		<h2>Offres speciales</h2>
		<p>Ici vous trouvez les meilleures offres que nous avons qui sont recommandés par nos clients</p>
	</div>
	<!--/.gallery-header-->
	<div class="packages-content">
		<div class="row">
			<c:forEach var="voyage" items="${voyagesBest}">
			<div class="col-md-4 col-sm-6">
				<div class="single-package-item">
					<img src="data:image/jpeg;base64,${voyage.header}" alt="package-place">
					<div class="single-package-item-txt">
						<h3>
							${voyage.destination} <span class="pull-right">€${voyage.prix}</span>
						</h3>
						<div class="packages-para">
							<p>
								<span> <i class="fa fa-angle-right"></i>  5 days 6 night
								</span> <i class="fa fa-angle-right"></i> 5 star accomodation
							</p>
							<p>
								<span> <i class="fa fa-angle-right"></i> transportation
								</span> <i class="fa fa-angle-right"></i> food facilities
							</p>
						</div>
						<!--/.packages-para-->
						<div class="packages-review">
							<p>
								<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i> <i class="fa fa-star"></i> <i
									class="fa fa-star"></i> <span>${voyage.review} review</span>
							</p>
						</div>
						<!--/.packages-review-->
						<div class="about-btn">
							<button onclick="addToChart(${voyage.id})" class="about-view packages-btn">book now</button>
						</div>
						<!--/.about-btn-->
					</div>
					<!--/.single-package-item-txt-->
				</div>
				<!--/.single-package-item-->

			</div>
			<!--/.col-->
			</c:forEach>
		</div>
		<!--/.row-->
	</div>
	<!--/.packages-content-->
</div>