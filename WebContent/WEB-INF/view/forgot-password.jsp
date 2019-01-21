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
				<c:when test="${!empty question }">
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
				
				<c:when test="${!empty UserReal }">
				
					<form name="changePassword" method="post" action='<c:url value="/forget-password?action=changePassword"/>'>
					<div class="form-group">
						<div class="form-label-group">
					Saisir votre nouveau mot de passe :<input type="password" id="inputNewPassword" name="inputNewPassword" class="form-control">
					<br>		
						Saisir de nouveau votre mot de passe :<input type="password" id="inputNewPasswordVerif" class="form-control" onchange="verifSamePassword()">			
							<span class="hiddenMessage" style="display:none; color:red">Votre mot de passe n'est pas identique</span>				
							<input type="hidden" name="userToCheck" value="${userId}">
						</div>
					</div>
					<button id="buttonValidPassword" class="btn btn-primary btn-block">Envoyer</button>
				</form>
				
				
				</c:when>
				
					<c:when test="${!empty FalseReponse }">
				
			<h4>Votre réponse à la question secrète est erronée.
				Veuillez contacter un administrateur.
			</h4>
				
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
	
		<script src='<c:url value="/Resources/js/verifPassword.js"/>'></script>