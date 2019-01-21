<%@ include file="/Resources/inc/header.jsp"%>
<title>Jours fériés et RTT Employeur Management</title>
</head>

<body>
	<%@ include file="/Resources/inc/navbar.jsp"%>
	<%@ include file="/Resources/inc/dayoff-js.jsp"%>
	<c:choose>
		<c:when test="${user.function.name == 'admin'}">
			<%@ include file="/Resources/inc/sidebar-admin.jsp"%>
		</c:when>
		<c:when test="${user.function.name == 'manager'}">
			<%@ include file="/Resources/inc/sidebar-manager.jsp"%>
		</c:when>
	</c:choose>

	<div id="content-wrapper">

		<div class="container-fluid">

			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a
					href="<c:url value="/indexAdministrator"/>">Dashboard</a></li>
				<li class="breadcrumb-item active">Gestion des Jours fériés et RTT Employeur</li>
			</ol>
			<div class="container text-center">
				<!-- Mettre les jours fériés ici -->
								<h2>Gestion des Jours fériés et RTT Employeur</h2>
								
			<div class="form-group row justify-content-md-center ">
			<div class="col-md-auto">
			<form action="<c:url value ="/day-off-management"/>" method="POST">
          		<label for="">Année</label>
          		<select class="form-control" id="selectYear" name="selectYear" data-table="order-table" onchange="this.form.submit()">
            		<option>2017</option>
            		<option>2018</option>
            		<option>2019</option>
            		<option>2020</option>
            		<option>2021</option>
            		<option>2022</option>
          		</select>
          	</form>	
          		</div>
        	</div>
				<c:if test="${!empty user}">
					<div class="table-responsive-md">
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Date </th>
									<th scope="col">Type</th>
									<th scope="col">Jour</th>
									<th scope="col">Commentaire</th>
									<th scope="col">Service</th>
									<th scope="col">Actions</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${dayoffs}" var="day" varStatus="status">
									<tr>
										<c:set var="date" value="${fn:substring(day.dayOff, 0, 10)}" />
										<fmt:parseDate value="${date}" pattern="yyyy-MM-dd" var="myDate"/>
										<td><fmt:formatDate value = "${myDate}" pattern = "dd/MM/yyyy" /></td>
										<td>${day.typeDayOff.name}</td>										
										<td><fmt:formatDate value = "${myDate}" pattern = "E" /></td>
										<td>${day.comment}</td>
										<td>${day.departement.name}</td>
										<td>	
											<a href="<c:url value ="/day-off-management?action=updateDayoff&dayId=${day.id}"/>">
												<i class="fas fa-pencil-alt"></i>
											</a>
											<a href="<c:url value ="/day-off-management?action=deleteDayoff&dayId=${day.id}"/>">
												 <i class="fas fa-trash-alt"></i>
											</a>																										
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div>
						<div>
							Ajouter un jour férié ou RTT Employeur <a
								href="<c:url value ="/day-off-management?action=addDayoff"/>">
								<i class="far fa-plus-square"></i>
							</a>
						</div>						
					</div>
				</c:if>

			</div>
		</div>
		<%@ include file="/Resources/inc/footer.jsp"%>
		
		