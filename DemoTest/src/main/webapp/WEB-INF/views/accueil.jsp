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
<title>Accueil</title>
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
      <li class="active"><a href="#">Link</a></li>
      <li><a href="#">${proprio.nomProprietaire}</a></li>
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Deconnection <b class="caret"></b></a>
      </li>
    </ul>
    <form class="navbar-form navbar-left" role="search">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search">
      </div>
      <button type="submit" class="btn btn-default">Submit</button>
    </form>
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
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
    </div>
    <div class="col-sm-8 text-left"> 
      <div class="container" style="margin-top: 1em;">
    <!-- Sign up form -->
    <f:form modelAttribute="cite" action="savecite" method="post" enctype="multipart/form-data" class="navbar-form navbar-left">
      <table class="table">
          <tr>
             <td>Nom de la cite</td>
             <td>
                <div class="form-group">
                 <f:input path="nomCite" class="form-control"/>
                 </div>
             </td>
             <td><f:errors path="nomCite" cssClass="errors" ></f:errors> </td>
          </tr>
          <tr>
             <td>Nombre des chambre:</td>
             <td>
                <div class="form-group">
                 <f:input path="nombreChambre" class="form-control"/>
                </div>
             </td>
             <td><f:errors path="nombreChambre" cssClass="errors"></f:errors> </td>
          </tr>
          <tr>
             <td>Description de la cite:</td>
             <td>
                <div class="form-group">
                 <f:textarea path="descriptionCite" class="form-control"/>
                </div>
             </td>
             <td><f:errors path="descriptionCite"></f:errors> </td>
          </tr>
          <tr>
             <td>Photo de la cite</td>
             <td>
                 <div class="form-group">
                     <input type="file" name="file" class="form-control"/>
                </div>
             </td>
             <td></td>
          </tr>
          <tr>
             <td>Quartier</td>
             <td> 
                <div class="form-group">
                <f:select path="possition.idpossition" items="${possition}" itemValue="idpossition" itemLabel="quartier" class="form-control"></f:select>
               </div>
               </td>
             <td></td>
          </tr>
          <tr>
             <td></td>
             <td>
              <div class="form-group">
             <input type="submit" value="Save" class="form-control"/>
             </div>
             </td>
             <td> </td>
          </tr>
      </table>
      </f:form>
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