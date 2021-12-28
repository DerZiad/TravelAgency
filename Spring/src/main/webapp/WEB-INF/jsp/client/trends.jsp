<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--blog start-->
<section id="blog" class="blog">
	<div class="container">
		<div class="blog-details">
			<div class="gallary-header text-center">
				<h2>latest news</h2>
				<p>Travel News from all over the world</p>
			</div>
			<!--/.gallery-header-->
			<div class="blog-content">
				<div class="row">
					<c:forEach items="${trends}" var="voyage">
						<div class="col-sm-4 col-md-4">
							<div class="thumbnail">
								<h2>
									trending news <span>${voyage.getDateDepartDate()}</span>
								</h2>
								<div class="thumbnail-img">
									<img src="data:image/jpeg;base64,${voyage.getHeader()}" alt="blog-img">
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
		</div>
		<!--/.blog-details-->
	</div>
	<!--/.container-->

</section>
<!--/.blog-->
<!--blog end-->