package principal.principalDAO;
import principal.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import principal.Cliente;
public class ClienteDAO {
	   private Connection conexao;
	   public ClienteDAO(Connection conexao) {
	        this.conexao = conexao;
	    }
	   public void cadastrarCliente(Cliente cliente) {
		  

		   String sql = "INSERT INTO cliente (nome, telefone, email, metodoDePagamento) VALUES (?, ?, ?, ?)";
		   try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
		       preparedStatement.setString(1, cliente.getNome());
		       preparedStatement.setString(2, cliente.getTelefone());
		       preparedStatement.setString(3, cliente.getEmail());
		       preparedStatement.setString(4, cliente.getMetododePagamento());
		       preparedStatement.executeUpdate();
		       System.out.println("Cliente cadastrado com sucesso.");
		   } catch (SQLException e) {
		       System.out.println("Erro ao cadastrar o cliente: " + e.getMessage());
		   }
	   }

	   public Cliente consultarClientePorNome(String nome) {
		    String sql = "SELECT * FROM cliente WHERE nome=?";
		    try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
		        preparedStatement.setString(1, nome);
		        ResultSet resultSet = preparedStatement.executeQuery();
		        if (resultSet.next()) {
		            Cliente cliente = new Cliente();
		            cliente.setIdCliente(resultSet.getInt("idCliente"));
		            cliente.setNome(resultSet.getString("nome"));
		            cliente.setTelefone(resultSet.getString("telefone"));
		            cliente.setEmail(resultSet.getString("email"));
		            cliente.setMetododePagamento(resultSet.getString("metodoDePagamento"));
		            return cliente;
		        }
		    } catch (SQLException e) {
		        System.out.println("Erro ao consultar cliente: " + e.getMessage());
		    }
		    return null;
		}
	   public void atualizarCliente(Cliente cliente) {
		    String sql = "UPDATE cliente SET nome=?, telefone=?, email=?, metodoDePagamento=? WHERE idCliente=?";
		    try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
		        preparedStatement.setString(1, cliente.getNome());
		        preparedStatement.setString(2, cliente.getTelefone());
		        preparedStatement.setString(3, cliente.getEmail());
		        preparedStatement.setString(4, cliente.getMetododePagamento());
		        preparedStatement.setInt(5, cliente.getIdCliente());
		        preparedStatement.executeUpdate();
		        System.out.println("Cliente atualizado com sucesso.");
		    } catch (SQLException e) {
		        System.out.println("Erro ao atualizar o cliente: " + e.getMessage());
		    }
		}

	   public void deletarClientePorNome(String nome) {
		    String sql = "DELETE FROM cliente WHERE nome=?";
		    try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
		        preparedStatement.setString(1, nome);
		        preparedStatement.executeUpdate();
		        System.out.println("Cliente deletado com sucesso.");
		    } catch (SQLException e) {
		        System.out.println("Erro ao deletar o cliente: " + e.getMessage());
		    }
		}
	 
}
