<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="/Resources/inc/header.jsp"%>

<title>Absences Management</title>
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

			<!-- Dï¿½but barre container-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a
					href="<c:url value="/indexEmployee"/>">Dashboard</a></li>
				<li class="breadcrumb-item active">Gestion des absences</li>
			</ol>
			<!-- Fin barre container-->

			<div class="container">
				<h1>Gestion des absences</h1>
				<c:if test="${!empty user}">
					<div class="table-responsive-md">
						<table class="table ">
							<thead>
								<tr>
									<th scope="col">Date début</th>
									<th scope="col">Date de fin</th>
									<th scope="col">Type</th>
									<th scope="col">Statut</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${user.absences}" var="abs" varStatus="status">
									<tr scope="row">
										<c:set var="dateStart"
											value="${fn:substring(abs.startDate, 0, 10)}" />
										<c:set var="dateEnd"
											value="${fn:substring(abs.endDate, 0, 10)}" />
										<fmt:parseDate value="${dateStart}" pattern="yyyy-MM-dd" var="dateStart"/>
										<fmt:parseDate value="${dateEnd}" pattern="yyyy-MM-dd" var="dateEnd"/>
										<td><fmt:formatDate value="${dateStart}" pattern="dd-MM-yyyy"/></td> 
										<td><fmt:formatDate value="${dateEnd}" pattern="dd-MM-yyyy"/></td> 					
										<td>${abs.absenceType.name}</td>
										<td>${abs.status.name}</td>
										<td><c:choose>
												<c:when test="${abs.absenceType.name == 'MISSION'}">
													<i class="fas fa-eye"></i>

												</c:when>
												<c:otherwise>
													<c:choose>
														<c:when test="${abs.status.name == 'INITIALE'}">
															<a
																href="<c:url value ="/absences-management?action=updateAbsence&absId=${abs.id}"/>">
																<i class="fas fa-pencil-alt"></i>
															</a>
															<a
																href="<c:url value ="/absences-management?action=deleteAbsence&absId=${abs.id}"/>">
																<i class="fas fa-trash-alt"></i>
															</a>
														</c:when>
														<c:when
															test="${abs.status.name == 'EN_ATTENTE_VALIDATION'}">
															<a
																href="<c:url value ="/absences-management?action=updateAbsence&absId=${abs.id}"/>">
																<i class="fas fa-pencil-alt"></i>
															</a>
															<a
																href="<c:url value ="/absences-management?action=deleteAbsence&absId=${abs.id}"/>">
																<i class="fas fa-trash-alt"></i>
															</a>
														</c:when>
														<c:when test="${abs.status.name == 'VALIDEE'}">
															<%-- <a
																href="<c:url value ="/absences-management?action=deleteAbsence&absId=${abs.id}"/>">
																<i class="fas fa-trash-alt"></i>
															</a> --%>
														</c:when>
														<c:when test="${abs.status.name == 'REJETEE'}">
															<a
																href="<c:url value ="/absences-management?action=updateAbsence&absId=${abs.id}"/>">
																<i class="fas fa-pencil-alt"></i>
															</a>
															<a
																href="<c:url value ="/absences-management?action=deleteAbsence&absId=${abs.id}"/>">
																<i class="fas fa-trash-alt"></i>
															</a>

														</c:when>
													</c:choose>
												</c:otherwise>
											</c:choose></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div>
						<div>
							Demander une absence <a
								href="<c:url value ="/absences-management?action=addAbsence"/>">
								<i class="far fa-plus-square"></i>
							</a>
						</div>

						<div>Soldes des compteurs: CP: ${nbrOfDayCp} jours. RTT:
							${nbrOfDayRtt} jours.</div>
					</div>
				</c:if>
			</div>

		</div>
		<%@ include file="/Resources/inc/footer.jsp"%>