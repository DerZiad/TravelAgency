<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--blog start-->
<section id="blog" class="blog">
	<div class="container">
		<div class="blog-details">
			<div class="gallary-header text-center">
				<h2>latest news</h2>
				<p>At Wie Batouta, we take the hassle out of travel planning. Our dedicated team meticulously selects flights and hotels with competitive prices, ensuring that every aspect of your journey is taken care of. From accommodation to transportation, we've got you covered. With Wie Batouta, you can embark on your adventure worry-free, knowing that you're getting the best value for your investment.</p>
			</div>
			<!--/.gallery-header-->
			<div class="blog-content">
				<div class="row">
					<c:forEach items="${trends}" var="voyage">
						<div class="col-sm-4 col-md-4">
							<div class="thumbnail">
								<h2>
									trending news <span>${voyage.dateDepart}</span>
								</h2>
								<div class="thumbnail-img">
									<img src="data:image/jpeg;base64,${voyage.getHeader()}"
										alt="blog-img">
									<div class="thumbnail-img-overlay"></div>
									<!--/.thumbnail-img-overlay-->

								</div>
								<!--/.thumbnail-img-->

								<div class="caption">
									<div class="blog-txt">
										<h3>
											<a href="#"> ${voyage.titre} </a>
										</h3>
										<p>${voyage.description }</p>

										<div class="about-btn">
											<button onclick="addToChart(${voyage.id})"
												class="about-view packages-btn">book now</button>
										</div>
										<form method="GET" action="/myvoyage/${voyageReduction.id}">
											<div class="offer-btn-group">
												<div class="about-btn">
													<button class="about-view packages-btn">View</button>
												</div>
												<!--/.about-btn-->
											</div>
										</form>
									</div>
									<!--/.blog-txt-->
								</div>
								<!--/.caption-->
							</div>
							<!--/.thumbnail-->

						</div>
						<!--/.col-->
					</c:forEach>
				</div>

				<!--/.row-->
			</div>
			<!--/.blog-content-->
			<c:choose>
				<c:when test="${data.size() > 0 }">
					<div id="blog" class="blog">
						<div class="container">
							<div class="row">
								<div class="col-md-12">
									<div class="titlepage">
										<h2>Nos voyages</h2>

									</div>
								</div>
							</div>
							<div class="row">
								<c:forEach items="${data}" var="voyage">
									<div class="col-xl-4 col-lg-4 col-md-4 col-sm-6">
										<div class="blog-box">
											<figure>
												<img src="data:image/jpeg;base64,${voyage.getHeader()}"
													alt="blog-img">
											</figure>
											<div class="travel">
												<span>Destination : ${ voyage.destination }</span>
												<p>
													<strong class="Comment"> ${ voyage.prix} $</strong> Prix
												</p>
												<h3>${ voyage.getDestination() }AmazingTour</h3>
												<ul class="list-unstyled">
													<li><i class="fa fa-car"></i><strong> Date
															d'arrivée: </strong>${ voyage.dateArrivee }</li>

													<li><i class="fa fa-map-marker"></i> <strong>
															Nbre de Kilometre : </strong>${ voyage.nbKilometres }</li>
													<li><i class="fa fa-sun-o"></i> <strong> Type
															de voyage : </strong> ${ voyage.typeVoyage }</li>

												</ul>
												<form method="GET" action="/myvoyage/${voyageReduction.id}">
													<div class="offer-btn-group">
														<div class="about-btn">
															<button class="about-view packages-btn">View</button>
														</div>
														<!--/.about-btn-->
													</div>
												</form>
												<div class=" bottom text-center">
													<button onclick="addToChart(${voyage.id})"
														class="about-view packages-btn">book now</button>
												</div>

											</div>

										</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</c:when>

			</c:choose>

			<c:if test="${data.size() > 0 }">
				<div class="panel-footer">
					Showing ${number+1} of ${size+1} of ${totalElements}
					<ul class="pagination">
						<c:forEach begin="0" end="${totalPages-1}" var="page">
							<li class="page-item"><a
								href="search?country=default&date_depart=<%=new java.sql.Date(System.currentTimeMillis())%>&date_arrive=<%=new java.sql.Date(System.currentTimeMillis())%>&nbrePersonne=1&budget=30&srch=search++&page=${page}&size=${size}"
								class="page-link">${page+1}</a></li>
						</c:forEach>
					</ul>
				</div>
			</c:if>

		</div>
		<!--/.blog-details-->
	</div>
	<!--/.container-->

</section>
<!--/.blog-->
<!--blog end-->