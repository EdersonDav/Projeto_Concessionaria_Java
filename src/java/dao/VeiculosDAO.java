/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.VeiculosModel;
import util.Conexao;

/**
 *
 * @author eders
 */
public class VeiculosDAO {

    public void cadastrar(VeiculosModel veiculo) throws ClassNotFoundException, SQLException {

        Connection con = Conexao.getConexao();

        String sqlComando = "insert into veiculos (marca, modelo, ano, preco, cor, placa)"
                + "values (?,?,?,?,?,?)";

        PreparedStatement comando = con.prepareStatement(sqlComando);
        comando.setString(1, veiculo.getMarca());
        comando.setString(2, veiculo.getModelo());
        comando.setInt(3, veiculo.getAno());
        comando.setDouble(4, veiculo.getPreco());
        comando.setString(5, veiculo.getCor());
        comando.setString(1, veiculo.getPlaca());

        comando.execute();

        con.close();
    }

    public List<VeiculosModel> consultarTodos(VeiculosModel veiculo) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.getConexao();
        ResultSet rsVeiculos = null;
        List<VeiculosModel> arrayVeiculos = new ArrayList<>();

        String sqlComando = ("select * from veiculos");

        PreparedStatement preparedStatement = con.prepareStatement(sqlComando);
        rsVeiculos = preparedStatement.executeQuery();

        while (rsVeiculos.next()) {
            VeiculosModel veiculos = new VeiculosModel();
            veiculos.setIdVeiculo(rsVeiculos.getInt(1));
            veiculos.setMarca(rsVeiculos.getString(2));
            veiculos.setModelo(rsVeiculos.getString(3));
            veiculos.setAno(rsVeiculos.getInt(4));
            veiculos.setPreco(rsVeiculos.getDouble(5));
            veiculos.setCor(rsVeiculos.getString(6));
            veiculos.setPlaca(rsVeiculos.getString(7));

            arrayVeiculos.add(veiculos);

        }
        preparedStatement.close();
        con.close();

        return arrayVeiculos;

    }

    public boolean alterar(VeiculosModel veiculo) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.getConexao();

        String sqlComando = "update veiculo set (marca, modelo, ano, preco, cor) ="
                + " (?, ?, ?, ?, ?) where placa = (?); ";

        PreparedStatement preparedStatement = con.prepareStatement(sqlComando);
        preparedStatement.setString(1, veiculo.getMarca());
        preparedStatement.setString(2, veiculo.getModelo());
        preparedStatement.setInt(3, veiculo.getAno());
        preparedStatement.setDouble(4, veiculo.getPreco());
        preparedStatement.setString(5, veiculo.getCor());
        preparedStatement.setString(6, veiculo.getPlaca());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        con.close();

        return true;
    }

    public boolean excluir(VeiculosModel veiculo) throws SQLException, ClassNotFoundException {
        Connection con = Conexao.getConexao();

        String sqlComando = "delete from veiculo where id = (?);";

        PreparedStatement preparedStatement = con.prepareStatement(sqlComando);
        preparedStatement.setString(1, veiculo.getPlaca());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        con.close();

        return true;

    }

}

