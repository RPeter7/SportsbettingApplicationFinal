<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no" />
    <title>SportsBetting</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.0/css/bootstrap.min.css" integrity="sha384-SI27wrMjH3ZZ89r4o+fGIJtnzkAnFs3E4qz9DIYioCQ5l9Rd/7UAa8DHcaL8jkWt" crossorigin="anonymous">
</head>

<body>
<nav class="navbar navbar-light navbar-expand-md navbar navbar-dark bg-dark">
    <div class="container-fluid"><a class="navbar-brand" href="#">SportsBetting</a><button data-toggle="collapse" data-target="#navcol-1" class="navbar-toggler"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse"
             id="navcol-1">
            <ul class="nav navbar-nav">
                <li role="presentation" class="nav-item"><a class="nav-link" href="/home">Home</a></li>
                <li role="presentation" class="nav-item"><a class="nav-link active" href="/event">Events</a></li>
                <li role="presentation" class="nav-item"></li>
            </ul>
        </div>
        <form class="form-inline my-2 my-lg-0" method="get" action="/home/logout">
            <button class="btn btn-dark border-white my-2 my-sm-0" type="submit">Logout</button>
        </form>
    </div>
</nav>
<div class="container m-3 mx-auto">
    <form class="text-left mx-auto">
        <div class="border border-primary rounded-lg">
            <div class="bg-primary">
                <h4 class="text-white p-2">Events</h4>
            </div>
            <div class="table-responsive">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th>Event title</th>
                        <th>Event Type</th>
                        <th>Bet Type</th>
                        <th>Outcome value</th>
                        <th>Outcome odd</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${events}" var="event">
                        <tr>
                            <td class="font-weight-bolder">${event.id}</td>
                            <td>${event.eventTitle}</td>
                            <td>${event.eventType}</td>
                            <td>${event.betType}</td>
                            <td>${event.outComeOdd}</td>
                            <td>${event.outComeValue}</td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
    </form>
</div>
<div class="container">
    <c:choose>
        <c:when test="${eventAddFailed}">
            <div role="alert" class="alert alert-danger text-center mx-auto" style="width: 398px;color: rgb(87,25,21);"><span><strong>${failedMessage}</strong><br /></span></div>
        </c:when>
    </c:choose>
    <form class="text-left mx-auto" style="width: 300px;" method="post" action="/event/addEvent">
        <div class="border border-primary rounded-lg">
            <div class="form-group bg-primary justify-content-center form-group-special-height">
                <h4 class="text-white ml-2 p-1">Choose Event</h4>
            </div>
            <div class="container">
                <div class="form-group"><input type="number" class="form-control" style="/*width: 123px;*/" placeholder="Number of Event" name="numberOfEvent" /></div>
                <div class="form-group"><input type="number" class="form-control" placeholder="Wager amount" name="wagerAmount" /></div>
                <button class="btn btn-primary text-left mb-2" type="submit">Add Event</button></div>
        </div>
    </form>
</div>
</body>

</html>