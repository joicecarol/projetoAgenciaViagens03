package principal;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Viagem {
	private int idViagem;
	private String destino;
	private Date dataDePartida;
	private Date dataDeRetorno;
	private int numeroDePessoas;
	private double preco;
	private String linhaAerea;
	private static int proximoIdViagem = 1;
	

	
	public Viagem(int idViagem, String destino, Date dataDePartida, Date dataDeRetorno, int numeroDePessoas, double preco, String linhaAerea) {
		super();
		this.idViagem = idViagem;
		this.destino = destino;
		this.dataDePartida = dataDePartida;
		this.dataDeRetorno = dataDeRetorno;
		this.numeroDePessoas = numeroDePessoas;
		this.preco = preco;
		this.linhaAerea = linhaAerea;
	}

	

	public Viagem() {
		this.idViagem = proximoIdViagem++;
		
	}



	public int getIdViagem() {
		return idViagem;
	}



	public void setIdViagem(int idViagem) {
		this.idViagem = idViagem;
	}



	public String getDestino() {
		return destino;
	}



	public void setDestino(String destino) {
		this.destino = destino;
	}



	public Date getDataDePartida() {
		return dataDePartida;
	}



	public void setDataDePartida(Date dataDePartida) {
		this.dataDePartida = dataDePartida;
	}



	public Date getDataDeRetorno() {
		return dataDeRetorno;
	}



	public void setDataDeRetorno(Date dataDeRetorno) {
		this.dataDeRetorno = dataDeRetorno;
	}



	public int getNumeroDePessoas() {
		return numeroDePessoas;
	}



	public void setNumeroDePessoas(int numeroDePessoas) {
		this.numeroDePessoas = numeroDePessoas;
	}

	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	public String getLinhaAerea() {
        return linhaAerea;
    }

   
    public void setLinhaAerea(String linhaAerea) {
        this.linhaAerea = linhaAerea;
    }
	@Override
	public String toString() {
		SimpleDateFormat formatoDataBrasil = new SimpleDateFormat("dd/MM/yyyy");
	    String dataDePartidaFormatada = formatoDataBrasil.format(dataDePartida);
	    SimpleDateFormat formatoDataBrasil1 = new SimpleDateFormat("dd/MM/yyyy");
	    String dataDeRetornoFormatada = formatoDataBrasil1.format(dataDeRetorno);
	    return "ID Destino: " + idViagem + "\nDestino: " + destino + "\nData de Partida: " + dataDePartidaFormatada + "\nData de Retorno: " + dataDeRetornoFormatada + "\nNúmero de Pessoas: " + numeroDePessoas + "\nPreço: " + preco + "\nLinha Aérea: " + linhaAerea;
	}
	
}