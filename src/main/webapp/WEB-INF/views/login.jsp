<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
            crossorigin="anonymous"></script>
    <title>Accident - правонарушения</title>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light mb-4">
        <a class="nav-item nav-link">
            <div>
                Login as : ${user.username}
            </div>
        </a>
    </nav>
    <div class="mx-auto my-3" style="width: 900px;">
        <div class="card" style="width: 100%">
            <div class="card-header">
                Авторизация
            </div>
            <div class="card-body">
                <c:if test="${not empty errorMessage}">
                    <div style="color:red; font-weight: bold; margin: 30px 0px;">
                            ${errorMessage}
                    </div>
                </c:if>
                <form name='login' action="<c:url value='/login'/>" method='POST'>
                    <div class="form-group pb-3">
                        <label for="name">Имя</label>
                        <input type="name" class="form-control" name="name" id="name">
                    </div>
                    <div class="form-group pb-3">
                        <label for="password">Пароль</label>
                        <input type="password" class="form-control" name="password" id="password">
                    </div>
                    <button type="submit" class="btn btn-outline-primary">Войти</button>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>