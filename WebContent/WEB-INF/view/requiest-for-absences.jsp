<%@ include file="/Resources/inc/header.jsp"%>
<title>Demande d'absence</title>
</head>
<body>
    <%@ include file="/Resources/inc/navbar.jsp"%>

            <%@ include file="/Resources/inc/sidebar-user.jsp"%>
 

      <div id="content-wrapper">

        <div class="container-fluid">

          <!-- Breadcrumbs-->
          <ol class="breadcrumb">
                <li class="breadcrumb-item">
                  <a href="index.html">Dashboard</a>
                </li>
                <li class="breadcrumb-item active">Gestion des absences</li>
                <li class="breadcrumb-item active">Demande d'absence</li>
              </ol>
		<div class="container">
		
		<!-- Page Content -->
          <div class="container">
            <div class="form-row">
                <div class='form-group col-md-6 offset-md-3'>
                    <h3>Demande d'absence</h3>
                    <form action='<c:url value="/AddAbsence"/>' method="POST"> 
                        <span>         
		                    <label for="champ1">Date de début</label>
                            <input name="beginAbsence" class="custom-select debutDateJs" onchange="verifDateDebut()" type="date" id="champ1" name="date">
                        </span> 
                        <span class="messageDebutDate" style="display:none; color:red">Veuillez saisir une date de debut supérieure à la date actuelle svp</span>
                        <span> 
                            <label for="champ2">Date de fin</label>
                            <input name="endAbsence" class="custom-select finDateJs"  onchange="verifDateFin()" type="date" id="champ1" name="date">
                            
                        </span>
                         <span class="messageFinDate" style="display:none; color:red">Date de fin inferieur à la date de début. Veuillez saisir une date de fin correcte svp</span>
                        <span>
                            <label for="champ2">Type de congé</label>
                            <select name="congeType" class="custom-select" id="congeTypeJs" onchange="verifConge()">
                                <option selected>Type de congé</option>
                                <option value="1">Congé payé</option>
                                <option value="2">RTT</option>
                                <option value="3">Congé sans solde</option>
                            </select>
                        </span>
                        <span>
                            <label for="message" >Motif</label>
                            <textarea id="motifJs" type="text" id="message" name="reason" rows="2" class="form-control md-textarea"></textarea>
                        </span>

                        <span>
                            <a class="btn btn-annuler" href='<c:url value="/AbsencesManagement"/>'>Annuler</a>
                            <button type="submit" class="btn btn-envoyer " >Envoyer</button>
                        </span>
                    </form> 
		        </div>
            </div>
		
      	</div>
    </div>
    </div>
<%@ include file="/Resources/inc/footer.jsp" %>



   <script src='<c:url value="/Resources/js/addAbsenceGestion.js"/>'></script>


