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
					action="/admin/voyage/hoteles?id=${idVoyage}"
					enctype="multipart/form-data" method="POST">
					<h5 class="card-title">Ajout hotele</h5>
					<input name="id" id="id" type="hidden" class="form-control"
						value="${idVoyage}">
					<div class="form-row">
						<div class="col-md-6">
							<div class="position-relative form-group">

								<label for="type" class="">Hotel</label> <select name="hotele"
									id="type" class="form-control">
									<c:forEach var="hotel" items="${hotelesAll}">

										<option value="${hotel.id}">${hotel.nomHotel}</option>

									</c:forEach>
								</select>
							</div>

						</div>

					</div>
					<button class="mt-2 btn btn-primary col-md-6" type="submit">Enregistrer</button>
				</form>
			</div>
			<div class="main-card mb-3">
				<div class="card-body">
					<h5 class="card-title">Liste des Hoteles de Voyage</h5>
					<table class="mb-0 table table-striped">
						<thead>
							<tr>
								<th>Nom Hotel</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="hotele" items="${hoteles}">
								<tr>
									<td style="color: black">${hotele.nomHotel}</td>
									<td><a
										href="/admin/voyage/hoteles/delete?id=${idVoyage}&idHotel=${hotele.id}"
										class="delete"><i class="material-icons"
											data-toggle="tooltip" title="Delete">&#xE872;</i></a>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

	</layout:put>
</layout:extends>