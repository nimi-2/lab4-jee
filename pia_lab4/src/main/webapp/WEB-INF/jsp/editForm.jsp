<%-- 
    Document   : editForm
    Created on : 8 pa? 2024, 14:48:09
    Author     : Emilia
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
    <head>
        <title>Edytuj Pracownika</title>
    </head>

    <h1>Edytuj Pracownika</h1>
    <form:form method="post" action="${pageContext.request.contextPath}/editsave" modelAttribute="pracownik">
        <form:hidden path="id" />
        <label for="nazwisko">Nazwisko:</label>
        <form:input path="nazwisko" id="nazwisko" />
        <br />
        <label for="pensja">Pensja:</label>
        <form:input path="pensja" id="pensja" />
        <br />
        <label for="firma">Firma:</label>
        <form:input path="firma" id="firma" />
        <br />
        <input type="submit" value="Zapisz" />
    </form:form>
    <a href="/viewAll">Powrót do listy</a>

</html>

