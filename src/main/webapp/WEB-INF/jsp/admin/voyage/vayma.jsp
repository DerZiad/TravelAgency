<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
	prefix="layout"%>
<layout:extends name="../layout-resp.jsp">
	<layout:put block="content" type="REPLACE">
		<div class="container-fluid">
			<h1>Extended Table Plugin</h1>
			<div class="row">
				<div class="col-sm-12">

					<table class="table table-striped" id="myTable"
						data-freezecolumns="2">
						<thead>
							<tr>
								<th rowspan="2">Titre</th>
								<th rowspan="2">Destination</th>
								<th rowspan="2">prix</th>

								<th colspan="3">nb personnes</th>
								<th rowspan="2">Description</th>

								<th rowspan="2">Gender</th>
								<th colspan="3">reduction</th>
							</tr>
							<tr>
								<th>inscrits</th>
								<th>totale</th>
								<th>Street</th>
								<th>Reduction</th>
							</tr>
						</thead>
						<tbody id="voyageslist">
							<tr>
								<td>01 John</td>
								<td>Doe</td>
								<td>john@example.com</td>
								<td>23</td>
								<td>06</td>
								<td>1990</td>
								<td>Malea</td>
								<td>ABCD abcd</td>
								<td>hogwarts</td>
								<td>000000</td>
							</tr>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</layout:put>
	<layout:put block="cssfiles" type="REPLACE">

		<link rel="stylesheet" href="/delibdesign/css/voyage/style.css" />
	</layout:put>
	<layout:put block="scriptsfile" type="REPLACE">
		<script src="/delibdesign/js/voyage/script.js"></script>
		<!--  <script src="/delibdesign/js/voyage/template.js"></script>-->
		<script src="/delibdesign/js/voyage/ayman.js"></script>
	</layout:put>
</layout:extends>