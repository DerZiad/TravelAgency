<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://kwonnam.pe.kr/jsp/template-inheritance"
	prefix="layout"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<layout:extends name="layout-resp.jsp">
	<layout:put block="content" type="REPLACE">
		<div class="app-page-title">
			<div class="page-title-wrapper">
				<div class="page-title-heading">
					<div class="page-title-icon">
						<i class="pe-7s-car icon-gradient bg-mean-fruit"
							style="color: red;"> </i>
					</div>
					<div>
						Dashboard
						<div class="page-title-subheading">Welcome to the Wie Batouta Admin Panel. This powerful tool empowers you to manage every aspect of the Wie Batouta platform with ease and precision. From overseeing reservations to optimizing user experiences, the Admin Panel puts you in control. Stay informed, make strategic decisions, and ensure seamless operations to provide exceptional travel experiences for our community. Unlock the full potential of Wie Batouta with this dynamic hub.</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6 col-xl-4">
				<div class="card mb-3 widget-content bg-midnight-bloom">
					<div class="widget-content-wrapper text-white">
						<div class="widget-content-left">
							<div class="widget-heading">Travels Number</div>
							<div class="widget-subheading">Upcoming Future Travel Count</div>
						</div>
						<div class="widget-content-right">
							<div class="widget-numbers text-white">
								<span>${voyagesnumber}</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6 col-xl-4">
				<div class="card mb-3 widget-content bg-arielle-smile">
					<div class="widget-content-wrapper text-white">
						<div class="widget-content-left">
							<div class="widget-heading">Teams Number</div>
						</div>
						<div class="widget-content-right">
							<div class="widget-numbers text-white">
								<span>${equipesnumber}</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-6 col-xl-4">
				<div class="card mb-3 widget-content bg-grow-early">
					<div class="widget-content-wrapper text-white">
						<div class="widget-content-left">
							<div class="widget-heading">Reservations Number</div>
							<div class="widget-subheading">Count of the paid reservation</div>
						</div>
						<div class="widget-content-right">
							<div class="widget-numbers text-white">
								<span>${reservationsnumber}</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="d-xl-none d-lg-block col-md-6 col-xl-4">
				<div class="card mb-3 widget-content bg-premium-dark">
					<div class="widget-content-wrapper text-white">
						<div class="widget-content-left">
							<div class="widget-heading">Nombre d'hotel</div>
							<div class="widget-subheading">Nombre d'hotels reconnus</div>
						</div>
						<div class="widget-content-right">
							<div class="widget-numbers text-warning">
								<span>${hotelsnumber}</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12 col-lg-12">
				<div class="mb-3 card">
					<div class="card-header-tab card-header-tab-animation card-header">
						<div class="card-header-title">
							<i class="header-icon lnr-apartment icon-gradient bg-love-kiss">
							</i> The most visited Countries
						</div>
					</div>
					<div class="card-body">
						<div class="tab-content">
							
							<div class="tab-pane show active" id="tabs-eg-77">

									<div class="widget-chat-wrapper-outer">
										<div
											class="widget-chart-wrapper widget-chart-wrapper-lg opacity-10 m-0">
											<!-- chart here -->
											<div id="columnchart_material"></div>
										</div>
									</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="main-card mb-3 card">
					<div class="card-header">
						Recommended Teams
					</div>
					<div class="table-responsive">
						<table
							class="align-middle mb-0 table table-borderless table-striped table-hover">
							<thead>
								<tr>
									<th class="text-center">Picture</th>
									<th class="text-center">Name</th>
									<th class="text-center">Email</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${equipes}" var="equipe">
								<tr>
									<td>
										<div class="widget-content p-0">
											<div class="widget-content-wrapper">
												<div class="widget-content-left mr-3">
													<div class="widget-content-left">
														<img width="40" class="rounded-circle"
															src="data:image/jpeg;base64,${equipe.personne.getBase64()}" alt="">
													</div>
												</div>
											</div>
										</div>
									</td>
									<td class="text-center">${equipe.personne.nom} ${equipe.personne.prenom}</td>
									<td class="text-center">
										<div class="badge badge-warning">${equipe.personne.email}</div>
									</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

	</layout:put>
</layout:extends>