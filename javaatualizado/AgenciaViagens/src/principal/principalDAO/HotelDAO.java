package principal.principalDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import principal.Conexao;
import principal.Hotel;
public class HotelDAO {
	private Connection conexao;
	public HotelDAO(Connection conexao) {
        this.conexao = conexao;
	}

	public void cadastrarHotel(Hotel hotel) {
	    String sql = "INSERT INTO hotel (localHotel, nomeDoHotel, quantidadeDiaria, precoHotel) VALUES (?, ?, ?, ?)";

	    try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
	        preparedStatement.setString(1, hotel.getLocal());
	        preparedStatement.setString(2, hotel.getNomeDoHotel());
	        preparedStatement.setInt(3, hotel.getQuantidadeDiaria());
	        preparedStatement.setDouble(4, hotel.getPrecoHotel());
	        preparedStatement.executeUpdate();
	        System.out.println("Hotel cadastrado com sucesso.");
	    } catch (SQLException e) {
	        System.out.println("Erro ao cadastrar o hotel: " + e.getMessage());
	    }
	}

	public Hotel consultarHotelPorNome(String nomeDoHotel) {
	    String sql = "SELECT * FROM hotel WHERE nomeDoHotel=?";
	    try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
	        preparedStatement.setString(1, nomeDoHotel);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        if (resultSet.next()) {
	            Hotel hotel = new Hotel();
	            hotel.setIdHotel(resultSet.getInt("idHotel"));
	            hotel.setLocal(resultSet.getString("localHotel"));
	            hotel.setNomeDoHotel(resultSet.getString("nomeDoHotel"));
	            hotel.setQuantidadeDiaria(resultSet.getInt("quantidadeDiaria"));
	            hotel.setPrecoHotel(resultSet.getDouble("precoHotel"));
	            return hotel;
	        }
	    } catch (SQLException e) {
	        System.out.println("Erro ao consultar hotel: " + e.getMessage());
	    }
	    return null;
	}
	public void atualizarHotel(Hotel hotel) {
	    String sql = "UPDATE hotel SET localHotel=?, nomeDoHotel=?, quantidadeDiaria=?, precoHotel=? WHERE idHotel=?";
	    try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
	        preparedStatement.setString(1, hotel.getLocal());
	        preparedStatement.setString(2, hotel.getNomeDoHotel());
	        preparedStatement.setInt(3, hotel.getQuantidadeDiaria());
	        preparedStatement.setDouble(4, hotel.getPrecoHotel());
	        preparedStatement.setInt(5, hotel.getIdHotel());
	        preparedStatement.executeUpdate();
	        System.out.println("Hotel atualizado com sucesso.");
	    } catch (SQLException e) {
	        System.out.println("Erro ao atualizar o hotel: " + e.getMessage());
	    }
	}
	public void deletarHotelPorNome(String nome) {
	    String sql = "DELETE FROM hotel WHERE nomeDoHotel=?";
	    try (PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {
	        preparedStatement.setString(1, nome);
	        preparedStatement.executeUpdate();
	        System.out.println("Hotel deletado com sucesso.");
	    } catch (SQLException e) {
	        System.out.println("Erro ao deletar o hotel: " + e.getMessage());
	    }
	}
}