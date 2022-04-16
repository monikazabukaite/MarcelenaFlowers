<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
        <p>Add new telnr:</p>
    <form:form method="post" modelAttribute="telnr">
        <form:input path="id" type="hidden" required="required" />
        <form:errors path="id" />

        <form:label path="telNr">telNr</form:label>
        <form:input path="telNr" required="required" />
        <form:errors path="telNr" />

        <form:label path="userId">userId</form:label>
        <form:input path="userId" type="text" required="required" />
        <form:errors path="userId" />

        <button type="submit">OK</button>
    </form:form>
</div>
<%@ include file="common/footer.jspf"%>