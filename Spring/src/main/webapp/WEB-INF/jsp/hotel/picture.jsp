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
				<form class="form-group" action="/admin/hotel/picture?id=${idHotel}"
					enctype="multipart/form-data" method="POST">
					<h5 class="card-title">Ajout image</h5>
					<input name="id" id="id" type="hidden" class="form-control"
						value="${idHotel}">
					<div class="form-row">
						<div class="position-relative form-group">
							<div class="col-md-6">
								<label for="photo" class="">Inserer Photo</label> <input
									name="picturePart" id="file" type="file" />
							</div>

						</div>
					</div>

					<div class="form-row">
						<div class="position-relative form-group">
							<div class="col-md-6">
								<label for="type" class="">Type</label> <select name="type"
									id="type" class="form-control">
									<c:forEach var="type" items="${types}">

										<option value="${type}">${type}</option>

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
					<h5 class="card-title">Liste des Themes de Voyage</h5>
					<table class="mb-0 table table-striped">
						<thead>
							<tr>
								<th>Picture</th>
								<th>Type</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="picture" items="${pictures}">
								<tr>
									<td><img style='display: block; width: 50px; height: 50px;'
									id='base64image'
									src='data:image/jpeg;base64,${picture.getBase64()}' /></td>
									<td style="color: black">${picture.type}</td>
									<td style="color: black">${themes.description}</td>
									<td><a href="/admin/theme/deleteTheme/${themes.id}"
										class="delete"><i class="bi bi-trash"></i>DELETE</a>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

	</layout:put>
</layout:extends>