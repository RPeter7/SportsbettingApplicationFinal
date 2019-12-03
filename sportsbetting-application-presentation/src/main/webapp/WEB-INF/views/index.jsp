<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no" />
    <title>SportsBetting</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.0/css/bootstrap.min.css" integrity="sha384-SI27wrMjH3ZZ89r4o+fGIJtnzkAnFs3E4qz9DIYioCQ5l9Rd/7UAa8DHcaL8jkWt" crossorigin="anonymous">
<body>
<div>
    <div class="jumbotron">
        <h1>Welcome to SportsBet!</h1>
        <p>Sportsbetting is the activity of predicting sports results and placing a wager on the outcome.</p>
    </div>
    <div>
        <p class="h3 m-4"><a class="text-primary font-weight-bolder" href="#">Login</a> or <a class="text-primary font-weight-bolder" href="${pageContext.request.contextPath}/register/index">Register</a> to start!</p>
    </div>
</div>
<div class="container">
    <c:choose>
        <c:when test="${loginFailed}">
            <div role="alert" class="alert alert-danger text-center mx-auto" style="width: 398px;color: rgb(87,25,21);"><span><strong>Login failed. Try again!</strong><br /></span></div>
        </c:when>
    </c:choose>
    <form class="text-left mx-auto" style="width: 200px;" method="post" action="${pageContext.request.contextPath}/login/doLogin">
        <div class="border border-primary rounded-lg">
            <div class="form-group bg-primary justify-content-center form-group-special-height">
                <h4 class="text-white ml-2 p-1">Login</h4>
            </div>
            <div class="container">
                <div class="form-group"><input type="text" class="form-control" style="/*width: 123px;*/" placeholder="E-mail" name="email" /></div>
                <div class="form-group"><input type="password" class="form-control" placeholder="Password" name="password" />
                </div><button class="btn btn-primary text-left mb-2" type="submit">Login</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>