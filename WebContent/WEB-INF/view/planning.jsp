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
    
    <div id="content-wrapper">

        <div class="container-fluid">
        
        <!-- Début barre container-->
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="index.html">Dashboard</a>
            </li>
            <li class="breadcrumb-item active">Planning</li>
          </ol>
          <!-- Fin barre container-->

    <div class="container">

          <!-- Ajout planning ici -->
    
    </div>
    </div>
    <%@ include file="/Resources/inc/footer.jsp"%>