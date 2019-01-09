<%@ include file="/Resources/inc/header.jsp" %>
    <title>Forgot Password</title>
  </head>

  <body id="page-top">

    <nav class="navbar navbar-expand navbar-dark bg-dark static-top">
        <a class="navbar-brand mr-1" href="index.html">
          <div id="logo-gda-nav">
            <img class="hvr-shrink" src="css/images/logo.png" alt="logo-gda">
          </div>
        </a>
      <button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
        <i class="fas fa-bars"></i>
      </button>

      <!-- Navbar Search -->
      <form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
        <div class="input-group">
          <input type="text" class="form-control" placeholder="Rechercher" aria-label="Search" aria-describedby="basic-addon2">
          <div class="input-group-append">
            <button class="btn btn-primary" type="button">
              <i class="fas fa-search"></i>
            </button>
          </div>
        </div>
      </form>

      <!-- Navbar -->
      <ul class="navbar-nav ml-auto ml-md-0">
         
        <li class="nav-item dropdown no-arrow mx-1">
          <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-envelope fa-fw"></i>
            <span class="badge badge-danger"></span>
          </a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="messagesDropdown">
            <a class="dropdown-item" href="#"></a>
            <a class="dropdown-item" href="#"></a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#"></a>
          </div>
        </li>
        <li class="nav-item dropdown no-arrow">
          <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-user-circle fa-fw"></i>
          </a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
            <a class="dropdown-item" href="#">Activité</a>
            <a class="dropdown-item" href="#">Compte</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Se déconnecter</a>
          </div>
        </li>
      </ul>

    </nav>

    <div id="wrapper">

      <!-- Sidebar -->
      

      <div id="content-wrapper">

        <div class="container-fluid">

          <!-- Breadcrumbs-->
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="index.html">Dashboard</a>
            </li>
            <li class="breadcrumb-item active">Demande d'absence</li>
          </ol>

          <!-- Page Content -->
          <div class="container">
            <div class="form-row">
                <div class='form-group col-md-6 offset-md-3'>
                    <h3>Demande d'absence</h3>
                    <form action='<c:url value="/AddAbsence"/>' method="POST"> 
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

        <!-- Sticky Footer -->
        <footer class="footer-gda">
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
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Prêt à partir?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Selectionner se déconnecter si vous voulez quitter votre session</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            <a class="btn btn-primary" href="login.html">Se déconnecter</a>
          </div>
        </div>
      </div>
    </div>

<%@ include file="/Resources/inc/footer.jsp" %>
