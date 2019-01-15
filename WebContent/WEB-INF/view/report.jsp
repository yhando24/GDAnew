<%@ include file="/Resources/inc/header.jsp"%>
<title>Vue synthétique</title>

</head>

<body>
	<%@ include file="/Resources/inc/navbar.jsp"%>
	<%@ include file="/Resources/inc/sidebar-user.jsp"%>


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
							<option >2017</option>
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
<canvas id="myChart" width="400" height="400"></canvas>
<button onclick="plop()"></button>
<script>

$( document ).ready(function() {
	var ctx = document.getElementById("myChart");
	var myChart = new Chart(ctx, {
	  type: 'bar',
	  data: {
	    labels: ["2015-01", "2015-02", "2015-03", "2015-04", "2015-05", "2015-06", "2015-07", "2015-08", "2015-09", "2015-10", "2015-11", "2015-12"],
	    datasets: [{
	      label: '# of Tomatoes',
	      data: [12, 19, 3, 5, 2, 3, 20, 3, 5, 6, 2, 1],
	      backgroundColor: [
	        'rgba(255, 99, 132, 0.2)',
	        'rgba(54, 162, 235, 0.2)',
	        'rgba(255, 206, 86, 0.2)',
	        'rgba(75, 192, 192, 0.2)',
	        'rgba(153, 102, 255, 0.2)',
	        'rgba(255, 159, 64, 0.2)',
	        'rgba(255, 99, 132, 0.2)',
	        'rgba(54, 162, 235, 0.2)',
	        'rgba(255, 206, 86, 0.2)',
	        'rgba(75, 192, 192, 0.2)',
	        'rgba(153, 102, 255, 0.2)',
	        'rgba(255, 159, 64, 0.2)'
	      ],
	      borderColor: [
	        'rgba(255,99,132,1)',
	        'rgba(54, 162, 235, 1)',
	        'rgba(255, 206, 86, 1)',
	        'rgba(75, 192, 192, 1)',
	        'rgba(153, 102, 255, 1)',
	        'rgba(255, 159, 64, 1)',
	        'rgba(255,99,132,1)',
	        'rgba(54, 162, 235, 1)',
	        'rgba(255, 206, 86, 1)',
	        'rgba(75, 192, 192, 1)',
	        'rgba(153, 102, 255, 1)',
	        'rgba(255, 159, 64, 1)'
	      ],
	      borderWidth: 1
	    }]
	  },
	  options: {
	    responsive: false,
	    scales: {
	      xAxes: [{
	        ticks: {
	          maxRotation: 90,
	          minRotation: 80
	        }
	      }],
	      yAxes: [{
	        ticks: {
	          beginAtZero: true
	        }
	      }]
	    }
	  }
	});
});

</script>
			</div>
		</div>
		<%@ include file="/Resources/inc/footer.jsp"%>>