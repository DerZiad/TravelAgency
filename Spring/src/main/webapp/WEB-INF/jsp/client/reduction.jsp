<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<div class="container">
			<div class="special-offer-content">
				<div class="row">
					<div class="col-sm-8">
						<div class="single-special-offer">
							<div class="single-special-offer-txt">
								<h2>${voyageReduction.destination}</h2>
								<div class="packages-review special-offer-review">
									<p>
										<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
											class="fa fa-star"></i> <i class="fa fa-star"></i> <i
											class="fa fa-star"></i> <span>2544 review</span>
									</p>
								</div>
								<!--/.packages-review-->
								<div class="packages-para special-offer-para">
									<p>
										<span> <i class="fa fa-angle-right"></i> 5 daays 6
											nights
										</span> <span> <i class="fa fa-angle-right"></i> 2 person
										</span> <span> <i class="fa fa-angle-right"></i> 5 étoiles
											recommandations
										</span>
									</p>
									<p>
										<span> <i class="fa fa-angle-right"></i> transportation
										</span> <span> <i class="fa fa-angle-right"></i> food
											facilities
										</span>
									</p>
									<p class="offer-para">
										${voyageReduction.description}
									</p>
								</div>
								<!--/.packages-para-->
								<div class="offer-btn-group">
									<!--/.about-btn-->
									<div class="about-btn">
										<button class="about-view packages-btn" onclick="addToChart(${voyageReduction.id})">book now</button>
									</div>
									<!--/.about-btn-->
								</div>
								<!--/.offer-btn-group-->
							</div>
							<!--/.single-special-offer-txt-->
						</div>
						<!--/.single-special-offer-->
					</div>
					<!--/.col-->
					<div class="col-sm-4">
						<div class="single-special-offer">
							<div class="single-special-offer-bg">
								<img src="assets/images/offer/offer-shape.png" alt="offer-shape">
							</div>
							<!--/.single-special-offer-bg-->
							<div class="single-special-shape-txt">
								<h3>special offer</h3>
								<h4>
									<span>${voyageReduction.reduction}%</span><br>off
								</h4>
								<p>
									<span>€${voyageReduction.prix}</span><br>reduction €${voyageReduction.reductionPrix}
								</p>
							</div>
							<!--/.single-special-shape-txt-->
						</div>
						<!--/.single-special-offer-->
					</div>
					<!--/.col-->
				</div>
				<!--/.row-->
			</div>
			<!--/.special-offer-content-->
		</div>
		<!--/.container-->