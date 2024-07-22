package controller;

import dao.LivroDao;
import dao.UsuarioDao;
import jakarta.servlet.RequestDispatcher;
import model.Livro;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;

@WebServlet({"/livros", "/livros/new", "/livros/edit", "/livros/", "/livro/update", "/livro/delete", "/livro/list"})

public class LivroController extends HttpServlet {

        private static final long serialVersionUID = 1L;

        private LivroDao livroDao;

        public LivroController() {
            super();
        }

        public void init() {
            livroDao = new LivroDao();
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
                        novoLivro(request, response);
                        break;
                    case "inserir":
                        gravarLivro(request, response);
                        break;
                    default:
                        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Ação desconhecida.");
                        break;
                }
            } catch (Exception ex) {
                throw new ServletException(ex);
            }
        }

        private void novoLivro(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            RequestDispatcher dispatcher = request.getRequestDispatcher("livros.jsp");
            dispatcher.forward(request, response);
        }

    private void gravarLivro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        String ISBN = request.getParameter("ISBN");
        String nome_livro = request.getParameter("nome_livro");
        String categoria = request.getParameter("categoria");
        String descricao = request.getParameter("descricao");

        // Verifica se o parâmetro 'quantidade' não é nulo e é um número válido
        String quantidadeParam = request.getParameter("quantidade");
        int quantidade = 0; // Valor padrão
        if (quantidadeParam != null && !quantidadeParam.isEmpty()) {
            try {
                quantidade = Integer.parseInt(quantidadeParam);
            } catch (NumberFormatException e) {
                // Log de erro ou tratamento apropriado
                throw new ServletException("Quantidade inválida", e);
            }
        }

        String capa = request.getParameter("capa");

        Livro livro = new Livro(ISBN, nome_livro, categoria, descricao, quantidade, capa);

        Livro livroGravado = livroDao.inserirLivro(livro);

        RequestDispatcher dispatcher = request.getRequestDispatcher("livros.jsp");
        request.setAttribute("mensagem", "Livro cadastrado com sucesso");
        dispatcher.forward(request, response);
    }


}




