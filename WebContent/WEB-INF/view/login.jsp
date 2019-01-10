
<%@ include file="/Resources/inc/header.jsp"%>
<title>SB Admin - Login</title>


</head>
<body>
<body class="bg-dark">

	<div class="container">
		<div class="card card-login mx-auto mt-5">
			<div class="card-header">Connection</div>
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


					<button type="submit" class="btn btn-primary btn-block">Connection</button>

				</form>


				<h2>
					<%
						if (null != request.getAttribute("errorMessage")) {
							out.println(request.getAttribute("errorMessage"));
						}
					%>
				</h2>


				<div class="text-center">
					<a class="d-block small mt-3" href="forgot-password.html">Mot
						de passe oublié?</a>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/Resources/inc/footer.jsp"%>