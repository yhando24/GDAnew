<%@ include file="/Resources/inc/header.jsp"%>
<title>Absences Management</title>
</head>

<body>
    <%@ include file="/Resources/inc/navbar.jsp"%>
    <c:choose>
        <c:when test="${user.function.name == 'admin'}">
            <%@ include file="/Resources/inc/sidebar-admin.jsp"%>
        </c:when>
        <c:when test="${user.function.name == 'manager'}">
            en attente du link
        </c:when>
        <c:when test="${user.function.name == 'user'}">
            <%@ include file="/Resources/inc/sidebar-user.jsp"%>
        </c:when>
    </c:choose>

      <div id="content-wrapper">

        <div class="container-fluid">

          <!-- Breadcrumbs-->
          <ol class="breadcrumb">
                <li class="breadcrumb-item">
                  <a href="<c:url value="/indexAdministrator"/>">Dashboard</a>
                </li>
                <li class="breadcrumb-item active">Jours fériés</li>
              </ol>
		<div class="container">
		
		<!-- Mettre les jours fériés ici -->
		
      	</div>
    </div>
<%@ include file="/Resources/inc/footer.jsp" %>