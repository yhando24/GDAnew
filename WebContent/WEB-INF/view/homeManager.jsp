
<%@ include file="/Resources/inc/header.jsp"%>

<title>HomeManager</title>

</head>

<body id="page-top">

	<%@ include file="/Resources/inc/navbar.jsp"%>
	<%@ include file="/Resources/inc/sidebar-manager.jsp"%>

		<div id="content-wrapper">

			<div class="container-fluid">

				<!-- Breadcrumbs-->
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
					<li class="breadcrumb-item active">Vue d'ensemble</li>
				</ol>

				<!-- Icon Cards-->
				<div class="row">
					<div class="col-xl-3 col-sm-6 mb-3">
						<div class="card text-white bg-primary o-hidden h-100">
							<div class="card-body">
								<div class="card-body-icon">
									<i class="fas fa-fw fa-comments"></i>
								</div>
								<div class="mr-5">26 Nouveaux Messages!</div>
							</div>
							<a class="card-footer text-white clearfix small z-1" href="#">
								<span class="float-left">Voir d�tails</span> <span
								class="float-right"> <i class="fas fa-angle-right"></i>
							</span>
							</a>
						</div>
					</div>
					<div class="col-xl-3 col-sm-6 mb-3">
						<div class="card text-white bg-warning o-hidden h-100">
							<div class="card-body">
								<div class="card-body-icon">
									<i class="fas fa-fw fa-list"></i>
								</div>
								<div class="mr-5">11 Nouvelles Demandes</div>
							</div>
							<a class="card-footer text-white clearfix small z-1" href="#">
								<span class="float-left">Voir d�tails</span> <span
								class="float-right"> <i class="fas fa-angle-right"></i>
							</span>
							</a>
						</div>
					</div>
					<div class="col-xl-3 col-sm-6 mb-3">
						<div class="card text-white bg-success o-hidden h-100">
							<div class="card-body">
								<div class="card-body-icon">
									<i class="fas fa-fw fa-shopping-cart"></i>
								</div>
								<div class="mr-5">123 New Orders!</div>
							</div>
							<a class="card-footer text-white clearfix small z-1" href="#">
								<span class="float-left">Voir d�tails</span> <span
								class="float-right"> <i class="fas fa-angle-right"></i>
							</span>
							</a>
						</div>
					</div>
					<div class="col-xl-3 col-sm-6 mb-3">
						<div class="card text-white bg-danger o-hidden h-100">
							<div class="card-body">
								<div class="card-body-icon">
									<i class="fas fa-fw fa-life-ring"></i>
								</div>
								<div class="mr-5">13 New Tickets!</div>
							</div>
							<a class="card-footer text-white clearfix small z-1" href="#">
								<span class="float-left">Voir d�tails</span> <span
								class="float-right"> <i class="fas fa-angle-right"></i>
							</span>
							</a>
						</div>
					</div>
				</div>

				<!-- Area Chart Example-->
				<div class="card mb-3">
					<div class="card-header">
						<i class="fas fa-chart-area"></i> Graphique des absences
					</div>
					<div class="card-body"></div>
				</div>

				<!-- DataTables Example -->
				<div class="card mb-3">
					<div class="card-header">
						<i class="fas fa-table"></i> Tableau des absences
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead>
									<tr>
										<th>Nom</th>
										<th>Poste</th>
										<th>Service</th>
										<th>Age</th>
										<th>D�but du cong�</th>
										<th>Fin du cong�</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>Nom</th>
										<th>Poste</th>
										<th>Service</th>
										<th>Age</th>
										<th>D�but du cong�</th>
										<th>Fin du cong�</th>
									</tr>
								</tfoot>
								<tbody>
									<tr>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>

								</tbody>
							</table>
						</div>
					</div>
				</div>

			</div>
			<!-- /.container-fluid -->

			<!-- Sticky Footer -->
			<footer class="sticky-footer">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright � Promotion JAVA JEE - Diginamic - 2019</span>
					</div>
				</div>
			</footer>

		</div>
		<!-- /.content-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>


	<%@ include file="/Resources/inc/footer.jsp"%>