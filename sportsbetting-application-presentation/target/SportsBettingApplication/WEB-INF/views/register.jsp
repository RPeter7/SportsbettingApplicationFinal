<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no" />
    <title>SportsBetting - Register</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.0/css/bootstrap.min.css" integrity="sha384-SI27wrMjH3ZZ89r4o+fGIJtnzkAnFs3E4qz9DIYioCQ5l9Rd/7UAa8DHcaL8jkWt" crossorigin="anonymous">
</head>

<body>
    <div class="jumbotron">
        <h1>Register to SportsBet!</h1>
        <p>Before you start to place wages on outcomes you have to register!</p>
    </div>
    <div class="container">
        <form class="text-center mx-auto" style="width: 300px;" method="post" action="${pageContext.request.contextPath}/register/newPlayer" >
            <div class="border border-primary rounded-lg">
                <div class="form-group bg-primary justify-content-center form-group-special-height">
                    <h4 class="text-white ml-2 p-1">Register</h4>
                </div>
                <div class="container">
                    <div class="form-group"><input type="text" class="form-control" style="/*width: 123px;*/" placeholder="Name" name="name" /></div>
                    <div class="form-group"><input type="text" class="form-control" style="/*width: 123px;*/" placeholder="Date of Birth" name="dateOfBirth" /></div>
                    <div class="form-group"><input type="text" class="form-control" style="/*width: 123px;*/" placeholder="Email" name="email"  /></div>
                    <div class="form-group"><input type="password" class="form-control" placeholder="Password" name="password" />
                    </div><button class="btn btn-primary text-left mb-2" type="submit">Register</button></div>
            </div>
        </form>
    </div>
</body>

</html>