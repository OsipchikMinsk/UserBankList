
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserBankAccount </title>

</head>
<body>
<form method="get" action="http://localhost:8080/user">
    <input type="text" name="richestUser" value="${richestUser.name} ${richestUser.sureName}" disabled="true">
    <input type="submit" value="Get the reachest user"/>
</form>
<form method="get" action="http://localhost:8080/account">
    <input type="text" name="sum" value="${sum}" disabled="true">
    <input type="submit" value="Get sum of account"/>
</form>


</body>
</html>
