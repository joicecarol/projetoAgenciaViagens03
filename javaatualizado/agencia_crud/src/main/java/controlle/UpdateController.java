package controlle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import database.Conexao;
import modelo.Cliente;

@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println("ID recebido: " + id);
		
		try {
			Connection conexao = Conexao.createConnection();
			ClienteDAO cDAO = new ClienteDAO(conexao);
			Cliente cliente = cDAO.findClient(id);
			
			req.setAttribute("cliente", cliente);
			
			RequestDispatcher rd = req.getRequestDispatcher("atualizar.jsp");
			rd.forward(req, res);
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}


	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			Cliente cliente = new Cliente();
			cliente.setIdCliente(Integer.parseInt(req.getParameter("idCliente")));
			cliente.setNome(req.getParameter("nome"));
			cliente.setTelefone(req.getParameter("telefone"));
			cliente.setEmail(req.getParameter("email"));
			cliente.setMetododePagamento(req.getParameter("metododePagamento"));
			
			
			Connection conexao = Conexao.createConnection();
			ClienteDAO cDAO = new ClienteDAO(conexao);
			cDAO.atualizarCliente(cliente);
			
			res.sendRedirect("ReadController");
		} catch (Exception e) {
			
		}
		
		
		
		
	}

}
