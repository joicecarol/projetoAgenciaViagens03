package dao;
import database.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
public class ClienteDAO {
	   private Connection conexao;
	   public ClienteDAO(Connection conexao) {
	        this.conexao = conexao;
	    }
	   public void cadastrarCliente(Cliente cliente) {
		  

		   String sql = "INSERT INTO cliente (nome, telefone, email, metododePagamento) VALUES (?, ?, ?, ?)";
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
	   public Cliente findClient(int id) {
			Cliente cliente = null;
			 String sql = "SELECT * FROM cliente WHERE id=?";

			try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

				stmt.setInt(1, id);
				ResultSet r = stmt.executeQuery();

				if (r.next()) {
					cliente = new Cliente();
					cliente.setIdCliente(r.getInt("idCliente"));
					cliente.setNome(r.getString("nome"));
					cliente.setTelefone(r.getString("telefone"));
					cliente.setEmail(r.getString("email"));
					cliente.setMetododePagamento(r.getString("metododePagamento"));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return cliente;
		}

	
	   
	   public List<Cliente> findClients() {

			String sql = "SELECT * FROM cliente";

			List<Cliente> clients = new ArrayList<Cliente>();

			ResultSet r = null;

			try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
				r = stmt.executeQuery();

				if (r.next()) {
					Cliente client = new Cliente();
					client = new Cliente();
					client.setIdCliente(r.getInt("idCliente"));
					client.setNome(r.getString("nome"));
					client.setTelefone(r.getString("telefone"));
					client.setEmail(r.getString("email"));
					client.setMetododePagamento(r.getString("metododePagamento"));
					

					clients.add(client);
				}
			} catch (Exception e) {

				e.printStackTrace();

			}
			return clients;
	   }
	   public void atualizarCliente(Cliente cliente) {
		    String sql = "UPDATE cliente SET nome=?, telefone=?, email=?, metododePagamento=? WHERE idCliente=?";
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


	   public void deleteCliente(int idCliente) {
		    String sql = "DELETE FROM cliente WHERE idCliente = ?";
		    try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
		        stmt.setInt(1, idCliente);
		        stmt.executeUpdate();

		        System.out.println("Cliente Deletado com sucesso!");

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
}
