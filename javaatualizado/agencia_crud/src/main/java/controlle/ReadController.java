package controlle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import database.Conexao;
import modelo.Cliente;


@WebServlet("/ReadController")
public class ReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 try {
		        Connection conexao = Conexao.createConnection(); 

		        ClienteDAO cDAO = new ClienteDAO(conexao); 
		        List<Cliente> clientes = cDAO.findClients();
		        request.setAttribute("clientes", clientes);

		        RequestDispatcher rd = request.getRequestDispatcher("clientes.jsp");
		        rd.forward(request, response);
		       

		    } catch (Exception e) {
		        e.printStackTrace();
		    }
	
	
	}

}
