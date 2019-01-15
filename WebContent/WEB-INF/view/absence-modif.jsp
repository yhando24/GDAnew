<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="/Resources/inc/header.jsp"%>
<title>Modification Absences</title>
</head>

<body onload="checkTypeConges(${absenceAModifier.absenceType.id})">
	<%@ include file="/Resources/inc/navbar.jsp"%>

	

	<div id="content-wrapper">

		<div class="container-fluid">

			<!-- Dï¿½but barre container-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a
					href="<c:url value="/indexEmployee"/>">Dashboard</a></li>
				<li class="breadcrumb-item active">Gestion des absences</li>
				<li class="breadcrumb-item active">Modification des absences</li>
			</ol>
			<!-- Fin barre container-->

			<div class="container">

				<!-- Page Content -->
				<div class="container">
					<div class="form-row">
						<div class='form-group col-md-6 offset-md-3'>
							<h3>Modification d'absence</h3>
							<form action='<c:url value="/update-absence"/>' method="POST">
								<span> <label for="champ1">Date de début</label> <input
									name="beginAbsence" class="custom-select debutDateJs"
									onchange="verifDateDebut()" type="date" id="champ1" name="date"
									value="${fn:substring(absenceAModifier.startDate, 0, 10)}">
								</span> <span class="messageDebutDate"
									style="display: none; color: red">Veuillez saisir une
									date de debut supérieure à la date actuelle svp</span> <span>
									<label for="champ2">Date de fin</label> <input
									name="endAbsence" class="custom-select finDateJs"
									onchange="verifDateFin()" type="date" id="champ1" name="date"
									value="${fn:substring(absenceAModifier.endDate, 0, 10)}">
								</span> <span class="messageFinDate" style="display: none; color: red">Date
									de fin inférieure é la date de début. Veuillez saisir une date
									de fin correcte svp</span> <span> <label for="champ2">Type
										de congé</label> 
								<select name="congeType" class="custom-select" id="congeTypeJs" onchange="verifConge()" required>
										<option value="">Type de congé</option>
										<option value="1" class="typeconges">Congé payé</option>
										<option value="2" class="typeconges">RTT</option>
										<option value="3" class="typeconges">Congé sans solde</option>
								</select>
								</span> <span> <label for="message">Motif</label> <textarea
										id="motifJs" type="text" id="message" name="motif" rows="2"
										class="form-control md-textarea">${absenceAModifier.reason}</textarea>
								</span> <span> <a class="btn btn-annuler"
									href='<c:url value="/absences-management"/>'>Annuler</a>
									<button type="submit" class="btn btn-envoyer ">Envoyer</button>
								</span> <span class="text-center errorMessageLogin"> <c:if
										test="${!empty errorAdd}">
										<p>${errorAdd}</p>
									</c:if>
								</span>
							</form>
						</div>
					</div>
				</div>

			</div>
			<!-- /.container-fluid -->



			<%@ include file="/Resources/inc/footer.jsp"%>
			<script src='<c:url value="/Resources/js/addAbsenceGestion.js"/>'></script>