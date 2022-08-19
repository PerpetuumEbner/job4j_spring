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
<div class="container-md pt-3">
    <div class="card">
        <div class="card-header">
            Добавить правонарушение
        </div>
        <div class="card-body">
            <form action="<c:url value='/save'/>" method='POST'>
                <div class="form-group">
                    <label for="name">Название</label>
                    <input type="text" class="form-control" name="name" id="name">
                </div>
                <div class="form-group pt-3">
                    <label for="text">Описание</label>
                    <textarea class="form-control" name="text" id="text"></textarea>
                </div>
                <div class="form-group pt-3">
                    <label for="type">Тип транспорта</label>
                    <select class="form-select" id="typeId" name="typeId">
                        <option selected>Выберите тип</option>
                        <c:forEach var="type" items="${types}">
                            <option value="${typeId}">${type.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group pt-3">
                    <label for="address">Адрес</label>
                    <input type="text" class="form-control" name="address" id="address">
                </div>
                <div class="form-group pt-3">
                    <button type="submit" class="btn btn-outline-primary ">Создать</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>