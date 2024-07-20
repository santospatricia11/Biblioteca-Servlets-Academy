package controller;


import controller.util.ManipulacaoData;
import dao.UsuarioDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import service.UserAuthenticator;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@WebServlet({"/usuario","/login","/cadastro","/listAllUsers","/index"})
public class UsuarioController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UsuarioDao usuarioDao;

    public UsuarioController() {
        super();
    }

    public void init() {
        usuarioDao = new UsuarioDao();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processarRequisicao(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processarRequisicao(request, response);
    }

    private void processarRequisicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");
        System.out.println("Ação recebida: " + acao); // Log para depuração
        if (acao == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Ação não especificada.");
            return;
        }

        try {
            switch (acao) {
                case "novo":
                    novoUsuario(request, response);
                    break;
                case "inserir":
                    gravarUsuario(request, response);
                    break;
                default:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Ação desconhecida.");
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private void novoUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void gravarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String password = request.getParameter("password");


        Usuario usuario = new Usuario(nome, email, password);

        Usuario usuarioGravado = usuarioDao.inserirUsuario(usuario);

        RequestDispatcher dispatcher = request.getRequestDispatcher("castastro.jsp");
        request.setAttribute("mensagem", "Usuário cadastrado com sucesso");
        dispatcher.forward(request, response);
    }


}





