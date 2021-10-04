<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${requestScope.title}</title>
    <meta name="description" content="${requestScope.description}"  />
</head>
<body>

<jsp:include page="./components/navbar.jsp" flush="true"/>

<main role="main">
    <jsp:include page="${requestScope.content}" flush="true"/>
</main>

</body>
</html>
