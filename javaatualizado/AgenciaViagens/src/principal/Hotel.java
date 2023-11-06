package principal;
public class Hotel {
	private int idHotel;
	private String local;
	private String nomeDoHotel;
	private int quantidadeDiaria;
	private double precoHotel;
	
	private static int proximoIdHotel = 1;
	
	
	 public Hotel(int idHotel, String local, String nomeDoHotel, int quantidadeDiaria, double precoHotel) {
		super();
		this.idHotel = idHotel;
		this.local = local;
		this.nomeDoHotel = nomeDoHotel;
		this.quantidadeDiaria = quantidadeDiaria;
		this.precoHotel = precoHotel;
	}


	public Hotel() {
	        this.idHotel = proximoIdHotel++;
	 }


	public int getIdHotel() {
		return idHotel;
	}


	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}


	public String getLocal() {
		return local;
	}


	public void setLocal(String local) {
		this.local = local;
	}


	public String getNomeDoHotel() {
		return nomeDoHotel;
	}


	public void setNomeDoHotel(String nomeDoHotel) {
		this.nomeDoHotel = nomeDoHotel;
	}


	public int getQuantidadeDiaria() {
		return quantidadeDiaria;
	}


	public void setQuantidadeDiaria(int quantidadeDiaria) {
		this.quantidadeDiaria = quantidadeDiaria;
	}


	public static int getProximoIdHotel() {
		return proximoIdHotel;
	}

	public static void setProximoIdHotel(int proximoIdHotel) {
		Hotel.proximoIdHotel = proximoIdHotel;
	}
	
	public double getPrecoHotel() {
        return precoHotel;
    }

    public void setPrecoHotel(double precoHotel) {
        this.precoHotel = precoHotel;
    }
	@Override
	public String toString() {
	    
	    return "ID do Hotel: " + idHotel + "\nLocal: " + local + "\nNome do Hotel: " + nomeDoHotel + "\nQuantidade de diárias: " + quantidadeDiaria + "\nPreco do Hotel: " + precoHotel;
	}
}
	