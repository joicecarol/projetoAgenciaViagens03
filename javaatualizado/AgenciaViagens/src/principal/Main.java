package principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;

import principal.principalDAO.ClienteDAO;
import principal.principalDAO.HotelDAO;

public class Main {

	public static void main(String[] args) {
		Connection conexao = Conexao.createConnection();
		Conexao.createConnection();
		Scanner entrada = new Scanner(System.in);
		Cliente cliente = new Cliente();
        Viagem viagem = new Viagem();
        Hotel hotel = new Hotel();
		Reserva reserva = new Reserva(new Date(), 0.0, 0.0, cliente, viagem, hotel, "Pendente");
		ClienteDAO clienteDAO = new ClienteDAO(conexao);
		HotelDAO hotelDAO = new HotelDAO(conexao);
		String statusPagamento = "";
		
		int opcao;
        do {
        	System.out.println();
            System.out.println("MENU:");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Visualizar Cadastro do Cliente");
            System.out.println("3 - Atualizar Cadastro do Cliente");
            System.out.println("4 - Deletar Cliente");
            System.out.println("5 - Cadastrar Hotel");
            System.out.println("6 - Visualizar Cadastro do Hotel");
            System.out.println("7 - Atualizar Cadastro do Hotel: ");
            System.out.println("8 - Deletar Hotel: ");
            System.out.println("9 - Cadastrar Viagem");
            System.out.println("10 - Consultar Viagem");
            System.out.println("11 - Consultar Reserva");
            System.out.println("12 - Sair do Programa");
            System.out.println("Escolha uma opção: ");
            opcao = entrada.nextInt();
		
            
            switch (opcao) {
            case 0:
                System.out.println("Retornando ao menu principal...");
                break;
            case 1:
            	
            	System.out.println("CADASTRO DO CLIENTE");
                System.out.println("Digite o nome do cliente: ");
                entrada.nextLine();
        		String nome = entrada.nextLine();
        		cliente.setNome(nome);
        		System.out.println("Digite o telefone do cliente: ");
        		String telefone = entrada.nextLine();
        		cliente.setTelefone(telefone);
        		System.out.println("Digite o e-mail do cliente: ");
        		String email = entrada.nextLine();
        		cliente.setEmail(email);        
        		System.out.println("Escolha o método de pagamento: ");
            	System.out.println("1 - Cartão");
            	System.out.println("2 - Transferência Bancária");
            	System.out.println("3 - Boleto");
            	int metodoPagamentoOpcao = entrada.nextInt();
            	String metododePagamento = "";
            	if (metodoPagamentoOpcao == 1) {
            	    metododePagamento = "cartao";
            	} else if (metodoPagamentoOpcao == 2) {
            	    metododePagamento = "tranferência bancária";
            	} else if (metodoPagamentoOpcao == 3) {
            	    metododePagamento = "boleto";
            	} else {
            	    System.out.println("Opção de pagamento inválida.");
            	}
            	 if (metododePagamento.equals("cartao")) {
            	    statusPagamento = "Pagamento Confirmado";
            	    reserva.setStatus("Confirmada"); 
            	} else if (metododePagamento.equals("boleto")) {
            	    statusPagamento = "Pagamento Pendente";
            	    reserva.setStatus("Pendente - Aguardando Pagamento"); 
            	} else {
            	    statusPagamento = " Pagamento Pendente"; 
            	    reserva.setStatus("Pendente - Aguardando Pagamento"); 
            	}
            	Cliente novoCliente = new Cliente();
            	novoCliente.setNome(nome);
            	novoCliente.setTelefone(telefone);
            	novoCliente.setEmail(email);
            	novoCliente.setMetododePagamento(metododePagamento);
            	clienteDAO.cadastrarCliente(novoCliente);
            	System.out.println("Pressione 0 para voltar ao menu principal...");
            	break;
            case 2:
            	System.out.println("CONSULTAR CLIENTE POR NOME");
                System.out.println("Digite o nome do cliente que deseja consultar: ");
                entrada.nextLine(); 

                String nomeClienteConsultar = entrada.nextLine();
                Cliente clienteConsultado = clienteDAO.consultarClientePorNome(nomeClienteConsultar);

                if (clienteConsultado != null) {
                	System.out.println("Cliente encontrado:");
                    System.out.println("ID: " + clienteConsultado.getIdCliente());
                    System.out.println("Nome: " + clienteConsultado.getNome());
                    System.out.println("Telefone: " + clienteConsultado.getTelefone());
                    System.out.println("E-mail: " + clienteConsultado.getEmail());
                    System.out.println("Método de Pagamento: " + clienteConsultado.getMetododePagamento());
                } else {
                    System.out.println("Cliente não encontrado.");
                }

                System.out.println("Pressione 0 para voltar ao menu principal...");
                break;
                
            case 3:
                System.out.println("ATUALIZAR CLIENTE");
                entrada.nextLine();
                System.out.println("Digite o nome do cliente que deseja atualizar: ");
                String nomeClienteAtualizar = entrada.nextLine();
                Cliente clienteAtualizar = clienteDAO.consultarClientePorNome(nomeClienteAtualizar);
                if (clienteAtualizar != null) {
                    System.out.println("Digite o novo nome do cliente: ");
                    String novoNome = entrada.nextLine();
                    clienteAtualizar.setNome(novoNome);
                    System.out.println("Digite o novo telefone do cliente: ");
                    String novoTelefone = entrada.nextLine();
                    clienteAtualizar.setTelefone(novoTelefone);
                    System.out.println("Digite o novo e-mail do cliente: ");
                    String novoEmail = entrada.nextLine();
                    clienteAtualizar.setEmail(novoEmail);
                    System.out.println("Escolha o novo método de pagamento:");
                    System.out.println("1 - Cartão");
                    System.out.println("2 - Transferência Bancária");
                    System.out.println("3 - Boleto");
                    int novoMetodoPagamentoOpcao = entrada.nextInt();
                    String novoMetodoPagamento = "";
                    if (novoMetodoPagamentoOpcao == 1) {
                        novoMetodoPagamento = "cartao";
                    } else if (novoMetodoPagamentoOpcao == 2) {
                        novoMetodoPagamento = "transferência bancária";
                    } else if (novoMetodoPagamentoOpcao == 3) {
                        novoMetodoPagamento = "boleto";
                    } else {
                        System.out.println("Opção de pagamento inválida.");
                    }
                    clienteAtualizar.setMetododePagamento(novoMetodoPagamento);
                    clienteDAO.atualizarCliente(clienteAtualizar);
                    System.out.println("Cliente atualizado com sucesso.");
                } else {
                	System.out.println("Cliente não encontrado.");
                }
                System.out.println("Pressione 0 para voltar ao menu principal...");
                break;
            case 4:
            	System.out.println("DELETAR CLIENTE POR NOME");
            	entrada.nextLine();
                System.out.println("Digite o nome do cliente que deseja deletar: ");
                String nomeClienteDeletar = entrada.nextLine();
                clienteDAO.deletarClientePorNome(nomeClienteDeletar);
                System.out.println("Pressione 0 para voltar ao menu principal...");
                break;
            case 5:
            	System.out.println("CADASTRO DO HOTEL");
            	 System.out.println("Digite o Local: ");
            	 entrada.nextLine();
            	 String local = entrada.nextLine();
            	 hotel.setLocal(local);
            	  System.out.println("Digite o nome do hotel: ");
            	  String nomeDoHotel = entrada.nextLine();
            	  hotel.setNomeDoHotel(nomeDoHotel);
            	  System.out.println("Digite a quantidade de diárias: ");
            	int quantidadeDiaria;
            	  try {
            		    quantidadeDiaria = Integer.parseInt(entrada.next());
            		} catch (NumberFormatException e) {
            		    System.out.println("Valor inválido. Certifique-se de digitar um número inteiro.");
            		    continue; 
            		}
            		hotel.setQuantidadeDiaria(quantidadeDiaria);
            	  System.out.println("Digite o Preço do Hotel: ");
            	  Double precoHotel = entrada.nextDouble();
            	  hotel.setPrecoHotel(precoHotel);
            	  hotelDAO.cadastrarHotel(hotel);
            System.out.println("Pressione 0 para voltar ao menu principal...");
                
                break; 
            
            case 6:
           	 System.out.println("CONSULTAR HOTEL POR NOME");
           	entrada.nextLine();
     	    System.out.println("Digite o nome do hotel que deseja consultar: ");
     	    String nomeHotelConsultar = entrada.nextLine();
     	    Hotel hotelConsultado = hotelDAO.consultarHotelPorNome(nomeHotelConsultar);
     	    if (hotelConsultado != null) {
     	        System.out.println("Hotel encontrado:");
     	        System.out.println("ID: " + hotelConsultado.getIdHotel());
     	        System.out.println("Local: " + hotelConsultado.getLocal());
     	        System.out.println("Nome do Hotel: " + hotelConsultado.getNomeDoHotel());
     	        System.out.println("Quantidade de Diárias: " + hotelConsultado.getQuantidadeDiaria());
     	        System.out.println("Preço do Hotel: " + hotelConsultado.getPrecoHotel());
     	    } else {
     	        System.out.println("Hotel não encontrado.");
     	    }
     	   System.out.println("Pressione 0 para voltar ao menu principal...");
     	    break;
            case 7:
            	System.out.println("ATUALIZAR HOTEL");
            	System.out.println("Digite o nome do hotel que deseja atualizar: ");
            	entrada.nextLine(); 
            	String nomeHotelAtualizar = entrada.nextLine(); 
                
                Hotel hotelAtualizar = hotelDAO.consultarHotelPorNome(nomeHotelAtualizar);

                if (hotelAtualizar != null) {
                	
                    System.out.println("Digite o novo local do hotel: ");
                    String novoLocal = entrada.next();
                    hotelAtualizar.setLocal(novoLocal);
                    System.out.println("Digite o novo nome do hotel: ");
                    String novoNomeDoHotel = entrada.next();
                    hotelAtualizar.setNomeDoHotel(novoNomeDoHotel);
                    
                    System.out.println("Digite a nova quantidade de diárias: ");
                    try {
                        int novaQuantidadeDiaria = entrada.nextInt();
                        hotelAtualizar.setQuantidadeDiaria(novaQuantidadeDiaria);
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Certifique-se de digitar um número inteiro.");
                        entrada.nextLine();
                    }
                    
                    System.out.println("Digite o novo preço do hotel: ");
                    double novoPrecoHotel = entrada.nextDouble();
                    hotelAtualizar.setPrecoHotel(novoPrecoHotel);
                 
                    hotelDAO.atualizarHotel(hotelAtualizar);
                    
                    System.out.println("Hotel atualizado com sucesso.");
                } else {
                    System.out.println("Hotel não encontrado.");
                }
                System.out.println("Pressione 0 para voltar ao menu principal...");
                break;
            case 8:
                System.out.println("DELETAR HOTEL POR NOME");
                entrada.nextLine();
                System.out.println("Digite o nome do hotel que deseja deletar: ");
                String nomeHotelDeletar = entrada.nextLine();
                hotelDAO.deletarHotelPorNome(nomeHotelDeletar);
                System.out.println("Hotel deletado com sucesso.");
                System.out.println("Pressione 0 para voltar ao menu principal...");
                break;
                
            case 9: 
            	
            	System.out.println("CADASTRO DA VIAGEM ");
                System.out.println("Digite o destino: ");
                entrada.nextLine();
                   		String destino = entrada.nextLine();
             		viagem.setDestino(destino);
             	System.out.println("Digite a data de partida: ");
           		String dataPartidaStr = entrada.nextLine();
           		SimpleDateFormat formatoData1 = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date dataPartida = formatoData1.parse(dataPartidaStr);
                   viagem.setDataDePartida(dataPartida);
                } catch (ParseException e) {
                    System.out.println("Erro ao ler a data de nascimento. Certifique-se de usar o formato dd/MM/yyyy.");
                }
                System.out.println("Digite a data de retorno: ");
                String dataRetornoStr = entrada.nextLine();
           		SimpleDateFormat formatoData2 = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date dataRetorno = formatoData2.parse(dataRetornoStr);
                    viagem.setDataDeRetorno(dataRetorno);
                } catch (ParseException e) {
                    System.out.println("Erro ao ler a data de retorno. Certifique-se de usar o formato dd/MM/yyyy.");
                }
                System.out.println("Digite o número de pessoas: ");
        		int numeroDePessoas = entrada.nextInt();
        		viagem.setNumeroDePessoas(numeroDePessoas);
        		System.out.println("Digite o preço: ");
        		Double preco = entrada.nextDouble();
        		viagem.setPreco(preco);
        		System.out.println("Escolha a Companhia aérea:");
            	System.out.println("1 - Gol");
            	System.out.println("2 - Latam");
            	System.out.println("3 - Azul");
            	
            	int escolhaCompanhiaAerea = entrada.nextInt();
            	
            	switch (escolhaCompanhiaAerea) {
                case 1:
                    viagem.setLinhaAerea("Gol");
                    break;
                case 2:
                    viagem.setLinhaAerea("Latam");
                    break;
                case 3:
                    viagem.setLinhaAerea("Azul");
                    break;
                default:
                    System.out.println("Opção de companhia aérea inválida.");
                    break;
            }
            	System.out.println("Pressione 0 para voltar ao menu principal...");	
            break;
        case 10:
        	System.out.println("DADOS DA VIAGEM");
        	System.out.println(viagem.toString());
        	System.out.println("Pressione 0 para voltar ao menu principal...");
        
            break;
      
        case 11:
        	System.out.println("=====CONSULTAR RESERVA======");
        	System.out.println("ATENÇÃO!! A  sua reserva só será efetivada após ser inserido todos os dados de viagem, hotél e cliente corretamente");
        	double valorTotalReserva = viagem.getPreco() + hotel.getPrecoHotel();
        	SimpleDateFormat formatoDataBrasil = new SimpleDateFormat("dd/MM/yyyy");
                
        	System.out.println("ID da Reserva: " + reserva.getIdReserva());
        	System.out.println("Data da Reserva: " + formatoDataBrasil.format(reserva.getDataDaReserva()));
            System.out.println("Status da Reserva: " + reserva.getStatus());
            System.out.println("Nome do cliente: " + cliente.getNome());
            System.out.println("Dta de Partida: " + formatoDataBrasil.format(viagem.getDataDePartida()));
            System.out.println("Data de Retorno: " + formatoDataBrasil.format(viagem.getDataDeRetorno()));
            System.out.println("Linha aérea: " + viagem.getLinhaAerea());
            System.out.println("Nome do Hotel: " + hotel.getNomeDoHotel());
            System.out.println("Local: " + hotel.getLocal());
            System.out.println("Valor Total da Reserva: " + valorTotalReserva);
            System.out.println("Status do Pagamento: " + statusPagamento);

            System.out.println("Pressione 0 para voltar ao menu principal...");
            break;
            
        case 12:
            System.out.println("Saindo do programa...");
            break; 
        
    default:
        System.out.println("Opção inválida. Tente novamente.");
        break;
}
} while (opcao != 12);

entrada.close();
}

	
	}

	
	

