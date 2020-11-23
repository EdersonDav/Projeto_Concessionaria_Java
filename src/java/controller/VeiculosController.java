/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.VeiculosDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.VeiculosModel;

/**
 *
 * @author eders
 */
@WebServlet(name = "VeiculosController", urlPatterns = {"/VeiculosController"})
public class VeiculosController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String mensagem = "";
        try {
            VeiculosModel veiculos = new VeiculosModel();
            String operacao = request.getParameter("btnoperacao");

            if (operacao.equals("Cadastrar")) {
                veiculos.setMarca(request.getParameter("txtmarca"));
                veiculos.setModelo(request.getParameter("txtmodelo"));
                veiculos.setCor(request.getParameter("txtcor"));
                veiculos.setPlaca(request.getParameter("txtplaca"));
                veiculos.setAno(Integer.parseInt(request.getParameter("numano")));
                veiculos.setPreco(Double.parseDouble(request.getParameter("numpreco")));
                mensagem = "Veiculo cadastrado com sucesso";

                VeiculosDAO veiculosDAO = new VeiculosDAO();
                veiculosDAO.cadastrar(veiculos);

            } else if (operacao.equals("Listar")) {

                VeiculosDAO veiculosDAO = new VeiculosDAO();
                List<VeiculosModel> lveiculos = veiculosDAO.consultarTodos(veiculos);

                request.setAttribute("list", lveiculos);

                request.getRequestDispatcher("/Lista.jsp").forward(request, response);
                
            } else if (operacao.equals("Editar")) {
                veiculos.setMarca(request.getParameter("txtmarca"));
                veiculos.setModelo(request.getParameter("txtmodelo"));
                veiculos.setCor(request.getParameter("txtcor"));
                veiculos.setPlaca(request.getParameter("txtplaca"));
                veiculos.setAno(Integer.parseInt(request.getParameter("numano")));
                veiculos.setPreco(Double.parseDouble(request.getParameter("numpreco")));
                mensagem = "Veiculo alterado com sucesso";

                VeiculosDAO veiculosDAO = new VeiculosDAO();
                veiculosDAO.alterar(veiculos);
            } else if (operacao.equals("Deletar")) {
                veiculos.setPlaca(request.getParameter("txtplaca"));
                mensagem = "Veiculo excluido com sucesso";

                VeiculosDAO veiculosDAO = new VeiculosDAO();
                veiculosDAO.excluir(veiculos);
            }
        } catch (ClassNotFoundException | NumberFormatException | SQLException ex) {
            mensagem = "Erro: " + ex;
        }

        request.setAttribute("mensagem", mensagem);

        request.getRequestDispatcher("/Saida.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
