//Desenvolvido por - Werricsson Santos.
package cofrinho_de_moedas;

import java.util.ArrayList;

public class Cofrinho {
	ArrayList<Moeda> listaMoedas = new ArrayList<Moeda>();
	
	public void adicionar(Moeda m) {
		listaMoedas.add(m);
		System.out.println("\n-----------------------");
		System.out.println("Moeda depositada:");
		m.info();
		System.out.println("-----------------------\n");
	}
	
	public void remover(Moeda m) {
		//Iterando sobre a lista para ter certeza que a moeda existe no cofre.
		boolean match = false;
		for(Moeda moeda : listaMoedas) {
			if(moeda.equals(m)) {
				listaMoedas.remove(m);
				System.out.println("\n-----------------------");
				System.out.println("Moeda removida:");
				m.info();
				System.out.println("-----------------------\n");
				match = true;
				break;
			}
		}
		if(match == false) {
			System.out.println("Moeda não localizada");
		}
	}
	
	public void listagemMoedas() {
		//Condicional necessária para dar um retorno adequado ao usuário caso o mesmo não tenha efetuado nenhum depósito.
		if(listaMoedas.isEmpty()) {
			System.out.println("Cofre vazio.");
		} else {
			System.out.println("\n-----------------------");
			for (Moeda m : listaMoedas) {
				m.info();
				System.out.println();
			}
			System.out.println("-----------------------\n");
		}
	}
	
	public void totalConvertido() {
		double resultado = 0;
		for (Moeda m : listaMoedas) {
			if(m.getCambio() > 0) {
				double conversao = m.converter(m.getCambio());
				resultado = resultado + conversao;
			} else {
				resultado = resultado + m.valor;
			}
		}
		if(listaMoedas.isEmpty()) {
			System.out.println("Não existe valor para ser convertido. Cofre vazio.");
		} else {
			System.out.println("\n------------------------------------------");
			System.out.printf("Total convertido para real: R$ %.2f\n", resultado);
			System.out.println("------------------------------------------\n");
		}
	}
}
