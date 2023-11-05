<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
	prefix="layout"%>
<layout:extends name="../layout-resp.jsp">
	<layout:put block="content" type="REPLACE">
		<div class="main-card mb-3 card">
			<br>
			<div class="card-body">

				<h5 class="card-title">Create Travel Team</h5>
				<form class="" action="/admin/ressources/add" method="POST"
					enctype="multipart/form-data">
					<div class="alert alert-primary">
						<h3>Team Information</h3>
						<div class="form-row">
							<div class="col-md-6">
								<div class="position-relative form-group">
									<label for="label" class="">Team Name</label><input
										name="label" id="label" placeholder="Titre de l'�quipe"
										type="text" class="form-control"
										value="<c:out value="${equipe.label}"/>">
									<p class="error">
										<c:out value="${errors.label}" />
									</p>
								</div>
								<c:if test="${equipe.id ne null }">
									<input type="hidden" name="id" value="${equipe.id}" />
								</c:if>
							</div>
						</div>
					</div>
					<div class="alert alert-primary">
						<div class="form-row">
							<h3>Personal Information</h3>
						</div>
						<div class="form-row">
							<div class="col-md-6">
								<div class="position-relative form-group">
									<label for="nom" class="">Last name</label><input name="nom" id="nom"
										placeholder="Nom" type="text" class="form-control"
										value="<c:out value="${personne.nom}"/>">
									<p class="error">
										<c:out value="${errors.nom}" />
									</p>
								</div>
							</div>

							<div class="col-md-6">
								<div class="position-relative form-group">
									<label for="prenom" class="">First Name </label><input
										name="prenom" id="prenom" placeholder="Pr�nom" type="text"
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
									<label for="cne" class="">Identification Number</label><input name="cne" id="cne"
										placeholder="CNE" type="text" class="form-control"
										value="<c:out value="${personne.cne}"/>">
									<p class="error">
										<c:out value="${errors.cne}" />
									</p>
								</div>
							</div>
							<div class="col-md-3">
								<div class="position-relative form-group">
									<label for="dateNaissance" class="">Birthday</label><input
										name="dateNaissanceDate" id="dateNaissance" type="date"
										class="form-control" value="${personne.dateNaissanceDate}">
									<p class="error">
										<c:out value="${errors.dateNaissance}" />
									</p>
								</div>
							</div>
							<div class="col-md-3">
								<div class="position-relative form-group">
									<label for="nationalite" class="">Nationality</label> <select
										name="nationalite" id="nationalite" class="form-control">
										<c:forEach var="c" items="${countries}">
											<c:if test="${personne.nationalite.equals(c) }">
												<option value="${c.valueCountry}" selected>${c.valueCountry}</option>
											</c:if>
											<c:if test="${not personne.nationalite.equals(c) }">
												<option value="${c.valueCountry}">${c.valueCountry}</option>
											</c:if>

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
									<h5 class="card-title">Gender</h5>
									<div class="position-relative form-group">
										<div>
											<div class="custom-radio custom-control">
												<input type="radio" id="male" value="HOMME" name="sexe"
													class="custom-control-input" checked><label
													class="custom-control-label" for="male">Homme</label>
											</div>
											<div class="custom-radio custom-control">
												<input type="radio" id="female" value="FEMME" name="sexe"
													class="custom-control-input"><label
													class="custom-control-label" for="female">Femme</label>
											</div>
										</div>
										<p class="error">
											<c:out value="${errors.sexe}" />
										</p>
									</div>
								</div>
							</div>
							<c:if test="${personne.getBase64() ne null }">
								<div class="col-md-3">
									<img style='display: block; width: 100px; height: 100px;'
										id='base64image'
										src='data:image/jpeg;base64,${personne.getBase64()}' />
								</div>
							</c:if>
							<div class="col-md-3">
								<div class="position-relative form-group">

									<label for="image" class="">Profile Picture</label><input
										name="imagePart" id="image" type="file" class="form-control">
									<p class="error">
										<c:out value="${errors.image}" />
									</p>
								</div>
							</div>
						</div>

						<div class="form-row">
							<h3>Contact Details</h3>
						</div>
						<div class="form-row">
							<div class="col-md-3">
								<div class="position-relative form-group">
									<label for="codePostal" class="">Zipcode</label><input
										name="codePostal" id="codePostal" placeholder="Code postale"
										type="text" class="form-control"
										value="${personne.codePostal}">
									<p class="error">
										<c:out value="${errors.codePostal}" />
									</p>
								</div>
							</div>
							<div class="col-md-3">
								<div class="position-relative form-group">
									<label for="telephone" class="">Mobile number</label><input
										name="telephone" id="telephone"
										placeholder="Num�ro de telephone" type="text"
										class="form-control" value="${personne.telephone}">
									<p class="error">
										<c:out value="${errors.telephone}" />
									</p>
								</div>
							</div>
							<div class="col-md-6">
								<div class="position-relative form-group">
									<label for="email" class="">Email</label><input name="email"
										id="email" placeholder="Email" type="text"
										class="form-control" value="${personne.email}">
									<p class="error">
										<c:out value="${errors.email}" />
									</p>
								</div>
							</div>
						</div>

						<div class="form-row">
							<h3>Social Information</h3>
						</div>
						<div class="form-row">
							<div class="col-md-3">
								<div class="position-relative form-group">
									<label for="travaille" class="">Work</label><input
										name="travaille" id="travaille" placeholder="Travaille"
										type="text" class="form-control" value="${personne.travaille}">
									<p class="error">
										<c:out value="${errors.travaille}" />
									</p>
								</div>
							</div>
						</div>
						<div class="form-row">
							<div class="col-md-6">
								<label for="marie">Social Status</label>
								<div class="card-body">
									<div class="position-relative form-group">
										<div>
											<div class="custom-radio custom-control">
												<input type="radio" id="mariee" value="OUI"
													name="marieString" class="custom-control-input" checked><label
													class="custom-control-label" for="mariee">Married</label>
											</div>
											<div class="custom-radio custom-control">
												<input type="radio" id="celib" value="NON" name="marieString"
													class="custom-control-input"><label
													class="custom-control-label" for="celib">Single</label>
											</div>
										</div>
										<p class="error">
											<c:out value="${errors.marie}" />
										</p>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="position-relative form-group">
									<label for="nombreEnfant" class="">Children Number</label><input
										name="nombreEnfant" id="nombreEnfant"
										placeholder="Nombre d'enfants" type="number"
										class="form-control" value="${personne.nombreEnfant}">
									<p class="error">
										<c:out value="${errors.nombreEnfant}" />
									</p>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-3 col-sm-3">
						</div>
						<div class="col-md-3 col-sm-3">
							<a href="/admin/ressources" class="col-md-12 btn btn-danger">Cancel</a>
						</div>
						<div class="col-md-3 col-sm-3">
							<button class="mt-2 btn btn-success col-md-12" type="submit">Add Team</button>
						</div>
						<div class="col-md-3 col-sm-3">
						</div>
					</div>
				</form>
			</div>
		</div>

	</layout:put>
	<layout:put block="cssfiles" type="REPLACE">
		<style>
			.error{
				color:red;
				font-size:15px;
			}
		</style>
	</layout:put>
</layout:extends>