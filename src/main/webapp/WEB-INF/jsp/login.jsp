<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<head>
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,400;0,500;0,600;0,700;0,800;0,900;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<style>
    <%@include file="/WEB-INF/css/login.css" %>
</style>
<div class="container" style="width: 25%; margin-top: 1%">
    <form:form method="post" action="/login" modelAttribute="user">
        <div class="form-outline mb-4">
            <form:label cssClass="form-label" path="username">Username</form:label>
            <form:input cssClass="form-control" path="username" required="required"/>
        </div>

        <div class="form-outline mb-4">
            <form:label cssClass="form-label" path="username">Password</form:label>
            <form:input type="password" cssClass="form-control" path="password" required="required"/>
        </div>

        <!-- 2 column grid layout for inline styling -->
        <div class="row mb-4">
            <div class="col d-flex justify-content-center">
                <!-- Checkbox -->
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="form2Example31" checked/>
                    <label class="form-check-label" for="form2Example31"> Remember me </label>
                </div>
            </div>
        </div>

        <!-- Submit button -->
        <button type="submit" class="btn btn-primary btn-block mb-4">Sign in</button>

        <!-- Register buttons -->
        <div class="text-center">
            <p>Not a member? <a href="/signup" style="color: #D7B5A9">Register</a></p>
        </div>
    </form:form>
</div>