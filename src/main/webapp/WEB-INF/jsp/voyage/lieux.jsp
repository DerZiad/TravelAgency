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
				<form class="form-group"
					action="/admin/voyage/lieux?id=${idVoyage}"
					enctype="multipart/form-data" method="POST">
					<h5 class="card-title">Ajout image</h5>
					<input name="id" id="id" type="hidden" class="form-control"
						value="${idVoyage}">
					<div class="form-row">
						<div class="col-md-6">
							<div class="position-relative form-group">
								<label for="type" class="">Pays</label> <select id="pays" name="pays"
									class="form-control">
									<c:forEach var="country" items="${countries}">
										<option value="${country.keyCountry}">${country.valueCountry}</option>
									</c:forEach>
								</select>
							</div>

						</div>

					</div>
					<div class="form-row">
						<div class="col-md-6">
							<div class="position-relative form-group">
								<label for="type" class="">Lieu</label> <select name="lieu"
									id="type" class="form-control">
								</select>
							</div>

						</div>

					</div>
					<button class="mt-2 btn btn-primary col-md-6" type="submit">Enregistrer</button>
				</form>
			</div>
			<div class="main-card mb-3">
				<div class="card-body">
					<h5 class="card-title">Liste des Themes de Voyage</h5>
					<table class="mb-0 table table-striped">
						<thead>
							<tr>
								<th>Lieu</th>
								<th>Pays</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="lieu" items="${lieux}">
								<tr>
									<td style="color: black">${lieu.label}</td>
									<td style="color: black">${lieu.country.valueCountry}</td>
									<td><a
										href="/admin/voyage/lieux/delete?id=${idVoyage}&idLieu=${lieu.id}"
										class="delete"><i class="material-icons"
											data-toggle="tooltip" title="Delete">&#xE872;</i></a>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<layout:put block="scriptsfile" type="REPLACE">
			<script src="/delibdesign/js/voyage/lieux.js"></script>
			<script src="/delibdesign/js/voyage/template.js"></script>
		</layout:put>
	</layout:put>
</layout:extends>