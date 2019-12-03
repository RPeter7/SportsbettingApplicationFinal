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
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
</head>

<body>
<nav class="navbar navbar-light navbar-expand-md navbar navbar-dark bg-dark">
    <div class="container-fluid"><a class="navbar-brand" href="#">SportsBetting</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse"
             id="navcol-1">
            <ul class="nav navbar-nav">
                <li class="nav-item" role="presentation"><a class="nav-link active" href="#">Home</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="/event">Events</a></li>
            </ul>
        </div>
        <form class="form-inline my-2 my-lg-0" method="get" action="/home/logout">
            <button class="btn btn-dark border-white my-2 my-sm-0" type="submit">Logout</button>
        </form>
    </div>
</nav>
<div class="container m-3 mx-auto">
    <form class="text-left mx-auto" method="post" action="/home/updatePlayer">
        <div class="border border-primary rounded-lg">
            <div class="form-group bg-primary justify-content-center form-group-special-height">
                <h4 class="text-left text-white ml-2 p-1">Account details</h4>
            </div>
            <div class="container">
                <div class="form-group">
                    <input class="form-control" type="hidden" name="id" value="${currentPlayer.id}" />
                </div>
                <div class="form-group">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend"><span class="input-group-text">Name</span></div><input class="form-control" type="text" name="name" value="${currentPlayer.name}" /></div>
                </div>
                <div class="form-group">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend"><span class="input-group-text">Email</span></div><input class="form-control" type="text" name="email" value="${currentPlayer.email}" /></div>
                </div>
                <div class="form-group">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend"><span class="input-group-text">Account Number</span></div><input class="form-control" type="text" name="accountNumber" value="${currentPlayer.accountNumber}" /></div>
                </div>
                <div class="form-group">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend"><span class="input-group-text">Currency</span></div><input class="form-control" type="text" name="currency" value="${currentPlayer.currency}" /></div>
                </div>
                <div class="form-group">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend"><span  class="input-group-text">Balance</span></div><input class="form-control" type="number" name="balance" value="${currentPlayer.balance}" /></div>
                </div><button class="btn btn-primary text-left mb-2" type="submit">Save</button></div>
        </div>
    </form>
</div>
<div class="container m-3 mx-auto">
    <form class="text-left mx-auto">
        <div class="border border-primary rounded-lg">
            <div class="bg-primary">
                <h4 class="text-white p-2">Wagers</h4>
            </div>
            <div class="table-responsive">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col"></th>
                        <th scope="col">#</th>
                        <th>Event title</th>
                        <th>Event Type</th>
                        <th>Bet Type</th>
                        <th>Outcome value</th>
                        <th>Outcome odd</th>
                        <th>Wager amount</th>
                        <th>Winner</th>
                        <th>Processed</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${wagers}" var="wager">
                        <tr>
                            <td>
                                <form action="${pageContext.request.contextPath}/home/delete" method="post">
                                    <input type="hidden" value="${wager.id}" id="id" name="id">
                                    <c:choose>
                                        <c:when test="${!wager.processed}">
                                            <button class="btn btn-primary" type="submit">Remove</button>
                                        </c:when>
                                    </c:choose>
                                </form>
                            </td>
                            <td class="font-weight-bolder">${wager.id}</td>
                            <td>${wager.eventTitle}</td>
                            <td>${wager.eventType}</td>
                            <td>${wager.betType}</td>
                            <td>${wager.outComeValue}</td>
                            <td>${wager.outComeOdd}</td>
                            <td>${wager.wagerAmount}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${wager.processed}">
                                        <c:choose>
                                            <c:when test="${wager.winner}">
                                                Yes
                                            </c:when>
                                            <c:otherwise>
                                                No
                                            </c:otherwise>
                                        </c:choose>
                                    </c:when>
                                    <c:otherwise>
                                        -
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${wager.processed}">
                                        Yes
                                    </c:when>
                                    <c:otherwise>
                                        -
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
    </form>
</div>
</body>

</html>