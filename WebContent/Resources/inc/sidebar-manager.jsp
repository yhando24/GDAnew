<div id="wrapper">

	<ul class="sidebar navbar-nav">
		<li class="nav-item"><a class="nav-link"
			href='<c:url value="/indexManager"/>'> <i
				class="fas fa-fw fa-tachometer-alt"></i> <span>Accueil</span>
		</a></li>

		<li class="nav-item"><a class="nav-link"
			href="<c:url value ="/absences-management"/>"> <i
				class="fas fa-fw fa-folder"></i> <span>Gestion des absences</span>
		</a></li>

		<li class="nav-item"><a class="nav-link" href='<c:url value="/Planning"/>'>
				<i class="fas fa-fw fa-folder"></i> <span>Planning</span>
		</a></li>

		<li class="nav-item"><a class="nav-link"
			href='<c:url value="/validation"/>'> <i
				class="fas fa-fw fa-folder"></i> <span>Validation</span>
		</a></li>      
        
         <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-fw fa-folder"></i>
          <span>Vue synthétique</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href='<c:url value="/report-planning"/>'>Vue Planning</a>
          <a class="dropdown-item" href='<c:url value="/report-chart"/>'>Histogramme</a>
        </div>
      </li>
        
        
        
        
        
        
        
	</ul>