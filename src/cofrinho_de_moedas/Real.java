//Desenvolvido por - Werricsson Santos.
package cofrinho_de_moedas;

public class Real extends Moeda {
	public Real(double valor) {
	super(valor);
	}
	
	//O câmbio será zero porque é a moeda nativa.
	public double getCambio() {
		return 0;
	}
	
	
	@Override
	void info() {
		System.out.printf("Real - R$ %.2f\n", valor);
	}



	@Override
	public String toString() {
		return "Real [valor=" + valor + "]\n";
	}



	
	
}
