<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<head>
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,400;0,500;0,600;0,700;0,800;0,900;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<style>
    <%@include file="/WEB-INF/css/login.css" %>
</style>
<div class="container" style="width: 25%; margin-top: 1%">
    <form>
        <!-- Email input -->
        <div class="form-outline mb-4">
            <label class="form-label" for="form2Example1">Username</label>
            <input type="text" id="form2Example1" class="form-control" />
        </div>

        <div class="form-outline mb-4">
            <label class="form-label" for="form2Example2">Email</label>
            <input type="email" id="form2Example2" class="form-control" />
        </div>

        <!-- Password input -->
        <div class="form-outline mb-4">
            <label class="form-label" for="form2Example3">Password</label>
            <input type="password" id="form2Example3" class="form-control" />
        </div>

        <!-- Submit button -->
        <button type="button" class="btn btn-primary btn-block mb-4">Sign up</button>
    </form>
</div>