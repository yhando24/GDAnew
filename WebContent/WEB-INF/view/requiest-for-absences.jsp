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
		                    <label for="champ1">Date de d�but</label>
                            <input name="beginAbsence" class="custom-select" type="date" id="champ1" name="date">
                        </span> 
                        <span> 
                            <label for="champ2">Date de fin</label>
                            <input name="endAbsence" class="custom-select" type="date" id="champ1" name="date">
                        </span> 
                        <span>
                            <label for="champ2">Type de cong�</label>
                            <select name="congeType" class="custom-select">
                                <option selected>Type de cong�</option>
                                <option value="1">Cong� pay�</option>
                                <option value="2">RTT</option>
                                <option value="3">Cong� sans solde</option>
                            </select>
                        </span>
                        <span>
                            <label for="message">Motif</label>
                            <textarea type="text" id="message" name="reason" rows="2" class="form-control md-textarea"></textarea>
                        </span>

                        <span>
                            <a class="btn btn-annuler" >Annuler</a>
                            <button type="submit" class="btn btn-envoyer " >Envoyer</button>
                        </span>
                    </form> 
		        </div>
            </div>
		
      	</div>
    </div>
    </div>
<%@ include file="/Resources/inc/footer.jsp" %>

       