<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">

	<div class="gallary-header text-center">
		<h2>Nos equipes</h2>
		<p>Ici vous trouverez nos meilleurs guides touristiques dans nos voyages</p>

	</div>
	<!--/.gallery-header-->

	<div class="owl-carousel owl-theme" id="testemonial-carousel">
		<c:forEach var="equipe" items="${equipesBest}">
			<div class="home1-testm item">
				<div class="home1-testm-single text-center">
					<div class="home1-testm-img">
						<img src="data:image/jpeg;base64,${equipe.personne.base64} alt="${equipe.personne.nom} ${equipe.personne.prenom}" />
					</div>
					<!--/.home1-testm-img-->
					<div class="home1-testm-txt">
						<span class="icon section-icon"> <i
							class="fa fa-quote-left" aria-hidden="true"></i>
						</span>
						<p>${equipe.personne.email}</p>
						<h3>
							<a> ${equipe.personne.nom} ${equipe.personne.prenom} </a>
						</h3>
						<h4>${equipe.personne.nationalite}</h4>
					</div>
					<!--/.home1-testm-txt-->
				</div>
				<!--/.home1-testm-single-->

			</div>
			<!--/.item-->
		</c:forEach>
	</div>
	<!--/.testemonial-carousel-->
</div>