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
					<h5 class="card-title">Create a Destination</h5>
					<input name="id" id="id" type="hidden" class="form-control"
						value="${lieu.id}">
					<div class="form-row">
						<div class="col-md-6">
							<div class="position-relative form-group">
								<input name="name"
									id="name" placeholder="Destination" type="text"
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
						<div class="col-md-6">
							<select id="slct" name="keycountry" class="form-control"
								data-live-search="true">
								<c:if test="${not empty lieu.country.keyCountry}">
									<option selected="selected" value="${lieu.country.keyCountry}"
										id="option1"><c:out
											value="${lieu.country.valueCountry}">NOM PAYS</c:out></option>
								</c:if>
								<c:forEach var="c" items="${country}">
									<option id="option2" data-tokens="${c.keyCountry}"
										value="${c.keyCountry}">${c.valueCountry}</option>
								</c:forEach>

							</select>
							<p style="color: red;">

								<c:if test="${bool}">
									<c:out value="${errors.country.valueCountry}"></c:out>
								</c:if>
							</p>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<button class="mt-2 btn btn-primary" type="submit">Save</button>
						</div>

						<div class="col-md-6">
							<button id="rst" class=" mt-2 btn btn-danger" value="Reset">Delete</button>
						</div>
					</div>

				</form>


			</div>
			<div class="main-card mb-3">
				<div class="card-body">
					<h5 class="card-title">List of Destinations</h5>
					<table class="mb-0 table table-striped">
						<thead>
							<tr>
								<th>City</th>
								<th>Country</th>
								<th>Perform Actions</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="lieux" items="${lieux}">
								<tr>
									<td style="color: black">${lieux.label}</td>
									<td style="color: black">${lieux.country.valueCountry}</td>
									<td><a style="color: black"
										href="/admin/lieux/${lieux.id}"> <i class="material-icons"
											data-toggle="tooltip" title="Edit" style="color: #1de9b6">&#xE254;</i></a>
										<a href="/admin/lieux/deleteLieu/${lieux.id}" class="delete"><i
											class="bi bi-trash"></i><i class="material-icons"
											data-toggle="tooltip" title="Delete" style="color: #f44336;">&#xE872;</i></a>

									</td>
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