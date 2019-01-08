<%@ include file="/Resources/inc/header.jsp" %>
    <title>Forgot Password</title>
  </head>

  <body class="bg-dark">

    <div class="container">
      <div class="card card-login mx-auto mt-5">
        <div class="card-header">Mot de passe oublié</div>
        <div class="card-body">
            <div class="container text-center">
                <img id="logo-gda-login" src="css/images/logo.png" alt="logo-gda">
              </div>
          <div class="text-center mb-4">
            <h4>Vous ne retrouvez plus votre mot de passe?</h4>
            <p>Entrer votre adresse email et nous vous enverrons les instructions pour récupérer votre mot de passe</p>
          </div>
          <form>
            <div class="form-group">
              <div class="form-label-group">
                <input type="email" id="inputEmail" class="form-control" placeholder="Enter email address" required="required" autofocus="autofocus">
                <label for="inputEmail">Adresse email</label>
              </div>
            </div>
            <a class="btn btn-primary btn-block" href="login.html">Envoyer</a>
          </form>
          <div class="text-center">
            <a class="d-block small mt-3" href="login.html">Page de connexion</a>
          </div>
        </div>
      </div>
    </div>

<%@ include file="/Resources/inc/footer.jsp" %>