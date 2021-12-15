<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
	prefix="layout"%>
<layout:extends name="../layout-resp.jsp">
	<layout:put block="content" type="REPLACE">
		<div class="main-card mb-3 card">
			<div class="card-body">
				<h5 class="card-title">Création d'un étudiant</h5>
				<form class="" action="/signup" method="POST">
					<div class="form-row">
						<div class="col-md-6">
							<div class="position-relative form-group">
								<label for="last_name_fr" class="">Nom en français</label><input
									name="last_name_fr" id="last_name_fr" placeholder=""
									type="text" class="form-control">
							</div>
						</div>
						<div class="col-md-6">
							<div class="position-relative form-group">
								<label for="first_name_fr" class="">Prénom en français</label><input
									name="first_name_fr" id="first_name_fr" placeholder=""
									type="text" class="form-control">
							</div>
						</div>
					</div>

					<div class="form-row">
						<div class="col-md-3">
							<div class="position-relative form-group">
								<label for="cne" class="">CNE</label><input name="cne" id="cne"
									placeholder="" type="text" class="form-control">
							</div>
						</div>
						<div class="col-md-3">
							<div class="position-relative form-group">
								<label for="birth_date" class="">Date de naissance</label><input
									name="birth_date" id="birth_date" type="date"
									class="form-control">
							</div>
						</div>
						<div class="col-md-6">

							<div class="card-body">
								<h5 class="card-title">Sexe</h5>
								<div class="position-relative form-group">
									<div>
										<div class="custom-radio custom-control">
											<input type="radio" id="male" value="HOMME" name="gender"
												class="custom-control-input" checked><label
												class="custom-control-label" for="male">Homme</label>
										</div>
										<div class="custom-radio custom-control">
											<input type="radio" id="female" value="FEMME" name="gender"
												class="custom-control-input"><label
												class="custom-control-label" for="female">Femme</label>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="form-row">
						<div class="col-md-3">
							<div class="position-relative form-group">
								<label for="nationality" class="">Nationalité</label> <select
									name="keycountry" class="selectpicker" data-live-search="true">
									<option selected="selected">Nom Du Pays</option>
									<c:forEach var="c" items="${country}">
										<option data-tokens="${c.keyCountry}" value="${c.keyCountry}">${c.valueCountry}</option>
									</c:forEach>

								</select>
							</div>
						</div>
			
					</div>
					<div class="form-row">
						<div class="col-md-3">
							<div class="position-relative form-group">
								<label for="email" class="">Code postal</label><input name="email"
									id="email" placeholder="" type="text" class="form-control">
							</div>
						</div>
						<div class="col-md-3">
							<div class="position-relative form-group">
								<label for="email" class="">Telephone</label><input name="email"
									id="email" placeholder="" type="text" class="form-control">
							</div>
						</div>
						<div class="col-md-6">
							<div class="position-relative form-group">
								<label for="email" class="">Email</label><input name="email"
									id="email" placeholder="" type="text" class="form-control">
							</div>
						</div>
					</div>
					
					
					<div class="form-row">
						<h1> Informations s</h1>
						<div class="col-md-3">
							<div class="position-relative form-group">
								<label for="email" class="">Travaille</label><input name="email"
									id="email" placeholder="" type="text" class="form-control">
							</div>
						</div>
						<div class="col-md-3">
							<div class="position-relative form-group">
								<label for="email" class="">Etat Sociale</label><input name="email"
									id="email" placeholder="" type="text" class="form-control">
							</div>
						</div>
						<div class="col-md-3">

							<div class="card-body">
								<h5 class="card-title">Sexe</h5>
								<div class="position-relative form-group">
									<div>
										<div class="custom-radio custom-control">
											<input type="radio" id="male" value="HOMME" name="gender"
												class="custom-control-input" checked><label
												class="custom-control-label" for="male">Homme</label>
										</div>
										<div class="custom-radio custom-control">
											<input type="radio" id="female" value="FEMME" name="gender"
												class="custom-control-input"><label
												class="custom-control-label" for="female">Femme</label>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-3">
							<div class="position-relative form-group">
								<label for="email" class="">Nombre d'enfants</label><input name="email"
									id="email" placeholder="" type="text" class="form-control">
							</div>
						</div>
					</div>
					<button class="mt-2 btn btn-primary col-md-12" type="submit">Valider</button>
				</form>
			</div>
		</div>

	</layout:put>

</layout:extends>