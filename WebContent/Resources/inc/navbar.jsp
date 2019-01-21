
<nav class="navbar navbar-expand navbar-dark bg-dark static-top">
	<a class="navbar-brand mr-1" href='<c:url value="/indexAdministrator"/>'>
		<div id="logo-gda-nav">
			<img class="hvr-shrink"
				src="<c:url value='/Resources/css/images/logo.png'/>" alt="logo-gda">
		</div>
	</a>
	<div>
		<h2 class="bienvenue">Bienvenue sur l'application GDA - Gestion
			des absences</h2>
	</div>

	<!-- Navbar Search -->
		<div class="d-none d-md-inline-block ml-auto mr-0 mr-md-3 my-2 my-md-0">
			<h5 class ="bienvenue">${user.name} ${user.firstname} ${user.function.name}</h5>
			</div>


	<!-- Navbar -->
	<ul class="navbar-nav ml-auto ml-md-0">

		<li class="nav-item dropdown no-arrow mx-1"><a
			class="nav-link dropdown-toggle" href="#" id="messagesDropdown"
			role="button" data-toggle="dropdown" aria-haspopup="true"
			aria-expanded="false">  <span
				class="badge badge-danger"></span>
		</a>
			<div class="dropdown-menu dropdown-menu-right"
				aria-labelledby="messagesDropdown">
				<a class="dropdown-item" href="#"></a> <a class="dropdown-item"
					href="#"></a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="#"></a>
			</div></li>
		<li class="nav-item dropdown no-arrow"><a
			class="nav-link dropdown-toggle" href="#" id="userDropdown"
			role="button" data-toggle="dropdown" aria-haspopup="true"
			aria-expanded="false"> <i class="fas fa-user-circle fa-fw"></i>
		</a>
			<div class="dropdown-menu dropdown-menu-right"
				aria-labelledby="userDropdown">
				<a class="dropdown-item" href="#">Compte</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="#" data-toggle="modal"
					data-target="#logoutModal">Se déconnecter</a>
			</div></li>
	</ul>

</nav>