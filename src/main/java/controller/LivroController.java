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

@WebServlet(name = "LivroController", urlPatterns = {"/index", "/livros/new", "/livros/insert","/livros/delete","/views/list-books.jsp"})
public class LivroController extends HttpServlet {

    private LivroDao livroDao;

    @Override
    public void init() throws ServletException {
        livroDao = new LivroDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/livros/new":
                showNewForm(request, response);
                break;
            case "/livros/insert":
                insertBook(request, response);
                break;
            case "/livros/delete":
                deleteBook(request, response);
                break;
            case "/livros/edit":
                showEditForm(request, response);
                break;
            case "/livros/update":
                updateBook(request, response);
                break;
            default:
                listBooks(request, response);
                break;
        }
    }

    private void listBooks(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Livro> livros = livroDao.listarLivros();
        request.setAttribute("listLivro", livros);
        request.getRequestDispatcher("/views/list-books.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("livro", new Livro());
        request.getRequestDispatcher("/views/add-book.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String isbn = request.getParameter("isbn");
        Livro existingBook = livroDao.buscarLivroPorISBN(isbn);
        request.setAttribute("livro", existingBook);
        request.getRequestDispatcher("/views/edit-book.jsp").forward(request, response);
    }

    private void insertBook(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String isbn = request.getParameter("isbn");
        String nomeLivro = request.getParameter("nomeLivro");
        String categoria = request.getParameter("categoria");
        String descricao = request.getParameter("descricao");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        String diretorioImagem = request.getParameter("diretorioImagem");

        Livro newBook = new Livro(isbn, nomeLivro, categoria, descricao, quantidade, diretorioImagem);
        livroDao.salvarLivro(newBook);
        response.sendRedirect("livros");
    }

    private void updateBook(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String isbn = request.getParameter("isbn");
        String nomeLivro = request.getParameter("nomeLivro");
        String categoria = request.getParameter("categoria");
        String descricao = request.getParameter("descricao");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        String diretorioImagem = request.getParameter("diretorioImagem");

        Livro book = new Livro(isbn, nomeLivro, categoria, descricao, quantidade, diretorioImagem);
        livroDao.atualizarLivro(book);
        response.sendRedirect("livros");
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String isbn = request.getParameter("isbn");
        livroDao.deletarLivro(isbn);
        response.sendRedirect("livros");
    }

    @Override
    public void destroy() {
        livroDao.fecharConexao();
    }
}




