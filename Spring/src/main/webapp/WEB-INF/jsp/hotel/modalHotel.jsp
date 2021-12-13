<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Edit Modal HTML -->
<div id="addEmployeeModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">Add Hotel</h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label>NomHotel</label> <input type="text" class="form-control"
						name="hotelname" required>
				</div>
				<div class="form-group">
					<label>Nombre etoiles</label> <span id="star1" class="C2etoiles"><div></div></span>
					<span id="star2" class="C2etoiles"><div></div> </span> <span
						id="star3" class="C2etoiles"><div></div></span> <span id="star4"
						class="C2etoiles"><div></div></span> <span id="star5"
						class="C2etoiles"><div></div></span> <input type="hidden"
						name="star" value="1" />
				</div>
				<div class="form-group">
					<label>Pays</label> <select class="form-control" name="country">
						<c:forEach var="country" items="${countries }">
							<option value="${country.keyCountry}">${country.valueCountry}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label>Lieux</label> <select class="selectpicker form-control"
						data-live-search="true" name="state">

					</select>
				</div>
			</div>
			<div class="modal-footer">
				<input type="button" class="btn btn-default" data-dismiss="modal"
					value="Cancel"> <input type="submit" name="add"
					class="btn btn-success" value="Add">
			</div>
		</div>
	</div>
</div>
<!-- Edit Modal HTML -->
<div id="editEmployeeModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<form>
				<div class="modal-header">
					<h4 class="modal-title">Edit Employee</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label>Name</label> <input type="text" class="form-control"
							required>
					</div>
					<div class="form-group">
						<label>Email</label> <input type="email" class="form-control"
							required>
					</div>
					<div class="form-group">
						<label>Address</label>
						<textarea class="form-control" required></textarea>
					</div>
					<div class="form-group">
						<label>Phone</label> <input type="text" class="form-control"
							required>
					</div>
				</div>
				<div class="modal-footer">
					<input type="button" class="btn btn-default" data-dismiss="modal"
						value="Cancel"> <input type="submit" class="btn btn-info"
						value="Save">
				</div>

			</form>
		</div>
	</div>
</div>
<!-- Delete Modal HTML -->
<div id="deleteEmployeeModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">Delete Employee</h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
			</div>
			<div class="modal-body">
				<p>Are you sure you want to delete these Records?</p>
				<p class="text-warning">
					<small>This action cannot be undone.</small>
				</p>
			</div>
			<div class="modal-footer">
				<input type="button" class="btn btn-default" data-dismiss="modal"
					value="Cancel"> <input data-dismiss="modal" type="submit" name="delete"
					class="btn btn-danger" value="Delete">
			</div>
		</div>
	</div>
</div>
