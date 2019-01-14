<%@ include file="/Resources/inc/header.jsp"%>
<title>404</title>
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

			<!-- D�but barre container-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="index.html">Dashboard</a>
				</li>
				<li class="breadcrumb-item active">Gestion des absences</li>
			</ol>
			<!-- Fin barre container-->

			<div class="container">

				<!-- Page Content -->
				<h1 class="display-1">404</h1>
				<p class="lead">
					Page not found. Vous pouvez <a href="javascript:history.back()">revenir
						en arrière</a> jusqu'� la page pr�cèdente, ou <a href="index.html">retourner
						� la page d'accueil</a> .
				</p>

			</div>
		</div>
		<%@ include file="/Resources/inc/footer.jsp"%>