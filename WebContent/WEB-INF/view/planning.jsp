<%@ include file="/Resources/inc/header.jsp"%>
<title>Planning</title>
</head>

<body>
	<%@ include file="/Resources/inc/navbar.jsp"%>
	<c:choose>
		<c:when test="${user.function.name == 'admin'}">
			<%@ include file="/Resources/inc/sidebar-admin.jsp"%>
		</c:when>
		<c:when test="${user.function.name == 'manager'}">
			<%@ include file="/Resources/inc/sidebar-manager.jsp"%>
		</c:when>
		<c:when test="${user.function.name == 'user'}">
			<%@ include file="/Resources/inc/sidebar-user.jsp"%>
		</c:when>
	</c:choose>
	


<div id="content-wrapper">
		
		<div class="container-fluid">

			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a
					href="

<c:choose>
		<c:when test="${user.function.name == 'admin'}">
			<c:url value="/indexAdministrator"/>
		</c:when>
		<c:when test="${user.function.name == 'manager'}">
			<c:url value="/indexManager"/>
		</c:when>
		<c:when test="${user.function.name == 'user'}">
			<c:url value="/indexEmployee"/>
		</c:when>
	</c:choose>

">

Dashboard</a></li>
					<li class="breadcrumb-item active">Planning</li>
			</ol>
		<!-- Fin barre container-->

		<div class="container">
			<div class="month text-center">
				<ul>
		
					<li>
						<h3>
							Janvier<br>2019
						</h3>
					</li>
				</ul>
			</div>
			<table class="table text-center">
				<thead>
					<tr>
						<th>Lundi</th>
						<th>Mardi</th>
						<th>Mercredi</th>
						<th>Jeudi</th>
						<th>Vendredi</th>
						<th>Samedi</th>
						<th>Dimanche</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="passed-day">31</td>
						<%@ page import="java.io.*,java.util.*,java.lang.*, java.time.*"%>
						<%
							String pattern = "yyyy-MM-dd";
							String startDateStr = "";
							String endDateStr = "";

							LocalDate startDate = LocalDate.of(2019, 1, 1);
						%>
						<c:set var="indexDate" value="<%=startDate%>" />
						<c:forEach begin="1" end="31" varStatus="loop">
							<c:set var="exist" value="false" />
							<c:forEach items="${user.absences }" var="absence">


								<c:choose>
									<c:when
										test="${indexDate >= absence.startDate && indexDate <= absence.endDate }">
										<c:set var="exist" value="true" />
												<c:if test="${absence.status.id == '2'}">
													<c:set var="validation" value="ValidationAttente" />
												</c:if>
													<c:if test="${absence.status.id != '2'}">
													<c:set var="validation" value="" />
												</c:if>
										<c:if test="${absence.absenceType.id == '1'}">
										
											<c:set var="type" value="couleur-conge-paye" />
										</c:if>
										
										<c:if test="${absence.absenceType.id == '2'}">
										
											<c:set var="type" value="couleur-rtt" />
										</c:if>
										
										<c:if test="${absence.absenceType.id == '3'}">	
										
											<c:set var="type" value="couleur-conge-sans-solde" />
										</c:if>
										
									
										<c:if test="${absence.absenceType.id == '5'}">
										
											
										
											<c:set var="type" value="couleur-rtt-employeur" />

										</c:if>
									</c:when>

									<c:otherwise>

							

									</c:otherwise>

								</c:choose>


							</c:forEach>
							<c:if test="${exist == 'true'}">
								<td class="${type}" id="${validation}">${loop.index}</td>
							</c:if>
							<c:if test="${exist == 'false'}">
								<td>${loop.index}</td>

							</c:if>

							<c:if test="${loop.index == '6'}">
					</tr>
					<tr>
						</c:if>

						<c:if test="${loop.index  == '13'}">
					</tr>
					<tr>
						</c:if>
						<c:if test="${loop.index  == '20'}">
					</tr>
					<tr>
						</c:if>
						<c:if test="${loop.index  == '27'}">
					</tr>
					<tr>
						</c:if>
						<%
							startDate = startDate.plusDays(1);
						%>
						<c:set var="indexDate" value="<%=startDate%>" />
						</c:forEach>


					</tr>

				</tbody>
			</table>
			<h3>Légende :</h3>
			<div class="row text-center">


				<div class="couleur-conge-paye-legende col">Congé payé</div>
				<div class="couleur-rtt-legende col">RTT</div>
				<div class="couleur-conge-sans-solde-legende col">Congé sans
					solde</div>
				<div class="couleur-jour-ferie-legende col">Jour férié</div>
				<div class="couleur-rtt-employeur-legende col">RTT employeur</div>
			</div>
			<div class="row text-center">


				<div class="couleur-conge-paye-legende col AttenteValidationLegende">En attente de validation</div>
				<div class="couleur-rtt-legende col AttenteValidationLegende">En attente de validation</div>
				<div class="couleur-conge-sans-solde-legende col AttenteValidationLegende">En attente de validation</div>
				<div class="couleur-jour-ferie-legende col AttenteValidationLegende">En attente de validation</div>
				<div class="couleur-rtt-employeur-legende col AttenteValidationLegende">En attente de validation</div>
			</div>

		</div>
		<!-- End Container -->
	</div>
	<%@ include file="/Resources/inc/footer.jsp"%>