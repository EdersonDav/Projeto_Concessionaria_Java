<%-- 
    Author     : Grupo2
--%>

<%@page import="model.VeiculosModel"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Veiculos</h1>
        <table border="2">
            <%
                List<VeiculosModel> lista = (List<VeiculosModel>) request.getAttribute("list");

                for (VeiculosModel veiculo : lista) {
                    %><tr><%
                    %><td><%out.print(veiculo.getIdVeiculo());%></td><%
                    %><td><%out.print(veiculo.getMarca()); %></td><%
                    %><td><%out.print(veiculo.getModelo());%></td><%
                    %><td><%out.print(veiculo.getPlaca());%></td><%
                    %><td><%out.print(veiculo.getPreco());%></td><%
                    %><td><%out.print(veiculo.getCor());%></td><%
                    %><td><%out.print(veiculo.getAno());%></td><%
                    %></tr><%  }
            %>
    </table>
</body>
</html>
