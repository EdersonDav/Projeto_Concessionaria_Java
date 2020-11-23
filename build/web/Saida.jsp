<%-- 
     Author     : Grupo2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String mensagem = (String)request.getAttribute("mensagem");
        %>
        <h1><% out.println(mensagem);%></h1>
    </body>
</html>
