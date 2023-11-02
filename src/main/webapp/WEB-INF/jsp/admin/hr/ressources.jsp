<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
	prefix="layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<layout:extends name="../layout-resp.jsp">
	<layout:put block="content" type="REPLACE">
		<div class="main-card mb-3 card">
			<div class="card-body">
				<h5 class="card-title"></h5>
				<div class="row">
					<div class="col-md-6">
						<a class="btn btn-success" href="/admin/ressources/add">Add</a>
					</div>
					<div class="col-md-6"></div>
				</div>
			</div>
		</div>
		<div class="main-card mb-3 card">
			<div class="card-body">
				<h5 class="card-title">Liste des équipes</h5>
				<table class="mb-0 table table-striped">
					<thead>
						<tr>
							<th>Picture</th>
							<th>Team Title</th>
							<th>Boss lastname</th>
							<th>Boss firstname</th>
							<th>Perform Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="equipe" items="${equipes}">
							<tr>

								<td><img style='display: block; width: 50px; height: 50px;'
									id='base64image'
									src='data:image/jpeg;base64,${equipe.personne.getBase64()}' /></td>
								<td><a style="color: black" href="/admin/ressources/edit?">${equipe.label}</a></td>
								<td><a style="color: black" href="/admin/ressources/edit?">${equipe.personne.nom}</a></td>
								<td><a style="color: black" href="/admin/ressources/edit?">${equipe.personne.prenom}</a></td>
								<td><a href="/admin/ressources/add?id=${equipe.id}"
									class="edit"><i class="material-icons"
										data-toggle="tooltip" title="Edit">&#xE254;</i></a> <a
									href="/admin/ressources/delete?id=${equipe.id}" class="delete"><i
										class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

	</layout:put>
</layout:extends>