<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
	prefix="layout"%>
<layout:extends name="../layout-resp.jsp">
	<layout:put block="content" type="REPLACE">

		<div class="main-card mb-3 card">
			<div class="card-body">
				<form class="form-group" action="/admin/lieux" method="POST">
					<h5 class="card-title">Création d'un Lieu</h5>
					<input name="id" id="id" type="hidden" class="form-control"
						value="${lieu.id}">
					<div class="form-row">
						<div class="col-md-6">
							<div class="position-relative form-group">
								<label for="name" class="">Label lieu</label><input name="name"
									id="name" placeholder="Nom du Lieu" type="text"
									value="${lieu.label}" class="form-control">
							</div>
							<p style="color: red;">

								<c:if test="${bool}">
									<c:out value="${errors.label}"></c:out>
								</c:if>
							</p>

						</div>
					</div>


					<div class="form-row">
						<select id="slct" name="keycountry" class="selectpicker"
							data-live-search="true">
							<option selected="selected" value="${lieu.country.keyCountry}" id="option1"><c:out
									value="${lieu.country.valueCountry}">NOM PAYS</c:out></option>
							<c:forEach var="c" items="${country}">
								<option id="option2"data-tokens="${c.keyCountry}" value="${c.keyCountry}">${c.valueCountry}</option>
							</c:forEach>
								<option value="0" >AAA</option>
						</select>
						<p style="color: red;">

							<c:if test="${bool}">
								<c:out value="${errors.country.valueCountry}"></c:out>
							</c:if>
						</p>
					</div>

					<button class="mt-2 btn btn-primary col-md-6" type="submit">Enregistrer</button>
					

				</form>
				<button id="rst" class=" mt-2 btn btn-danger" value="Reset"
						>Effacer</button>
				
			</div>
			<div class="main-card mb-3">
				<div class="card-body">
					<h5 class="card-title">Liste des Lieux</h5>
					<table class="mb-0 table table-striped">
						<thead>
							<tr>
								<th>ID</th>
								<th>LABEL</th>
								<th>COUNTRY</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="lieux" items="${lieux}">
								<tr>
									<td><a style="color: black"
										href="/admin/lieux/${lieux.id}"> ${lieux.id}</a></td>
									<td style="color: black">${lieux.label}</td>
									<td style="color: black">${lieux.country.valueCountry}</td>
									<td><a href="/admin/theme/deleteLieu/${themes.id}"
										class="delete"><i class="bi bi-trash"></i>DELETE</a>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

	</layout:put>
	<layout:put block="scriptsfile" type="REPLACE">
		<script src="/delibdesign/js/Lieu/script.js"></script>
		<script src="/delibdesign/js/hotel/template.js"></script>
	</layout:put>
</layout:extends>