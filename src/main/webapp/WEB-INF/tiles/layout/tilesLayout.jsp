<%--
  Created by IntelliJ IDEA.
  User: passo
  Date: 2022-08-24
  Time: 오후 3:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
</head>
<body>
<header>
    <tiles:insertAttribute name="header"/>
</header>
<tiles:insertAttribute name="body"/>
<footer>
    <tiles:insertAttribute name="footer"/>
</footer>
</body>
</html>
