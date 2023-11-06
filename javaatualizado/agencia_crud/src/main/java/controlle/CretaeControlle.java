package controlle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import database.Conexao;
import modelo.Cliente;


@WebServlet("/CretaeControlle")
public class CretaeControlle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cliente = new Cliente();
		cliente.setNome(request.getParameter("nome"));
		cliente.setTelefone(request.getParameter("telefone"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setMetododePagamento(request.getParameter("metododePagamento"));

	try {
		Connection conexao = Conexao.createConnection();
		ClienteDAO clienteDAO = new ClienteDAO(conexao);
		clienteDAO.cadastrarCliente(cliente);
		response.sendRedirect("ReadController");
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}

}
