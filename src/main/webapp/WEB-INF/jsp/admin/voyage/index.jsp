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
							Manage your <b>travels</b> here
						</h2>
					</div>
					<div class="col-sm-6">
						<a href="#addEmployeeModal" class="btn btn-success"
							data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add
								New Travel</span></a> <a href="#deleteEmployeeModale"
							class="btn btn-danger" data-toggle="modal"><i
							class="material-icons">&#xE15C;</i> <span>Delete</span></a>
					</div>
				</div>
			</div>
			<table id="table" class="table table-striped table-hover"
				data-toggle="table" data-search="true" data-filter-control="true"
				data-show-export="true" data-click-to-select="true"
				data-toolbar="#toolbar">
				<thead>
					<tr>
						<th><span class="custom-checkbox"> <input
								type="checkbox" id="selectAll"> <label for="selectAll"></label>
						</span></th>


						<th data-field="Titre" data-filter-control="input"
							data-sortable="true">Title</th>
						<th data-field="Destination" data-filter-control="input"
							data-sortable="true">Destination</th>
						<th data-field="Date-depart" data-filter-control="select"
							data-sortable="true">Depart Date</th>
						<th data-field="Date-arrivee" data-filter-control="select"
							data-sortable="true">Arrived Date</th>
						<th data-field="Description" data-filter-control="input"
							data-sortable="true">Description</th>
						<th data-field="Nombre-personnes-inscrits" data-sortable="true">Number of registered participants</th>
						<th data-field="Nombre-personnes-totale" data-sortable="true">Total number of participants</th>
						<th data-field="Prix" data-sortable="true">Price</th>
						<th data-field="Reduction" data-sortable="true">Discount</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody id="voyageslist">

				</tbody>
			</table>
		</div>

	</layout:put>

	<layout:put block="modals" type="REPLACE">
		<jsp:include page="modalVoyage.jsp"></jsp:include>
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
		<script>
			//exporte les données sélectionnées
			var $table = $('#table');
			$(function() {
				$('#toolbar').find('select').change(function() {
					$table.bootstrapTable('refreshOptions', {
						exportDataType : $(this).val()
					});
				});
			})

			var trBoldBlue = $("table");

			$(trBoldBlue).on("click", "tr", function() {
				$(this).toggleClass("bold-blue");
			});
		</script>
		<script src="/delibdesign/js/voyage/script.js"></script>
		<script src="/delibdesign/js/voyage/template.js"></script>
		<script>
		$(document).ready(function() {
		    $('input[name=dateArriveeDate]').click(function() {
		        verifi();
		    });
		});
		function verifi() {
		    var dd = $('input[name=dateDepartDate]').val();
		    var da = $('input[name=dateArriveeDate]').val();
		    document.getElementById('dr').setAttribute("min",dd);
		    console.log(dd);
		}
		</script>
	</layout:put>
</layout:extends>