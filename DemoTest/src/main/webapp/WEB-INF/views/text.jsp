<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestiondes eleves</title>
 <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
</head>
<body>
   <div>
     <table class="table">
      <f:form modelAttribute="eleve" action="saveeleve" method="post">
         <tr>
            <td>Matricule de l'élève :</td>
            <td><f:input path="matricule"/></td>
            <td><f:errors path="matricule"></f:errors></td>
         </tr>
         <tr>
             <td>Nom :</td>
             <td><f:input path="nom"/></td>
             <td><f:errors path="nom"></f:errors></td>
         </tr>
         <tr>
             <td>Prenom :</td>
             <td><f:input path="prenom"/></td>
             <td><f:errors path="prenom"></f:errors></td>
         </tr>
         <tr>
             <td>Sexe :</td>
             <td><f:input path="sexe"/></td>
             <td><f:errors path="sexe"></f:errors></td>
         </tr>
         <tr>
            <td><input type="submit" value="Save"></td>
         </tr>
      </f:form>
     </table>
   </div>
   
   <div>
        <table class="table table-striped">
           <tr>
             <td>MATRICULE</td><td>NOM</td><td>PRENOM</td><td>SEXE</td>
           </tr>
           <c:forEach items="${ListeEleve}" var="eleve" >
              <tr>
                 <td>${eleve.matricule}</td>
                 <td>${eleve.nom}</td>
                 <td>${eleve.prenom}</td>
                 <td>${eleve.sexe}</td>
              </tr>
           </c:forEach>
        </table>
   </div>
</body>
</html>