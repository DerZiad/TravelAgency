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
				<h5 class="card-title">Création d'une equipe</h5>
				<form class="" action="/signup" method="POST">
					<div class="alert alert-primary">
						<h1>Informations de l'equipe</h1>
						<div class="form-row">
							<div class="col-md-6">
								<div class="position-relative form-group">
									<label for="label" class="">Nom de l'equipe</label><input
										name="label" id="label" placeholder="" type="text"
										class="form-control">
								</div>
							</div>
						</div>
					</div>
					<div class="alert alert-success">
						<div class="form-row">
							<h1>Informations personnelles</h1>
						</div>
						<div class="form-row">
							<div class="col-md-6">
								<div class="position-relative form-group">
									<label for="nom" class="">Nom</label><input name="nom" id="nom"
										placeholder="Nom" type="text" class="form-control"
										value="<c:out value="${personne.nom}"/>">
									<p class="error">
										<c:out value="${errors.nom}" />
									</p>
								</div>
							</div>

							<div class="col-md-6">
								<div class="position-relative form-group">
									<label for="prenom" class="">Prénom </label><input
										name="prenom" id="prenom" placeholder="Prénom" type="text"
										class="form-control"
										value="<c:out value="${personne.prenom}"/>">
									<p class="error">
										<c:out value="${errors.nom}" />
									</p>
								</div>
							</div>
						</div>

						<div class="form-row">
							<div class="col-md-3">
								<div class="position-relative form-group">
									<label for="cne" class="">CNE</label><input name="cne" id="cne"
										placeholder="CNE" type="text" class="form-control"
										value="<c:out value="${personne.cne}"/>">
									<p class="error">
										<c:out value="${errors.cne}" />
									</p>
								</div>
							</div>
							<div class="col-md-3">
								<div class="position-relative form-group">
									<label for="dateNaissance" class="">Date de naissance</label><input
										name="dateNaissance" id="dateNaissance" type="date"
										class="form-control">
									<p class="error">
										<c:out value="${errors.dateNaissance}" />
									</p>
								</div>
							</div>
							<div class="col-md-3">
								<div class="position-relative form-group">
									<label for="nationalite" class="">Nationalité</label> <select
										name="nationalite" id="nationalite" class="form-control">
										<c:forEach var="c" items="${country}">
											<option data-tokens="${c.keyCountry}" value="${c.keyCountry}">${c.valueCountry}</option>
										</c:forEach>
									</select>
									<p class="error">
										<c:out value="${errors.nationalite}" />
									</p>
								</div>
							</div>
						</div>

						<div class="form-row">
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
										<p class="error">
											<c:out value="${errors.nationalite}" />
										</p>
									</div>
								</div>
							</div>

						</div>
						<div class="form-row">
							<h1>Contacts</h1>
						</div>
						<div class="form-row">
							<div class="col-md-3">
								<div class="position-relative form-group">
									<label for="codePostal" class="">Code postal</label><input
										name="codePostal" id="codePostal" placeholder="Code postale"
										type="number" class="form-control">
								</div>
							</div>
							<div class="col-md-3">
								<div class="position-relative form-group">
									<label for="telephone" class="">Telephone</label><input
										name="telephone" id="telephone"
										placeholder="Numéro de telephone" type="text"
										class="form-control">
								</div>
							</div>
							<div class="col-md-6">
								<div class="position-relative form-group">
									<label for="email" class="">Email</label><input name="email"
										id="email" placeholder="Email" type="text"
										class="form-control">
								</div>
							</div>
						</div>

						<div class="form-row">
							<h1>Informations sociales</h1>
						</div>
						<div class="form-row">
							<div class="col-md-3">
								<div class="position-relative form-group">
									<label for="travaille" class="">Travaille</label><input
										name="travaille" id="travaille" placeholder="Travaille"
										type="text" class="form-control">
								</div>
							</div>
							<div class="col-md-3">
								<div class="position-relative form-group">
									<label for="etatSocial" class="">Etat Sociale</label><input
										name="etatSocial" id="etatSocial" placeholder="Etat Sociale"
										type="number" class="form-control">
								</div>
							</div>
						</div>
						<div class="form-row">
							<div class="col-md-6">
								<label for="marie">Marié</label>
								<div class="card-body">
									<div class="position-relative form-group">
										<div>
											<div class="custom-radio custom-control">
												<input type="radio" id="marie" value="HOMME" name="marie"
													class="custom-control-input" checked><label
													class="custom-control-label" for="marie">Marié</label>
											</div>
											<div class="custom-radio custom-control">
												<input type="radio" id="marie" value="FEMME" name="marie"
													class="custom-control-input"><label
													class="custom-control-label" for="marie">Célibataire</label>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="position-relative form-group">
									<label for="nombreEnfant" class="">Nombre d'enfants</label><input
										name="nombreEnfant" id="nombreEnfant"
										placeholder="Nombre d'enfants" type="number"
										class="form-control">
								</div>
							</div>
						</div>
					</div>
					<button class="mt-2 btn btn-primary col-md-12" type="submit">Valider</button>
				</form>
			</div>
		</div>

	</layout:put>
</layout:extends>