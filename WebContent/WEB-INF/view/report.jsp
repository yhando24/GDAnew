<%@ include file="/Resources/inc/header.jsp"%>
<title>Vue synthétique</title>
<link href='<c:url value="/Resources/css/chart.css"/>' rel="stylesheet">
</head>

<body>
	<%@ include file="/Resources/inc/navbar.jsp"%>
	<%@ include file="/Resources/inc/sidebar-user.jsp"%>
	<%@ include file="/Resources/inc/chart-js.jsp"%>

	<div id="content-wrapper">

		<div class="container-fluid">

			<!-- Dï¿½but  barre container-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="index.html">Dashboard</a>
				</li>
				<li class="breadcrumb-item active">Vue synthétique</li>
			</ol>
			<!-- Fin barre container-->

			<div class="container">
				<div class="row align-items-end">
					<div class="col-2 offset-2">
						<label for="departement">Departement:</label> <select
							id="departement" name="departement" class="custom-select">
							<option value="1" class="typeconges">informatique</option>
							<option value="2" class="typeconges">resource humaine</option>
						</select>
					</div>
					<div class="col-2">
						<label for="month">Mois :</label> <select id="month" name="month"
							class="custom-select">
							<option selected>Janvier</option>
							<option>Février</option>
							<option>Mars</option>
							<option>Avril</option>
							<option>Mai</option>
							<option>Juin</option>
							<option>Juillet</option>
							<option>Août</option>
							<option>Septembre</option>
							<option>Octobre</option>
							<option>Novembre</option>
							<option>Décembre</option>
						</select>
					</div>
					<div class="col-2">
						<label for="year">Année :</label> <select id="year" name="year"
							class="custom-select">
							<option>2017</option>
							<option>2018</option>
							<option selected>2019</option>
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