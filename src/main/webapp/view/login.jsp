<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>TODO list</title>
    <link href="../lib/bower/bootstrap-css-only/css/bootstrap.css" rel="stylesheet">
    <link href="../css/signin.css" rel="stylesheet">
</head>

<body>
<form id="loginForm" class="form-signin" action="<c:url value='loginProcess' />" method="POST">
    <h2 class="form-signin-heading">Please sign in</h2>
    Username:<br>
    <input type="text" class="form-control" name="username" value=""/><br>
    Password:<br>
    <input type="password" class="form-control" name="password" value=""/>

    <input value="Sign in" class="btn btn-lg btn-primary btn-block" name="submit" type="submit"/>

    <c:if test="${not empty errorMessage}">
        <div style="color:#FF0000">Username or password is not valid</div>
    </c:if>
</form>
</body>
</html>