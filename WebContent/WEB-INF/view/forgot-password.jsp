<%@ include file="/Resources/inc/header.jsp"%>
<title>Forgot Password</title>
</head>

<body class="bg-dark">

	<div class="container">
		<div class="card card-login mx-auto mt-5">
			<div class="card-header">Mot de passe oublié</div>
			<div class="card-body">
				<div class="container text-center">
					<img id="logo-gda-login" src="<c:url value='/Resources/css/images/logo.png'/>" alt="logo-gda">
				</div>

				<div class="text-center mb-4">
				<c:choose>
				<c:when test="${empty UserReal }">
							<h5>${question.question}</h5>
			<form name="formCheckResponse" method="post" action='<c:url value="/forget-password?action=CheckReponse"/>'>
					<div class="form-group">
						<div class="form-label-group">
							<input type="text" id="inputResponse" name="reponse" class="form-control"
								placeholder="Enter response" required="required"
								autofocus="autofocus"> <label for="inputResponse">Votre Reponse</label>
							<input type="hidden" name="userToCheck" value="${question.idUser}">
						</div>
					</div>
					<button class="btn btn-primary btn-block">Envoyer</button>
				</form>
				<div class="text-center">
					<a class="d-block small mt-3" href='<c:url value="/login"/>'>Page de
						connection</a>
				</div>
				</c:when>
				
				
				
				<c:otherwise>
				
				
				
				
				</c:otherwise>
				</c:choose>
					
		
				</div>
				
	
			</div>
		</div>
	</div>

		
		
	<%@ include file="/Resources/inc/footer.jsp"%>