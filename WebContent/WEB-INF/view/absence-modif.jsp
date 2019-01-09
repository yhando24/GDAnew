<%@ include file="/Resources/inc/header.jsp"%>
<title>Modification des absences</title>
</head>
<body>
	<%@ include file="/Resources/inc/navbar.jsp"%>
	<c:choose>
		<c:when test="${user.function == 'admin'}">
	    	<%@ include file="/Resources/inc/sidebar-admin.jsp"%>
	  	</c:when>
		<c:when test="${user.function == 'manager'}">
	   		en attente du link
	  	</c:when>
		<c:when test="${user.function == 'user'}">
	    	<%@ include file="/Resources/inc/sidebar-user.jsp"%>
	  	</c:when>
	</c:choose>
	
	<div class="container">
		<h1>Gestion des absences</h1>
		
			
			<div>
				<div>
					Modifier une absence 
					
				</div>
				<div>
					Soldes des compteurs: 
					CP: ..... jours. 
					RTT: .... jours.
				</div>
			</div>
		
	</div>
