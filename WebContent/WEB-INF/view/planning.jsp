<%@ include file="/Resources/inc/header.jsp"%>
<title>Planning</title>
</head>

<body>
	<%@ include file="/Resources/inc/navbar.jsp"%>
	<c:choose>
		<c:when test="${user.function.name == 'admin'}">
			<%@ include file="/Resources/inc/sidebar-admin.jsp"%>
		</c:when>
		<c:when test="${user.function.name == 'manager'}">
			<%@ include file="/Resources/inc/sidebar-manager.jsp"%>
		</c:when>
		<c:when test="${user.function.name == 'user'}">
			<%@ include file="/Resources/inc/sidebar-user.jsp"%>
		</c:when>
	</c:choose>

        <div class="container-fluid">
        
        <!-- D�but barre container-->
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="index.html">Dashboard</a>
            </li>
            <li class="breadcrumb-item active">Planning</li>
          </ol>
          <!-- Fin barre container-->

    <div class="container" id="planning">
            <div class="calendar-section">
              <div class="row">
      
                <div class="col-sm-12">
      
                  <div class="calendar calendar-first" id="calendar_first">
                    <div class="calendar_header">
                      <button class="switch-month switch-left">
                        <i class="fa fa-angle-left"></i>
                      </button>
                      <h2></h2>
                      <button class="switch-month switch-right">
                        <i class="fa fa-angle-right"></i>
                      </button>
                    </div>
                    <div class="calendar_weekdays"></div>
                    <div class="calendar_content"></div>
                  </div>
      
                </div>
      
              </div> <!-- End Row -->
                  
            </div> <!-- End Calendar -->

            <h3>Légende :</h3>
            <div id="couleur-1">Congé payé</div>
            <div id="couleur-2">RTT</div>
            <div id="couleur-3">Congé sans solde</div>
            <div id="couleur-4">Jour férié</div>
            <div id="couleur-5">RTT employeur</div>

          </div> <!-- End Container -->
    </div>
    <%@ include file="/Resources/inc/footer.jsp"%>
