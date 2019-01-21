
<%@ include file="/Resources/inc/header.jsp"%>
<title>Validation des demandes</title>
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
					href="<c:url value="/indexManager"/>"> Dashboard</a></li>
				<li class="breadcrumb-item active">Gestion des absences</li>
			</ol>
			<!-- Fin barre container-->

			<div class="container">
				<h1>Validation des absences</h1>
				<c:if test="${!empty user}">
					<div class="table-responsive-md">
						<table class="table">
							<thead>
								<tr>
									<th>Nom</th>
									<th scope="col">Date début</th>
									<th scope="col">Date de fin</th>
									<th scope="col">Raison</th>
									<th scope="col">Type d'absence</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${allUsers}" var="user" varStatus="status">

									<tr>

										<td>${user.firstname }${user.name }</td>
										<td>
										<c:forEach items="${user.absences}" var="absence" varStatus="status">  
												<c:set var="dateStart" value="${fn:substring(absence.startDate, 0, 10)}" />
												<fmt:parseDate value="${dateStart}" pattern="yyyy-MM-dd" var="dateStart"/>
												<fmt:formatDate value="${dateStart}" pattern="dd-MM-yyyy"/>
											</c:forEach>
										<td><c:forEach items="${user.absences}" var="absence" varStatus="status">  
												<c:set var="dateEnd" value="${fn:substring(absence.endDate, 0, 10)}" />
												<fmt:parseDate value="${dateEnd}" pattern="yyyy-MM-dd" var="dateEnd"/>
												<fmt:formatDate value="${dateEnd}" pattern="dd-MM-yyyy"/>
												
											</c:forEach>
										</td>
										<td><c:forEach items="${user.absences}" var="absence"
												varStatus="status">  ${absence.reason} </c:forEach></td>
										<td><c:forEach items="${user.absences}" var="absence"
												varStatus="status">  ${absence.absenceType.name} </td>
										<td><a
											href="<c:url value ="/validation?action=validAbsence&id=${absence.id }"/>"><i
												class="fas fa-check"></i> </i> </a> <a
											href="<c:url value ="/validation?action=refuseAbsence&id=${absence.id }"/>">
												<i class="fas fa-times-circle"></i>
										</a></i>
								</c:forEach>
								</td>


								</td>
								</tr>




								</c:forEach>
							</tbody>
						</table>
					</div>
					<div></div>
				</c:if>
			</div>

		</div>
		<%@ include file="/Resources/inc/footer.jsp"%>