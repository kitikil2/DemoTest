<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>LOCATION</title>
<meta name="description" content="">
<meta name="author" content="">

<!-- Favicons
    ================================================== -->
 
<!-- <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>    -->

<link rel="shortcut icon" href="<%=request.getContextPath()%>/resources/img/favicon.ico" type="image/x-icon">
<link rel="apple-touch-icon"  href="<%=request.getContextPath()%>/resources/img/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72" href="<%=request.getContextPath()%>/resources/img/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114" href="<%=request.getContextPath()%>/resources/img/apple-touch-icon-114x114.png">

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.css">

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap-theme.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/fonts/font-awesome/css/font-awesome.css">
<script src="<%=request.getContextPath()%>/resources/js/bootstrap.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
<!-- Stylesheet

    ================================================== -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/nivo-lightbox/nivo-lightbox.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/nivo-lightbox/default.css">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">



<!-- Style  -->

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

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

<nav id="menu" class="navbar navbar-default navbar-fixed-top">
  <div class="container"> 
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
      <a class="navbar-brand page-scroll" href="#page-top">Location</a>
      <div class="phone"><span>Call Today</span>320-123-4321</div>
    </div>
    
    <!-- Collect the nav links, forms, and other content for toggling -->
    <f:form modelAttribute="logins" action="logins" method="post">
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
          <li>
             <a href="notifications?idpro=${proprio.idProprietaire}">
              <span class="text-danger">${notification}</span>
                 Notification
            </a>
          </li>
          <li>
           <a>
            ${proprio.nomProprietaire}
           </a>
          </li>
          <li>
            <a href="#" class="dropdown-toggle" >Deconnection</a>
          </li>
        
      </ul>
    </div>
  </f:form>
    
    <!-- /.navbar-collapse --> 
  </div>
</nav>  



<div id="about">
<div class="container"> 
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-xs-12 col-md-1 sidenav">
      <p>Configure les chambre<br>
         <c:forEach items="${listecite}" var="ci">
             <ul>
                  <c:if test="${ci.chambres!=null}">
                       <td><a href="configuechambre?idcite=${ci.idCite}">${ci.nomCite}</a></td>
                  </c:if>
            </ul>
         </c:forEach>
      </p>
      <p><a href="">Liste vos cite</a></p>
      <p><a href="#">Liste vos locataire</a></p>
      <p><a href="ajoutercite">Ajouter une cite</a></p>
    </div>

   <div class="col-lg-4 col-sm-8 col-xs-10"> 
      <div class="container" style="margin-top: 1em;">
    <!-- Sign up form -->
    
    
    
    <c:if test="${config=='congif'}">
    <div class="row">
      <div class="col-xs-12 col-md-3"> <img src="img/about.jpg" class="img-responsive" alt=""> </div>
      <div class="col-xs-12 col-md-8">
        <div class="about-text">
          <h2>Etez-vous proprietaire d'une cite. Inscrivez-vous</h2>
          <h3>${erreur}</h3>
          
          <f:form modelAttribute="chambre" action="addchambre" method="post" class="col-lg-15">
          <div class="list-style">
            <div class="col-lg-6 col-sm-6 col-xs-12">
              <ul>
                <li> Identifiant de la cité :
                        <f:input path="cite.idCite" value="${singlcite.idCite}" readonly="readonly" class="form-control"  />
                </li>
                <li>Nom la chambre (Motif) : 
                        <f:input path="nomchambre" class="form-control"/>
                        <f:errors path="nomchambre" cssClass="errors" class="text-danger"></f:errors>
                
                </li>
                
              </ul>
            </div>
            <div class="col-lg-6 col-sm-6 col-xs-12">
              <ul>
                <li>Prix de la chambre : 
                        <f:input path="prix" class="form-control"/>
                        <f:errors path="prix" cssClass="errors" class="text-danger"></f:errors>
                
                </li>
                <li>Nom de cite :
                        <input type="text" name="nomcite" value="${singlcite.nomCite}" readonly="readonly"/>
                
                </li>
              </ul>
            </div>
            <div class="col-xs-12 col-md-12 text-center">
            <ul>
              <li>
                 <input type="submit" class="btn btn-custom btn-lg page-scroll" value="Envoyer">
              </li>
            </ul>
            </div>
          </div>
          
 
     </f:form>     
      
        </div>
      </div>
    </div>
     </c:if>
    
     </div>
     
    <c:if test="${indique=='noti'}">
    
    
    <div id="portfolio">
  <div class="container">
    <div class="section-title">
      <h2>Accueil</h2>
    </div>
    
    <div class="container contact-form"> 
       <c:forEach items="${chambres}" var="ch">  
         
       <div class="col-md-4">
        <div class="service-desc">
          <h3>Information du locataire</h3>
          <h4>Mm/Mr :${ch.locataire.nomLocataire } ${ch.locataire.prenomLocataire} </h4>
          <p>Adresse mail :${ch.locataire.adresseEmail }
             <br><br>
             Numero de CNI :${ch.locataire.numerocni }
          </p>
        </div>
      </div>
      
      <div class="col-md-4">
        <div class="service-desc">
          <h3>Information de sa cité</h3>
          <h3>${ch.cite.nomCite } </h3>
          <p>
             
          </p>
        </div>
      </div>
      
      <div class="col-md-4">
        <div class="service-desc">
          <h3>Information de la chambre</h3>
          <h4>Nom chambre :${ch.nomchambre } </h4>
          <p>Prix de la chambre :${ch.prix} Fcfa
             <br><br>
            <h4 class="text-danger"> Somme totale à verser :${ch.prix*10 } Fcfa</h4>
          </p>
        </div>
      </div>
     </c:forEach> 
       </div>
  </div>
</div>
    
    
    </c:if>
    
     
 <div id="services">
  <div class="container">
    <div class="section">
      <h2>La liste de vos cité</h2>
    </div>
    <div class="row">       
     <c:forEach items="${listecite}" var="cite" >  
      <div class="col-md-4">
        <div class="service-media"> <img alt="" src="<%=request.getContextPath()%>/photoci?idCite=${cite.idCite }" class="img-thumbnail" width="50px"> </div>
        <div class="service-desc">
          <h3>${cite.nomCite}</h3>
          <p>${cite.descriptionCite}
             <br><br>
             <a href="configue?idcite=${cite.idCite}" class="btn btn-custom btn-lg page-scroll">Ajouter les chambres</a>
          </p>
        </div>
      </div>
     </c:forEach>
      
    </div>
  </div>
</div>
     
   <div class="container-fluid">
     <%-- <c:if test="${indique=='listecite'}">
        <table >
           <tr>
             <td>Nom de la cite</td><td>Nombre de chambre</td><td>Description</td><td>Photo de la cite</td>
           </tr>
           <c:forEach items="${listecite}" var="cite" >
              <tr>
                 <td>${cite.nomCite}</td>
                 <td>${cite.nombreChambre}</td>
                 <td>${cite.descriptionCite}</td>
                 <td><img alt="" src="<%=request.getContextPath()%>/photoci?idCite=${cite.idCite }" class="img-thumbnail" width="100px"></td>
                  <c:if test="${cite.chambres!=null}">
                       <td><a href="configue?idcite=${cite.idCite}">Configure</a></td>
                  </c:if>
              </tr>
           </c:forEach>
        </table>
      </c:if> --%>
      
      <c:if test="${indique=='listechambre'}">
      <div id="testimonials">
  <div class="container">
    <div class="section-title">
       <h2>Vous etez entrain de modifier les parametre de la ${singlcite.nomCite}</h2>
    </div>
    <div class="row">
     <c:forEach items="${listechambre}" var="lch">
      <div class="col-md-4">
        <div class="testimonial">
          <div class="testimonial-content">
            <div class="testimonial-meta"> <h4>Nom chambre :${lch.nomchambre}</h4> </div>
            <f:form modelAttribute="chambre" action="modifierchambre" method="">
            
             <table class="table table-condensed">
                <tr>
                  <td>ID cite</td>
                  <td><f:input path="cite.idCite" value="${singlcite.idCite}" readonly="readonly"/></td>
                </tr>
                <tr>
                  <td>ID chambre :</td>
                  <td><f:input path="idChambre" value="${lch.idChambre}" readonly="readonly"/> </td>
                </tr>
                <tr>
                  <td>Nom chambre :</td>
                  <td><f:input path="nomchambre" value="${lch.nomchambre}" readonly="readonly"/> </td>
                </tr>
                <tr>
                  <td>Prix chambre :</td>
                  <td><f:input path="prix" value="${lch.prix}"/> </td>
                </tr>
            </table>
            
            <f:select path="categorie.idCategorie">
                         <c:forEach items="${listecategorie}" var="lca">
                               <f:option value="${lca.idCategorie}">${lca.description} et ${lca.typeCategorie}</f:option>
                         </c:forEach>
               </f:select><br><br>
                <input type="submit" class="btn btn-primary btn-lg" value="Valider"><br>
                <c:if test="${lch.categorie!=null }">
                    <h5>Chambre configure</h5>
                </c:if>
            
            </f:form>
          </div>
        </div>
      </div>
      </c:forEach>
    </div>
  </div>
</div>
  </c:if>    
   </div>
   
   </div>

     </div>
    </div>
   
   <!-- <div class="col-sm-2 sidenav">
      <div class="well">
        <p>ADS</p>
      </div>
      <div class="well">
        <p>ADS</p>
      </div>
    </div> -->
  </div>
</div>
</div>
</div>
<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>
</body>
</html>