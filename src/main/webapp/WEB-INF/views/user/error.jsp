<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Error</title>
</head>

<body>
    <h1>Warning! Error!</h1>
    <div>
        <c:out value="${errorMessage}" />
        <br>
    </div>
    <a href='<c:url value="/user/listUsers"/>'>Back</a>
</body>
</html>