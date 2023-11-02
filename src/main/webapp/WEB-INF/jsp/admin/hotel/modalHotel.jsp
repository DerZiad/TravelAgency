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
					<label>Hotel Name</label> <input type="text" class="form-control"
						name="hotelname" required>
					<p id="nomHotelError" class="error"></p>
				</div>
				<div class="form-group">
					<label>Hotel Stars</label> <span id="star1" class="C2etoiles"><div></div></span>
					<span id="star2" class="C2etoiles"><div></div> </span> <span
						id="star3" class="C2etoiles"><div></div></span> <span id="star4"
						class="C2etoiles"><div></div></span> <span id="star5"
						class="C2etoiles"><div></div></span> <input type="hidden"
						name="star" value="1" />
					<p id="nombreEtoileError" class="error"></p>
				</div>
				<div class="form-group">
					<label>Countries</label> <select class="form-control" name="country">
						<c:forEach var="country" items="${countries }">
							<option value="${country.keyCountry}">${country.valueCountry}</option>
						</c:forEach>
					</select>
					<p id="nombreEtoileError" class="error"></p>
				</div>
				<div class="form-group">
					<label>Destinations</label> <select class="selectpicker form-control"
						data-live-search="true" name="state">

					</select>
					<p id="villeError" class="error"></p>
				</div>
			</div>
			<div class="modal-footer">
				<input type="button" class="btn btn-default" data-dismiss="modal"
					value="Cancel" id="cancelAdd"> <input type="submit"
					name="add" class="btn btn-success" value="Add">
			</div>
		</div>
	</div>
</div>
<!-- Edit Modal HTML -->
<div id="editEmployeeModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">Edit Hotel</h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
			</div>
			<input id="idHotelEdit" type="hidden" name="idHotel" value=""/>
			<div class="modal-body">
				<div class="form-group">
					<label>Hotel Name</label> <input type="text" class="form-control"
						name="hotelnameEdit" required>
					<p id="nomHotelErrorEdit" class="error"></p>
				</div>
				<div class="form-group">
					<label>Hotel Stars</label> <span id="star1Edit"
						class="C2etoiles"><div></div></span> <span id="star2Edit"
						class="C2etoiles"><div></div> </span> <span id="star3Edit"
						class="C2etoiles"><div></div></span> <span id="star4Edit"
						class="C2etoiles"><div></div></span> <span id="star5Edit"
						class="C2etoiles"><div></div></span> <input type="hidden"
						name="starEdit" value="1" />
					<p id="nombreEtoileErrorEdit" class="error"></p>
				</div>
				<div class="form-group">
					<label>Countries</label> <select class="form-control" name="countryEdit">
						<c:forEach var="country" items="${countries }">
							<option value="${country.keyCountry}">${country.valueCountry}</option>
						</c:forEach>
					</select>
					<p id="nombreEtoileErrorEdit" class="error"></p>
				</div>
				<div class="form-group">
					<label>Destinations</label> <select class="selectpicker form-control"
						data-live-search="true" name="stateEdit">

					</select>
					<p id="villeErrorEdit" class="error"></p>
				</div>
			</div>
			<div class="modal-footer">
				<input type="button" class="btn btn-default" data-dismiss="modal"
					value="Cancel" id="cancelEdit"> <input id="editEdit"
					type="submit" name="edit" class="btn btn-success" value="Edit">
			</div>
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
					value="Cancel"> <input data-dismiss="modal" type="submit"
					name="delete" class="btn btn-danger" value="Delete">
			</div>
		</div>
	</div>
</div>
<!-- Delete All Modal HTML -->
<div id="deleteEmployeeModale" class="modal fade">
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
					value="Cancel"> <input data-dismiss="modal" type="submit"
					name="deleteAll" class="btn btn-danger" value="Delete">
			</div>
		</div>
	</div>
</div>
<!-- Add image -->
<div id="addImageModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">Pictures</h4>
			</div>
			<div class="modal-body">
				<div id="carouselExampleControls" class="carousel slide"
					data-ride="carousel">
					<div id="galerie" class="carousel-inner">
						<div class="carousel-item active">
							<img class="d-block w-100" src="/images/notfound.jpg" alt="First slide">
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleControls"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#carouselExampleControls"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
			</div>
		</div>
	</div>
</div>
