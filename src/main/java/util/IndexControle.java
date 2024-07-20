package util;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDao;
import model.Usuario;


/**
 * Servlet implementation class IndexControle
 */
@WebServlet("/publica")
public class IndexControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UsuarioDao usuarioDao;

	public IndexControle() {
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
		try {
			switch (acao) {
			case "novo":
				novoUsuario(request, response);
				break;
			case "inserir":
				gravarUsuario(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
		
	}
	
	private void novoUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("publica/publica-novo-usuario.jsp");
		dispatcher.forward(request, response);
	}
	
	private void gravarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {		
		
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String login = request.getParameter("login");		
		String data = request.getParameter("nascimento");
		

		
		Usuario usuario = new Usuario(nome, email, password);
		
		Usuario usuarioGravado = usuarioDao.inserirUsuario(usuario);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("publica/publica-novo-usuario.jsp");
		request.setAttribute("mensagem", "Usuário cadastrado com sucesso");
		dispatcher.forward(request, response);
	}

}
