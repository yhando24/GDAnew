
<%@ include file="/Resources/inc/header.jsp"%>
<title>Absences Adiministrateur</title>
</head>

<body id="page-top">

	<%@ include file="/Resources/inc/navbar.jsp"%>
	<%@ include file="/Resources/inc/sidebar-admin.jsp"%>
	<!-- /.container-fluid -->
<div id="content-wrapper">

		<div class="container-fluid">

			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="index.html">Dashboard</a>
				</li>
				<li class="breadcrumb-item active">Ajout de jour f�ri�</li>
			</ol>

	<div class="container">

			<div class="form-row">
				<div class='form-group col-md-6 offset-md-3'>
					<h3>Ajout de jours f�ri�s</h3>
					<form action='<c:url value="/AddAbsence"/>' method="POST">
						<span> <label for="champ1">Date du jour f�ri�</label> <input
							name="dayoff" class="custom-select" type="date" id="champ1"
							name="date">
						</span> <span> <label for="champ2">Type de cong�</label> <select
							name="ferieType" class="custom-select">
								<option value="1" selected>Jour f�ri�</option>
								<option value="2">RTT employeur</option>
						</select>
						</span> <span> <label for="message">Commentaire</label> <textarea
								type="text" id="message" name="comment" rows="2"
								class="form-control md-textarea"></textarea>
						</span> <span> <a class="btn btn-annuler">Annuler</a>
							<button type="submit" class="btn btn-envoyer ">Envoyer</button>
						</span>
					</form>
				</div>
			</div>
		</div>


	</div>
	<%@ include file="/Resources/inc/footer.jsp"%>