<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
	prefix="layout"%>
<layout:extends name="../layout-resp.jsp">
	<layout:put block="content" type="REPLACE">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6">
						<h2>
							Reservations
						</h2>
					</div>
					
				</div>
			</div>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th><span class="custom-checkbox"> <input
								type="checkbox" id="selectAll"> <label for="selectAll"></label>
						</span></th>
						<th>Id Voyage</th>
						<th>Reserved</th>
						<th>Confirmed</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody id="reservationslist">

				</tbody>
			</table>
		</div>

	</layout:put>

	
	<layout:put block="cssfiles" type="REPLACE">
		<style>
			.error {
				color: red;
				font-size: 15px;
			}
		</style>
		<link rel="stylesheet" href="/delibdesign/css/hotel/style.css" />
	</layout:put>

	<layout:put block="scriptsfile" type="REPLACE">
		<script src="/delibdesign/js/Reservation/script.js"></script>
		<script src="/delibdesign/js/Reservation/template.js"></script>
	</layout:put>
</layout:extends>