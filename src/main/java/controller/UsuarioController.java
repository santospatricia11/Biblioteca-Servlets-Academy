package controller;

import dao.UsuarioDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Usuario;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@WebServlet("/usuario")
public class UsuarioController extends HttpServlet {


    private UsuarioDao usuarioDao;

    @Override
    public void init() throws ServletException {
        super.init();
        usuarioDao = new UsuarioDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getPathInfo();
        if (action == null) {
            action = "/";
        }

        switch (action) {
            case "/":
                listarUsuarios(request, response);
                break;
            case "/editar":
                mostrarFormularioEditar(request, response);
                break;
            case "/excluir":
                excluirUsuario(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getPathInfo();
        if (action == null) {
            action = "/";
        }

        switch (action) {
            case "/":
                adicionarUsuario(request, response);
                break;
            case "/editar":
                atualizarUsuario(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void adicionarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        Usuario usuario = new Usuario(nome, email, senha, null);
        usuarioDao.addUsuario(usuario);

        response.sendRedirect(request.getContextPath() + "/usuario/");
    }

    private void atualizarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        Optional<Usuario> usuarioOpt = usuarioDao.getUsuarioById(id);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setPassword(senha);

            usuarioDao.updateUsuario(usuario);
        }

        response.sendRedirect(request.getContextPath() + "/usuario/");
    }

    private void excluirUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        usuarioDao.deleteUsuario(id);

        response.sendRedirect(request.getContextPath() + "/usuario/");
    }

    private void listarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Usuario> usuarios = usuarioDao.getAllUsuarios();

        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("/listagem-usuarios.jsp").forward(request, response);
    }

    private void mostrarFormularioEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        // Obtenha o usuário do UsuarioDao com base no ID
        Optional<Usuario> usuarioOpt = usuarioDao.getUsuarioById(id);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();

            // Defina o usuário como atributo no request
            request.setAttribute("usuario", usuario);

            // Encaminhe para a página JSP de formulário de edição de usuário
            request.getRequestDispatcher("/formulario-editar-usuario.jsp").forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        usuarioDao.close();
    }

        }
