<%@ include file="/Resources/inc/header.jsp"%>
<title>Absences Management</title>
</head>
<body>
	<%@ include file="/Resources/inc/navbar.jsp"%>
	<c:choose>
		<c:when test="${user.function == 'admin'}">
	    	<%@ include file="/Resources/inc/sidebar-admin.jsp"%>
	  	</c:when>
		<c:when test="${user.function == 'manager'}">
	   		en attente du link
	  	</c:when>
		<c:when test="${user.function == 'user'}">
	    	<%@ include file="/Resources/inc/sidebar-user.jsp"%>
	  	</c:when>
	</c:choose>
	
	<div class="container">
		<h1>Gestion des absences</h1>
		<c:if test="${!empty user}">
			<table style="border: 1px solid">
				<tr>
					<th>Date debut</th>
					<th>date de fin</th>
					<th>type</th>
					<th>statut</th>
					<th>Action</th>
				</tr>

				<c:forEach items="${user.absences}" var="abs" varStatus="status">
					<tr>
						<td>${abs.startDate}</td>
						<td>${abs.endDate}</td>
						<td>${abs.startDate}</td>
						<td>${abs.absenceType.name}</td>
						<%-- <td>${abs.status.name}</td> --%>
						<td>
							<%-- <c:choose>
									<c:when test="${abs.type.name == 'MISSION'}">
										TYPE MISSION
									</c:when>
									<c:otherwise>
										<c:choose>
											<c:when test="${abs.status.name == 'INITIALE'}">
		    										INITIALE
		  										</c:when>
											<c:when test="${abs.status.name == 'EN_ATTENTE_VALIDATION'}">
		   							 				attente
		  										</c:when>
											<c:when test="${abs.status.name == 'VALIDEE'}">
		    										validee
		  										</c:when>
											<c:when test="${abs.type.name == 'REJETEE'}">
		    										rejete
		  										</c:when>
										</c:choose>
									</c:otherwise>
							</c:choose> --%>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div>
				<div>
					Demander une absence 
					<a href="<c:url value ="/AbsencesManagement?action=addAbsence"/>">
						<i class="far fa-plus-square"></i>
					</a>
				</div>
				<div>
					Modifier une absence 
					<a href="<c:url value ="/AbsencesManagement?action=updateAbsence"/>">
						<i class="far fa-plus-square"></i>
					</a>
				</div>
				<div>
					Soldes des compteurs: 
					CP: ..... jours. 
					RTT: .... jours.
				</div>
			</div>
		</c:if>
	</div>
<%@ include file="/Resources/inc/footer.jsp"%>