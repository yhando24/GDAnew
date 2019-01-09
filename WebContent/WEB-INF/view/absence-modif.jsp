<%@ include file="/Resources/inc/header.jsp"%>
<title>Modification des absences</title>
</head>
<body id="page-top">

    <%@ include file="/Resources/inc/navbar.jsp"%>

    <div id="wrapper">

      <%@ include file="/Resources/inc/sidebar-user.jsp"%>
      

      <div id="content-wrapper">

        <div class="container-fluid">

          <!-- Breadcrumbs-->
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="index.html">Dashboard</a>
            </li>
            <li class="breadcrumb-item active">Modification d'absence</li>
          </ol>

          <!-- Page Content -->
          <div class="container">
            <div class="form-row">
                <div class='form-group col-md-6 offset-md-3'>
                    <h3>Modification d'absence</h3>
                    <form action='<c:url value="/updateAbsence"/>' method="POST"> 
                        <span>         
		                    <label for="champ1">Date de début</label>
                            <input name="beginAbsence" class="custom-select" type="date" id="champ1" name="date">
                        </span> 
                        <span> 
                            <label for="champ2">Date de fin</label>
                            <input name="endAbsence" class="custom-select" type="date" id="champ1" name="date">
                        </span> 
                        <span>
                            <label for="champ2">Type de congé</label>
                            <select name="congeType" class="custom-select">
                                <option selected>Type de congé</option>
                                <option value="1">Congé payé</option>
                                <option value="2">RTT</option>
                                <option value="3">Congé sans solde</option>
                            </select>
                        </span>
                        <span>
                            <label for="message">Motif</label>
                            <textarea type="text" id="message" name="motif" rows="2" class="form-control md-textarea"></textarea>
                        </span>

                        <span>
                            <a class="btn btn-annuler" >Annuler</a>
                            <button type="submit" class="btn btn-envoyer " >Envoyer</button>
                        </span>
                    </form> 
		        </div>
            </div>
        </div>
        <!-- /.container-fluid -->

 

<%@ include file="/Resources/inc/footer.jsp" %>
