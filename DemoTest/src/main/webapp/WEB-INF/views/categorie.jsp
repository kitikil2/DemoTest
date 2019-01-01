<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<meta charset="UTF-8">
<title>Gestiondes eleves</title>
 <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
</head>
<body>




<nav class="navbar navbar-inverse" role="navigation">
  <!-- Brand and toggle get grouped for better mobile display -->
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
      <span class="sr-only">Toggle navigation</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="#">Brand</a>
  </div>

  <!-- Collect the nav links, forms, and other content for toggling -->
  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Accueil</a></li>
      <li><a href="#">Notification</a></li>
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Deconnection <b class="caret"></b></a>
      </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#">${proprio.nomProprietaire}</a></li>
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Deconnection <b class="caret"></b></a>
      </li>
    </ul>
  </div><!-- /.navbar-collapse -->
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
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
      <p><a href="#">Liste des chambre disponible</a></p>
    </div>

   <div class="col-sm-8 text-left"> 
      <div class="container" style="margin-top: 1em;">
    <!-- Sign up form -->
     <div class="container">
     <div>
      <c:if test="${config=='congif'}">
       <f:form modelAttribute="chambre" action="addchambre" method="post">
         <table>
            <tr>Crée un model de chambre</tr>
            <tr>
              <td>ID cite</td>
              <td><f:input path="cite.idCite" value="${singlcite.idCite}" readonly="readonly"/></td>
              <td></td>
            </tr>
            <tr>
              <td>Nom la chambre (Motif)</td>
              <td><f:input path="nomchambre"/></td>
              <td><f:errors path="nomchambre" cssClass=""></f:errors></td>
            </tr>
            <tr>
              <td>Prix chambre</td>
              <td><f:input path="prix"/></td>
              <td><f:errors path="prix"></f:errors></td>
            </tr>
            <tr>
              <td>Nom de cite</td>
              <td><input type="text" name="nomcite" value="${singlcite.nomCite}" readonly="readonly"/></td>
              <td></td>
            </tr>
            
            <tr>
              <td></td>
              <td><input type="submit" value="Valider"/></td>
              <td></td>
            </tr>
         </table>
        </f:form>
       </c:if>
       <c:if test="${config=='su'}">
           <h1 class="text-danger">veuillez configurer les standarts de vos chambre</h1>
       </c:if>
     </div>
     
   
   <div class="container-fluid">
     <c:if test="${indique=='listecite'}">
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
      </c:if>
      <c:if test="${indique=='listechambre'}">
      
         <header class="page-header">
                 <h2>Vous etez entrain de modifier les parametre de la ${singlcite.nomCite}</h2>
          </header>
         
       <c:forEach items="${listechambre}" var="lch">
        <div class="row">
        <f:form modelAttribute="chambre" action="modifierchambre" method="">
           <div class="col-md-6 d-flex align-items-center bd-highlight mb-3">
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
                  <td>Nom chambre :</td>
                  <td><f:input path="prix" value="${lch.prix}"/> </td>
                </tr>
            </table>
           </div>
           <div class="col-md-6">
               
               <f:select path="categorie.idCategorie">
                         <c:forEach items="${listecategorie}" var="lca">
                               <f:option value="${lca.idCategorie}">${lca.description} et ${lca.typeCategorie}</f:option>
                         </c:forEach>
               </f:select><br><br>
                <input type="submit" class="btn btn-primary btn-lg" value="Valider"><br>
                <c:if test="${lch.categorie!=null }">
                    <h5>Chambre configure</h5>
                </c:if>
           </div>
         </f:form>
        </div>
       </c:forEach>
      
        
      </c:if>
   </div>
   
   </div>

     </div>
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