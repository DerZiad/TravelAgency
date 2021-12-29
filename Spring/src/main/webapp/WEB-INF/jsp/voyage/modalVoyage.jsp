<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Add Modal HTML -->
<div id="addEmployeeModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">Add Voyage</h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label>Titre</label> <input type="text" class="form-control"
						name="titre" required>
					<p id="titreError" class="error"></p>
				</div>
				<div class="form-group">
					<label>Destination</label> <select class="form-control"
						name="destination"></select>
					<p id="destinationError" class="error"></p>
				</div>
				<div class="form-group">
					<label>Description</label> <input type="text" class="form-control"
						name="description">
					<p id="descriptionError" class="error"></p>
				</div>
				<div class="form-group">
					<label>Prix</label> <input type="number" class="form-control"
						name="prix" required>
					<p id="prixError" class="error"></p>
				</div>
				<div class="form-row">
					<div class="col-md-6">
						<label>Type voyage</label> <select class="form-control"
							name="typeVoyage">
							<c:forEach items="${typeVoyages}" var="type">
								<option value="${type}">${type}</option>
							</c:forEach>
						</select>
						<p id="typeVoyageError" class="error"></p>
					</div>
					<div class="col-md-6">
						<label>Reduction </label> <input type="number"
							class="form-control" name="reduction" required />
						<p id="typeVoyageError" class="error"></p>
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-6">
						<label>Nombre personne total</label> <input type="number"
							class="form-control" name="nbrPersonnes" required />
					</div>
					<div class="col-md-6">
						<label>Nombre kilomètres</label> <input type="number"
							class="form-control" name="nbKilometres" required />
						<p id="nbKilometresError" class="error"></p>
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-6">
						<label>Age minimal</label> <input type="number"
							class="form-control" name="ageMin" required />
						<p id="ageMinError" class="error"></p>
					</div>
					<div class="col-md-6">
						<label>Age maximal</label><input type="number"
							class="form-control" name="ageMax" required />
						<p id="ageMaxError" class="error"></p>
					</div>
				</div>

				<div class="form-row">
					<div class="col-md-6">
						<label>Date départ</label> <input type="date" class="form-control"
							name="dateDepartDate" required />
						<p id="dateDepartError" class="error"></p>
					</div>
					<div class="col-md-6">
						<label>Date arrivée</label> <input type="date"
							class="form-control" name="dateArriveeDate" required />
						<p id="dateArriveeError" class="error"></p>
					</div>
				</div>
				<div class="form-group">
					<label>Equipe</label> <select class="form-control" name="idequipe"></select>
					<p id="equipeError" class="error"></p>
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
			<div class="modal-body">
				<div class="form-group">
					<label>Titre</label> <input type="text" class="form-control"
						name="titreEdit" required>
					<p id="titreError" class="error"></p>
				</div>
				<div class="form-group">
					<label>Destination</label> <select class="form-control"
						name="destinationEdit"></select>
					<p id="destinationError" class="error"></p>
				</div>
				<div class="form-group">
					<label>Description</label> <input type="text" class="form-control"
						name="descriptionEdit">
					<p id="descriptionError" class="error"></p>
				</div>
				<div class="form-group">
					<label>Prix</label> <input type="number" class="form-control"
						name="prixEdit" required>
					<p id="prixError" class="error"></p>
				</div>
				<div class="form-row">
					<div class="col-md-6">
						<label>Type voyage</label> <select class="form-control"
							name="typeVoyageEdit">
							<c:forEach items="${typeVoyages}" var="type">
								<option value="${type}">${type}</option>
							</c:forEach>
						</select>
						<p id="typeVoyageError" class="error"></p>
					</div>
					<div class="col-md-6">
						<label>Reduction </label> <input type="number"
							class="form-control" name="reductionEdit" required />
						<p id="reductionError" class="error"></p>
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-6">
						<label>Nombre personne total</label> <input type="number"
							class="form-control" name="nbrPersonnesEdit" required />
					</div>
					<div class="col-md-6">
						<label>Nombre kilomètres</label> <input type="number"
							class="form-control" name="nbKilometresEdit" required />
						<p id="nbKilometresError" class="error"></p>
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-6">
						<label>Age minimal</label> <input type="number"
							class="form-control" name="ageMinEdit" required />
						<p id="ageMinError" class="error"></p>
					</div>
					<div class="col-md-6">
						<label>Age maximal</label><input type="number"
							class="form-control" name="ageMaxEdit" required />
						<p id="ageMaxError" class="error"></p>
					</div>
				</div>

				<div class="form-row">
					<div class="col-md-6">
						<label>Date départ</label> <input type="date" class="form-control"
							name="dateDepartDateEdit" required />
						<p id="dateDepartError" class="error"></p>
					</div>
					<div class="col-md-6">
						<label>Date arrivée</label> <input type="date"
							class="form-control" name="dateArriveeDateEdit" required />
						<p id="dateArriveeError" class="error"></p>
					</div>
				</div>
				<div class="form-group">
					<label>Equipe</label> <select class="form-control"
						name="idequipeEdit"></select>
					<p id="equipeErrorEdit" class="error"></p>
				</div>
			</div>
			<div class="modal-footer">
				<input type="button" class="btn btn-default" data-dismiss="modal"
					value="Cancel" id="cancelAdd"> <input type="submit"
					name="edit" class="btn btn-success" value="Add">
			</div>
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
							<img class="d-block w-100" src="/images/notfound.jpg"
								alt="First slide">
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
