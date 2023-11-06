package principal;
public class Cliente {
	private int idCliente;
    private String nome;
    private String telefone;
    private String email;
    private String metododePagamento;
    
    private static int proximoIdCliente = 1;
    
	public Cliente(int idCliente, String nome, String telefone, String email,String metododePagamento) {
		super();
		
		this.idCliente = idCliente;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.metododePagamento = metododePagamento;
	}
    
	
	public Cliente() {
		 this.idCliente = proximoIdCliente++;
		 
	}

	
	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getMetododePagamento() {
		return metododePagamento;
	}

	public void setMetododePagamento(String metodoDePagamento) {
		this.metododePagamento = metodoDePagamento;
	}
	@Override
	public String toString() {
		
	    return "ID: " + idCliente + "\nNome: " + nome + "\nTelefone: " + telefone + "\nE-mail: " + email +  "\nMétodo de Pagamento:" + metododePagamento;
	}

}
