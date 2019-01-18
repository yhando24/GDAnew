<%@ include file="/Resources/inc/header.jsp"%>
<title>Login</title>


</head>
<body>
<body class="bg-dark">

<!-- modal -->
<div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
    
    
    <div class="modal-header">
  		<h5>Veuillez saisir votre adresse mail :</h5>
  		</div>
  		<div class="modal-body">
			<form method="post" action='<c:url value="/forget-password"/>'>
			 <div class="form-group">
			 	<div class="form-label-group">
			 		<input type="email" id="inputEmailForget" class="form-control" required="required" name="emailForget"> 
			 		<label for="inputEmailForget">Email</label>
			 	</div>                     
			 </div>      
			                
			 <button type="submit" class="btn btn-primary">Valider</button>  
			                 
			 </form>
			 </div>
    </div>
  </div>
</div>


	<div class="container">
		<div class="card card-login mx-auto mt-5">
			<div class="card-header">Connexion</div>
			<div class="card-body">
				<div class="container text-center">
					<img id="logo-gda-login"
						src="<c:url value='/Resources/css/images/logo.png'/>"
						alt="logo-gda">
				</div>

				<form method="post" action='<c:url value="/login"/>'>
					<div class="form-group">
						<div class="form-label-group">
							<input type="email" id="inputEmail" class="form-control"
								placeholder="Email address" required="required"
								autofocus="autofocus" name="email"> <label
								for="inputEmail">Email</label>
						</div>
					</div>
					<div class="form-group">
						<div class="form-label-group">
							<input type="password" id="inputPassword" class="form-control"
								placeholder="Password" required="required" name="password">
							<label for="inputPassword">Mot de passe</label>
						</div>
					</div>


					<button type="submit" class="btn btn-primary btn-block">Connexion</button>

				</form>


				<h5 class="text-center errorMessageLogin">
					<%
						if (null != request.getAttribute("errorMessage")) {
							out.println(request.getAttribute("errorMessage"));
						}
					%>
									
				</h5>
						<c:if test="${!empty ModifiedPassword }"><h5 style="color:green"> ${ModifiedPassword } </h5></c:if>	

				<div class="text-center">
			<button type="button" class="btn btn-info" data-toggle="modal" data-target=".bd-example-modal-lg">Mot de passe oublié</button>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/Resources/inc/footer.jsp"%>