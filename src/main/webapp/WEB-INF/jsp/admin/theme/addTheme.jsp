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
				<form class="form-group" action="/admin/theme"
					enctype="multipart/form-data" method="POST">
					<h5 class="card-title">Create travel topic</h5>
					<input name="id" id="id" type="hidden" class="form-control"
						value="${theme.id}">
					<div class="form-row">
						<div class="col-md-6">
							<div class="position-relative form-group">
								<input name="name"
									id="name" placeholder="Topic" type="text"
									class="form-control" value="${theme.label}">
							</div>
							<p style="color: red;">

								<c:if test="${bool}">
									<c:out value="${errors.description}"></c:out>
								</c:if>
							</p>
						</div>
					</div>

					<div class="form-row">
						<div class="col-md-6">
							<div class="position-relative form-group">
								<input
									name="description" id="name"
									placeholder="Topic Description" type="text"
									class="form-control" value="${theme.description}">

							</div>
							<p style="color: red;">
								<c:if test="${bool}">
									<c:out value="${errors.label}"></c:out>
								</c:if>
							</p>
						</div>
					</div>

					<div class="form-row">
						<div class="col-md-6" id="cin">
							<div class="position-relative form-group alert">
								<div class="row">
									<c:if test="${bool}">
										<div class="col-md-6">
											<img style='display: block; width: 100px; height: 100px;'
												id='base64image' name="img"
												src='data:image/jpeg;base64,${theme.encodedPicture}' />
											<p>1</p>
											<div>
												<label for="photo" class="">Insert Picture</label> <input
													name="logo" id="file" type="file" />
											</div>
										</div>

									</c:if>
									<c:if test="${modify}">
										<div class="col-md-6">
											<img style='display: block; width: 100px; height: 100px;'
												id='base64image' name="img"
												src='data:image/jpeg;base64,${theme.encodedPicture}' />
											<p>2</p>
											<div>
												<label for="photo" class="">Insert Picture</label> <input
													name="logo" id="file" type="file" />
											</div>
										</div>
									</c:if>
									<c:if test="${! modify && empty errors}">
									    <p>3</p>
										<div class="col-md-6">
											<div class="col-md-6">
												<label for="photo" class="">Insert Picture</label> <input
													name="logo" id="file" type="file" />
											</div>
										</div>
									</c:if>

								</div>

							</div>
						</div>
					</div>


					<p style="color: red;">
						<c:if test="${bool}">
							<c:out value="${errors.picture}"></c:out>
						</c:if>
					</p>


					<div class="col-md-6">
						<button class="mt-2 btn btn-primary" type="submit">Save</button>
					</div>

					<div class="col-md-6">
						<button id="rst" class=" mt-2 btn btn-danger" value="Reset">Delete</button>
					</div>


				</form>
			</div>
			<div class="main-card mb-3">
				<div class="card-body">
					<h5 class="card-title">List of Topics</h5>
					<table class="mb-0 table table-striped">
						<thead>
							<tr>
								<th>Topic ID</th>
								<th>Topic Title</th>
								<th>Topic Description</th>
								<th>Perform Actions</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="themes" items="${themes}">
								<tr>
									<td><a style="color: black"
										href="/admin/theme/${themes.id}"> ${themes.id}</a></td>
									<td style="color: black">${themes.label}</td>
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
	<layout:put block="scriptsfile" type="REPLACE">
		<script src="/delibdesign/js/Theme/script.js"></script>
		<script src="/delibdesign/js/hotel/template.js"></script>
	</layout:put>
</layout:extends>