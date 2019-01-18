<%@ include file="/Resources/inc/header.jsp"%>
<title>Vue synthétique</title>
<link href='<c:url value="/Resources/css/chart.css"/>' rel="stylesheet">
</head>

<body onload="selectedGreatOption()">
	<%@ include file="/Resources/inc/navbar.jsp"%>
	<%@ include file="/Resources/inc/sidebar-manager.jsp"%>
	 <%@ include file="/Resources/inc/chart-js.jsp"%>

	<div id="content-wrapper">

		<div class="container-fluid">

			<!-- Dï¿½but  barre container-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a
					href="<c:url value="/indexEmployee"/>">Dashboard</a>
				</li>
				<li class="breadcrumb-item active">Vue synthétique</li>
			</ol>
			<!-- Fin barre container-->

			<div>
			<form action='<c:url value="/report-chart"/>' method="POST">
				<div class="row align-items-end">
				
					<div class="col-sm-2 offset-sm-2">
						<label for="departement">Departement:</label> <select
							id="departement" name="departement" class="custom-select" onchange="this.form.submit()">
							<option value="1">informatique</option>
							<option value="2">ressource humaine</option>
						</select>
					</div>
					
					<div class="col-sm-2">
						<label for="month">Mois:</label> <select id="month" name="month"
							class="custom-select" onchange="this.form.submit()">
							<option value="1" >Janvier</option>
							<option value="2" >Février</option>
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
					<div class="col-sm-2">
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
					
					<div class="col-sm-1 offset-sm-1 col-3 offset-4">
						<i class="fas fa-search-plus fa-2x"></i>
					</div>
					<div class="col-sm-1 col-5">
						<i class="far fa-file-excel fa-2x"></i>
					</div>
				</div>
				</form>
				<div class="container m10">
					<div class="row ">
					
						<div class="col-12 ">
						<canvas id="myChart" width="1000" height="500"></canvas>
						</div>
					</div>
				</div>
				
			</div>
		</div>
		<%@ include file="/Resources/inc/footer.jsp"%>>