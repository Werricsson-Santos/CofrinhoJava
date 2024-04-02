//Desenvolvido por - Werricsson Santos.
package cofrinho_de_moedas;

import java.util.Scanner;

/*
 * Enum criado para identificar o tipo de moeda a ser inserida/removida. 
 * Solicitar que o usuário digite o tipo de moeda, reduz o risco de confusão ao inserir/remover um tipo indesejado.
 * O enum também irá faciliar futuras implementações/manutenções...
 */
enum TipoMoedas {
	dolar, euro, real
}

public class Principal {
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		int opcao;
		String continuar = "";
		
		Cofrinho cofrinho = new Cofrinho();
		boolean encerrar = false;
		boolean start = false;
		
		while(encerrar == false) {
			try {
				/*
				 * Condicionais visando deixar o console mais limpo, para melhorar a visualização das respostas ao usuário.
				 * Imprime o Menu somente ao iniciar o programa e caso o usuário responda que deseja continuar operando.
				 */
				if (start == false) {
					start = true;
					Menu.Options();
				} else {
					while(continuar == "") {
						System.out.println("Deseja continuar gerenciando seu cofre? (Sim/Não)");
						continuar = teclado.next().replaceAll("[ã,Ã]", "a").toLowerCase();
						if (continuar.equals("sim")) {
							Menu.Options();
							continuar = "";
							break;
						} else if (continuar.equals("nao")) {
							System.out.println("Encerrando...");
							return;
						} else {
							System.out.println("Opção inválida. Digite 'sim' ou 'não'.");
							continuar = "";
						}
					}
				}
				opcao = teclado.nextInt();
				String tipoMoeda;
				Moeda m = null;
				double valor = 0;
				switch(opcao) {
				case 1:
					if(m == null) {
						System.out.println("Escolha o tipo de moeda que irá inserir, disponível apenas os tipos abaixo:");
						for (TipoMoedas tipo : TipoMoedas.values()) {
								System.out.println(tipo.toString());
						}
						tipoMoeda = teclado.next().replaceAll("[ó, Ó]", "o").toLowerCase();
						switch(TipoMoedas.valueOf(tipoMoeda)) {
						case dolar:
							System.out.println("Qual valor deseja inserir?");
							valor = teclado.nextDouble();
							m = new Dolar(valor);
							break;
						case euro:
							System.out.println("Qual valor deseja inserir?");
							valor = teclado.nextDouble();
							m = new Euro(valor);
							break;
						case real:
							System.out.println("Qual valor deseja inserir?");
							valor = teclado.nextDouble();
							m = new Real(valor);
							break;
						default:
							System.out.println("Tipo de moéda inválido.");
						}
					}
				
					cofrinho.adicionar(m);
					break;
					
				case 2:
					System.out.println("Escreva o tipo da moeda que irá remover, disponível apenas os tipos abaixo:");
					for (TipoMoedas tipo : TipoMoedas.values()) {
						System.out.println(tipo.toString());
					}
					tipoMoeda = teclado.next().replaceAll("[ó, Ó]", "o").toLowerCase();
					switch(TipoMoedas.valueOf(tipoMoeda)) {
					case dolar:
						System.out.println("Qual é o valor da moeda que deseja remover?");
						valor = teclado.nextDouble();
						m = new Dolar(valor);
						break;
					case euro:
						System.out.println("Qual é o valor da moeda que deseja remover?");
						valor = teclado.nextDouble();
						m = new Euro(valor);
						break;
					case real:
						System.out.println("Qual é o valor da moeda que deseja remover?");
						valor = teclado.nextDouble();
						m = new Real(valor);
						break;
					default:
						System.out.println("Tipo de moéda inválido.");
					}
					
					cofrinho.remover(m);
					break;
					
				case 3:
					cofrinho.listagemMoedas();
					break;
					
				case 4:
					cofrinho.totalConvertido();
					break;
					
				case 0:
					System.out.println("Encerrando...");
					teclado.close();
					encerrar = true;
					break;
				default:
					System.out.println("Opção inválida!");
				}
			} catch(Exception e) {
					System.out.println("Ocorreu um erro. Digite uma opção válida.");
					continuar = "";
					teclado.nextLine();
					continue;
			}
		}

	}
}
