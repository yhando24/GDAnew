<%@ include file="/Resources/inc/header.jsp"%>
<title>Ajout Jours F�ri�s</title>
</head>

<body id="page-top">

	<%@ include file="/Resources/inc/navbar.jsp"%>
	<c:choose>
		<c:when test="${user.function.name == 'admin'}">
			<%@ include file="/Resources/inc/sidebar-admin.jsp"%>
		</c:when>
		<c:when test="${user.function.name == 'manager'}">
			<%@ include file="/Resources/inc/sidebar-manager.jsp"%>
		</c:when>
	</c:choose>
	<!-- /.container-fluid -->

	<div id="content-wrapper">

		<div class="container-fluid">

			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a
					href="<c:url value="/indexAdministrator"/>">Dashboard</a></li>
				<li class="breadcrumb-item active">Jours f�ri�s</li>
				<li class="breadcrumb-item active">Ajout de jours f�ri�s</li>
			</ol>

			<div class="container">

				<div class="form-row">
					<div class='form-group col-md-6 offset-md-3'>
						<h3>Ajout de jours f�ri�s</h3>
						<form action='<c:url value="/create-day-off"/>' method="POST">
							<span> <label for="champ1">Date du jour f�ri�s</label> <input
								class="custom-select dateDayOff" type="date"
								onchange="verifDateFerie()" id="champ1" name="date">
							</span> <span class="messagejourAnterieur"
								style="display: none; color: red">Veuillez saisir une
								date sup�rieure � la date actuelle svp</span> <span
								class="messageweekend" style="display: none; color: red">Un
								jour f�ri� ne peut pas �tre un samedi ou dimanche</span> <span>
								<label for="champ2">Type de cong�</label> <select
								onchange="verifType()" name="ferieType" class="custom-select"
								id="ferieType">
									<option value="1" selected>Jour f�ri�</option>
									<option value="2">RTT employeur</option>
							</select>
							</span> <span> <label for="message">Commentaire</label> <textarea
									type="text" id="message" name="comment" rows="2"
									class="form-control md-textarea"></textarea>
							</span> <span> <a class="btn btn-annuler">Annuler</a>
								<button type="submit" class="btn btn-envoyer "
									id="boutonaddFerie">Envoyer</button>
							</span>
						</form>
					</div>
				</div>
			</div>


		</div>
		<%@ include file="/Resources/inc/footer.jsp"%>


		<script src='<c:url value="/Resources/js/addFerieGestion.js"/>'></script>