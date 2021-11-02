<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
        <p>Add new saskaita:</p>
    <form:form method="post" modelAttribute="saskaita">
        <form:input path="id" type="hidden" required="required" />
        <form:errors path="id" />

        <form:label path="telNrId">telNrId</form:label>
        <form:input path="telNrId" type="text" required="required" />
        <form:errors path="telNrId" />

        <form:label path="menuo">menuo</form:label>
        <form:input path="menuo" type="text" required="required" />
        <form:errors path="menuo" />

        <form:label path="suma">suma</form:label>
        <form:input path="suma" type="number" required="required" />
        <form:errors path="suma" />

        <button type="submit">OK</button>
    </form:form>
</div>
<%@ include file="common/footer.jspf"%>