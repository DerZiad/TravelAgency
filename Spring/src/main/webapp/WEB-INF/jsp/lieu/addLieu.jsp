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
				<form class="form-group" action="lieux" method="POST">
					<h5 class="card-title">Création d'un Lieu</h5>

					<div class="form-row">
						<div class="col-md-6">
							<div class="position-relative form-group">
								<label for="name" class="">Label lieu</label><input name="name"
									id="name" placeholder="Nom du Lieu" type="text"
									class="form-control">
							</div>

						</div>
					</div>


					<div class="form-row">
						<select name="keycountry" class="selectpicker"
							data-live-search="true">
							<option selected="selected">Nom Du Pays</option>
							<c:forEach var="c" items="${country}">
								<option data-tokens="${c.keyCountry}" value="${c.keyCountry}">${c.valueCountry}</option>
							</c:forEach>
							
						</select>
					</div>










					<button class="mt-2 btn btn-primary col-md-6" type="submit">Enregistrer</button>
				</form>
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
							</tr>
						</thead>
						<tbody>
							<c:forEach var="lieux" items="${lieux}">
								<tr>
									<td>
										<!--  <a style="color: black"
										href="/admin/module/profile/${element.module.id_module}/element/modify/${element.id_element}">-->
										${lieux.id}</a>
									</td>
									<td style="color: black">${lieux.label}</td>
									<td style="color: black">${lieux.country.valueCountry}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

	</layout:put>
</layout:extends>