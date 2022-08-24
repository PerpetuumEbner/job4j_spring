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
<div class="container pt-3">
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Нарушение</th>
            <th scope="col">Описание</th>
            <th scope="col">Тип транспорта</th>
            <th scope="col">Статья</th>
            <th scope="col">Адрес</th>
        </tr>
        </thead>
        <c:forEach var="accident" items="${accidents}">
            <tr>
                <td>${accident.id}</td>
                <td>
                    <a href="<c:url value='/edit?id=${accident.id}'/>" class="global">${accident.name}</a>
                </td>
                <td>${accident.text}</td>
                <td>${accident.type.name}</td>
                <td>
                    <c:forEach var="type" items="${accident.getRules()}">
                        <option>${type.name}</option>
                    </c:forEach></td>
                <td>${accident.address}</td>
            </tr>
        </c:forEach>
    </table>
    <a class="btn btn-outline-primary" href="<c:url value='/create'/>" role="button">Добавить</a>
</div>
</body>
</html>