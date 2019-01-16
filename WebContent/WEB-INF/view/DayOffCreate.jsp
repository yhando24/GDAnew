<%@ include file="/Resources/inc/header.jsp"%>
<title>Ajout Jours Fériés</title>
</head>

<body id="page-top">

	<%@ include file="/Resources/inc/navbar.jsp"%>

	<!-- /.container-fluid -->

	<div id="content-wrapper">

		<div class="container-fluid">

			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a
					href="<c:url value="/indexAdministrator"/>">Dashboard</a></li>
				<li class="breadcrumb-item active">Jours fériés</li>
				<li class="breadcrumb-item active">Ajout de jours fériés</li>
			</ol>


	<div class="container">

			<div class="form-row">
				<div class='form-group col-md-6 offset-md-3'>
					<h3>Ajout de jours fériés</h3>
					<form action='<c:url value="/create-day-off"/>' method="POST">
						<span> <label for="champ1">Date du jour férié</label> <input
							 class="custom-select dateDayOff" type="date" onchange="verifDateFerie()" id="champ1"
							name="date">
						</span>
						    <span class="messagejourAnterieur" style="display:none; color:red">Veuillez saisir une date supérieure à la date actuelle svp</span>   
							 <span class="messageweekend" style="display:none; color:red">Un jour ferié ne peux pas etre un samedi ou dimanche</span>
						 <span> <label for="champ2">Type de congé</label> <select  onchange="verifType()"
							name="ferieType" class="custom-select" id="ferieType">
								<option value="2" selected>Jour férié</option>
								<option value="1">RTT employeur</option>
						</select>
						</span> <span> <label for="message">Commentaire</label> <textarea
								type="text" id="message" name="comment" rows="2"
								class="form-control md-textarea" required></textarea>
						</span> <span> <a class="btn btn-annuler" href='<c:url value="/day-off-management"/>'>Annuler</a>
							<button type="submit" class="btn btn-envoyer " id ="boutonaddFerie">Envoyer</button>
							<c:if test="${!empty errorAdd }">${errorAdd}</c:if>
						</span>
					</form>

				</div>
			</div>


		</div>
		<%@ include file="/Resources/inc/footer.jsp"%>


		<script src='<c:url value="/Resources/js/addFerieGestion.js"/>'></script>