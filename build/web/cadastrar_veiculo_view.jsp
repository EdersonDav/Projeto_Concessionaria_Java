<%-- 
    Author     : Grupo2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            div{
                margin-bottom: 20px
            }
        </style>
    </head>
    <body>
    <center>
        <h1>Cocessionaria de Veiculos</h1>
        <form action="VeiculosController" method="post">
            <div>Marca: <input type="text" name="txtmarca"> </div>

            <div>Modelo: <input type="text" name="txtmodelo"> </div>

            <div>Ano: <input type="number" name="numano"> </div>

            <div>Preço: <input type="number"  name="numpreco"></div>

            <div>Cor: <input type="text"  name="txtcor"></div>

            <div>Placa: <input type="text" name="txtplaca" maxlength="7" required ></div>
            
            <input type="submit" value="Cadastrar" name="btnoperacao">
            <input type="submit" value="Listar" name="btnoperacao">
            <input type="submit" value="Deletar" name="btnoperacao">
            <input type="submit" value="Editar" name="btnoperacao">
            <p>Para deletar preencher apenas a placa</p>
            <p>Para editar preencher todos os dados do veiculo e a placa do veiculo que será editado</p>
        </form>
    </center>
</body>
</html>
