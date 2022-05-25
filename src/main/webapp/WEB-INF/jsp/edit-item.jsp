<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<script src="../js/index.js"></script>
<style>
    <%@include file="/WEB-INF/css/login.css" %>
</style>
<div class="container" style="padding-left: 25%; padding-right: 25%; margin-top: 1%">

    <div class="section-title">
        <span>Edit item</span>
        <h2>Edit item</h2>
    </div>

    <form:form method="post" action="/edit-item" modelAttribute="item">


        <div class="form-outline mb-4">
            <form:label cssClass="form-label" path="id">Item id</form:label>
            <form:input value="0" cssClass="form-control" type="text" path="id" required="required"/>
        </div>
        <div class="form-outline mb-4">
            <form:label cssClass="form-label" path="name">Item name</form:label>
            <form:input cssClass="form-control" type="text" path="name" required="required"/>
        </div>
        <div class="form-outline mb-4">
            <form:label cssClass="form-label" path="imgUrl">Item url</form:label>
            <form:input cssClass="form-control" path="imgUrl" required="required"/>
        </div>
        <div class="form-outline mb-4">
            <form:label cssClass="form-label" path="price">Price</form:label>
            <form:input cssClass="form-control" path="price" required="required"/>
        </div>
        <button type="submit" class="btn btn-primary btn-block mb-4">Edit item</button>
    </form:form>
</div>
<%@ include file="common/footer.jspf" %>