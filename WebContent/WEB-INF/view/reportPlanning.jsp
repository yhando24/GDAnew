<%@ include file="/Resources/inc/header.jsp"%>
<title>Planning</title>
<%-- <link href='<c:url value="/Resources/css/chart.css"/>' rel="stylesheet"> --%>
</head>

<body>
	<%@ include file="/Resources/inc/navbar.jsp"%>
	<%@ include file="/Resources/inc/sidebar-manager.jsp"%>
	<%@ include file="/Resources/inc/planning-js.jsp"%>
	
	<div id="content-wrapper">

		<div class="container-fluid">

			<!-- Dï¿½but  barre container-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a
					href="<c:url value="/indexEmployee"/>">Dashboard</a>
				</li>
				<li class="breadcrumb-item active">Planning</li>
			</ol>
			<!-- Fin barre container-->

			<div class="container">
				<form action='<c:url value="/report-planning"/>' method="POST">
					<div class="row align-items-end">

						<div class="col-2 offset-2">
							<label for="departement">Departement:</label> <select
								id="departement" name="departement" class="custom-select"
								onchange="this.form.submit()">
								<option value="1">informatique</option>
								<option value="2">ressource humaine</option>
							</select>
						</div>

						<div class="col-2">
							<label for="month">Mois:</label> <select id="month" name="month"
								class="custom-select" onchange="this.form.submit()">
								<option value="1">Janvier</option>
								<option value="2">Février</option>
								<option value="3">Mars</option>
								<option value="4">Avril</option>
								<option value="5">Mai</option>
								<option value="6">Juin</option>
								<option value="7">Juillet</option>
								<option value="8">Août</option>
								<option value="9">Septembre</option>
								<option value="10">Octobre</option>
								<option value="11">Novembre</option>
								<option value="12">Décembre</option>
							</select>
						</div>
						<div class="col-2">
							<label for="year">Année:</label> <select id="year" name="year"
								class="custom-select" onchange="this.form.submit()">
								<option>2017</option>
								<option>2018</option>
								<option>2019</option>
								<option>2020</option>
								<option>2021</option>
								<option>2022</option>
							</select>
						</div>

						<div class="col-1 offset-1 ">
							<i class="fas fa-search-plus fa-2x"></i>
						</div>
						<div class="col-1">
							<i class="far fa-file-excel fa-2x"></i>
						</div>
					</div>
				</form>

			</div>

			<div class=" container-vue table-responsive-xl m10">
				<table class=" table tableau-vue table-striped">
					<thead>
						<tr>
							<td>Nom</td>
							<c:forEach begin="1" end="31" varStatus="jour">
								<td scope="">${ jour.index }</td>
							</c:forEach>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${ plop.keySet() }" var="name">
							<tr>
								<td>${name}</td>
								<c:forEach items="${ plop.get(name) }" var="type">
									<td>${type}</td>
								</c:forEach>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- Fin container table -->
			
			
			<!-- Légende -->
			<h3>Légende :</h3>
			


				<div > C : Congé payé</div>
				<div > R : RTT</div>
				<div > S : Congé sans
					solde</div>
				<div > R_E : RTT employeur</div>

			</div>

		</div>
	</div>

	
	<%@ include file="/Resources/inc/footer.jsp"%>>