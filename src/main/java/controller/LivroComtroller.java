package controller;

import dao.LivroDao;
import model.Livro;

import java.io.IOException;
import java.util.List;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



import java.io.IOException;
import java.util.List;

@WebServlet(name="livroServlet", urlPatterns = {"/LivroComtroller"})
public class LivroComtroller  extends HttpServlet {

    private LivroDao livroDao;

    @Override
    public void init() throws ServletException {
        super.init();
        livroDao = new LivroDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            listarLivros(request, response);
        } else {
            String ISBN = pathInfo.substring(1);
            buscarLivroPorISBN(ISBN, request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ISBN = request.getParameter("ISBN");
        String nomeLivro = request.getParameter("nomeLivro");
        String categoria = request.getParameter("categoria");
        String descricao = request.getParameter("descricao");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        String diretorioImagem = request.getParameter("diretorioImagem");

        Livro livro = new Livro(ISBN, nomeLivro, categoria, descricao, quantidade, diretorioImagem);
        livroDao.salvarLivro(livro);

        response.sendRedirect(request.getContextPath() + "/livros");
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ISBN = request.getParameter("ISBN");
        String nomeLivro = request.getParameter("nomeLivro");
        String categoria = request.getParameter("categoria");
        String descricao = request.getParameter("descricao");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        String diretorioImagem = request.getParameter("diretorioImagem");

        Livro livro = new Livro(ISBN, nomeLivro, categoria, descricao, quantidade, diretorioImagem);
        livroDao.atualizarLivro(livro);

        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ISBN = request.getParameter("ISBN");
        livroDao.deletarLivro(ISBN);

        response.setStatus(HttpServletResponse.SC_OK);
    }

    private void listarLivros(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Livro> livros = livroDao.listarLivros();
        request.setAttribute("livros", livros);
        request.getRequestDispatcher("/listarLivros.jsp").forward(request, response);
    }

    private void buscarLivroPorISBN(String ISBN, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Livro livro = livroDao.buscarLivroPorISBN(ISBN);
        request.setAttribute("livro", livro);
        request.getRequestDispatcher("/detalhesLivro.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
        super.destroy();
        livroDao.fecharConexao();
    }
}




