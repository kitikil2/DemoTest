<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
 <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap-theme.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap-theme.min.css">
<meta charset="UTF-8">
  <script src="<%=request.getContextPath()%>/resources/js/bootstrap.js"></script>
  <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
<style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style>

<title>Inscription ou connection</title>
</head>
<body>













<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="text">Logo</a>
      
      <ul class="nav navbar-nav navbar-right form-inline" role="form">
        <f:form modelAttribute="login" action="login" method="post">
        <div class="card text-righ" style="width: 18rem;">
        <div class="card-body">
        <ul class="nav navbar-nav navbar-right">
            <li>
               <label class="sr-only">Login</label>
               <f:input path="login" type="text" class="form-control"  placeholder="login"/>
           </li>
           <li>
                <label class="sr-only" for="exampleInputPassword2">Password</label>
                <f:input path="password" type="text" class="form-control" placeholder="Password"/>
           </li>
           <li>
                <button type="submit" class="btn btn-primary">Sign in</button>
           </li>
        </ul>
        </div>
        </div>
      </f:form>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
    </div>
    <div class="col-sm-8 text-left"> 
      <section class="col-sm-10">
           <div class="row">
               <article class="col-md-10">
                   <f:form modelAttribute="proprietaire" action="saveProp" method="post" class="col-lg-6">
                        <legend>Etez-vous proprietaire d'une cite. Inscrivez-vous</legend>
                        ${erreur}
                        Nom : 
                        <f:errors path="nomProprietaire" cssClass="errors" class="text-danger"></f:errors>
                        <f:input path="nomProprietaire" type="text" class="form-control"/>
                        Prenom : 
                        <f:errors path="prenomProprietaire" cssClass="errors" class="text-danger"></f:errors>
                        <f:input path="prenomProprietaire" type="text" class="form-control"/>
                        <f:errors path="" cssClass="errors"></f:errors>
                        Sexe :
                        <f:select path="sexeProprietaire" class="form-control">
                               <f:option value="homme">homme</f:option>
                               <f:option value="femme">femme</f:option>
                        </f:select>
                        Adresse mail :
                        <f:errors path="adresseEmail" cssClass="errors" class="text-danger"></f:errors>
                        <f:input path="adresseEmail" type="text" class="form-control"/>
                        Numero de la carte national d'identite : 
                        <f:errors path="numeroCni" cssClass="errors" class="text-danger"></f:errors>
                        <f:input path="numeroCni" type="text" class="form-control"/>
                        Statu social :
                        <f:select path="statuSocial" class="form-control">
                           <f:option value="Celibataire">Celibataire</f:option>
                           <f:option value="marie">marie</f:option>
                        </f:select>
                        login : 
                        <f:errors path="login" cssClass="errors" class="text-danger"></f:errors>
                        <f:input path="login" type="text" class="form-control"/>
                        Mot de passe : 
                        <f:errors path="password" cssClass="errors" class="text-danger"></f:errors>
                        <f:input path="password" type="text" class="form-control"/>
                        <input type="submit" class="btn btn-primary" value="Envoyer">
                   </f:form>
             </article>
           </div>
          </section>
    </div>
    <div class="col-sm-2 sidenav">
      <div class="well">
        <p>ADS</p>
      </div>
      <div class="well">
        <p>ADS</p>
      </div>
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>

</body>
</html>