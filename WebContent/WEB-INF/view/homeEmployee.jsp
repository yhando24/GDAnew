<%@ include file="/Resources/inc/header.jsp"%>

<title>HomeEmployee</title>

</head>

<body id="page-top">

	<%@ include file="/Resources/inc/navbar.jsp"%>


	<div id="wrapper">

		<%@ include file="/Resources/inc/sidebar-user.jsp"%>

		<div id="content-wrapper">

			<div class="container-fluid">
					 
				Salut employé-e !!! L'absence est notre passion
			
			</div>
			<!-- /.container-fluid -->

			<!-- Sticky Footer -->
			<footer class="sticky-footer">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright © Promotion JAVA JEE - Diginamic - 2019</span>
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

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Prêt à partir?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Selectionner se déconnecter si vous
					voulez quitter votre session</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Se déconnecter</a>
				</div>
			</div>
		</div>
	</div>


	<%@ include file="/Resources/inc/footer.jsp"%>