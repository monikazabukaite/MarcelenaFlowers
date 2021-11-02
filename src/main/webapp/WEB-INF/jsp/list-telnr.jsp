<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
   <H1>List of TelNr:</H1>
   <!--<p>${telNrList}</p>-->
   <table border="1">
      <caption>TelNr</caption>
      <thead>
         <tr>
            <th>Kodas</th>
            <th>telNr</th>
            <th>userId</th>
            <th>Update</th>
            <th>Delete</th>
         </tr>
      </thead>
      <tbody>
         <c:forEach items="${telNrList}" var="telNr">
            <tr>
               <td>${telNr.id}</td>
               <td>${telNr.telNr}</td>
               <td>${telNr.userId}</td>
               <td><a type="button" href="/update-telnr/${telNr.id}">UPDATE</a></td>
               <td><a type="button" href="/delete-telnr/${telNr.id}">DELETE</a></td>
            </tr>
         </c:forEach>
      </tbody>
   </table>
   <div>
      <a href="/add-telnr">ADD TelNr</a>
   </div>
</div>
<%@ include file="common/footer.jspf"%>