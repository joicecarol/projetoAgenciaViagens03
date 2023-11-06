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


@WebServlet("/DeleteControlle")
public class DeleteControlle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		try {
			Connection conexao = Conexao.createConnection();
			ClienteDAO cDAO = new ClienteDAO(conexao);
			cDAO.deleteCliente(id);
			
			res.sendRedirect("ReadController");
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
	}

}

