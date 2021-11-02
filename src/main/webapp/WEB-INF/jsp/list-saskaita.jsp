<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
   <H1>List of saskaita:</H1>
   <!--<p>${telNrList}</p>-->
   <table border="1">
      <caption>saskaita</caption>
      <thead>
         <tr>
            <th>id</th>
            <th>telNr</th>
            <th>menuo</th>
            <th>suma</th>
            <th>telNr</th>
            <th>Update</th>
            <th>Delete</th>
         </tr>
      </thead>
      <tbody>
         <c:forEach items="${saskaitaList}" var="saskaita">
            <tr>
               <td>${saskaita.id}</td>
               <td>${saskaita.telNr}</td>
               <td>${saskaita.menuo}</td>
               <td>${saskaita.suma}</td>
               <td>${saskaita.telNr}</td>
               <td><a type="button" href="/update-saskaita/${saskaita.id}">UPDATE</a></td>
               <td><a type="button" href="/delete-saskaita/${saskaita.id}">DELETE</a></td>
            </tr>
         </c:forEach>
      </tbody>
   </table>
   <div>
      <a href="/add-saskaita">ADD saskaita</a>
   </div>
</div>
<%@ include file="common/footer.jspf"%>