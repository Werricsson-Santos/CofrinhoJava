//Desenvolvido por - Werricsson Santos.
package cofrinho_de_moedas;

public class Dolar extends Moeda {
	//O câmbio é fixo para que posssamos alterar o câmbio da classe no programa principal, facilitando a manutenção.
	private static double cambio = 5.02;
	
	public Dolar(double valor) {
		super(valor);
	}
	
	@Override
	void info() {
		System.out.printf("Dolar - U$ %.2f\nCâmbio - R$ %.2f\n", valor, cambio);
	}

	public double getCambio() {
		return cambio;
	}

	public static void setCambio(double valor) {
		cambio = valor;
	}

	@Override
	public String toString() {
		return "Dolar [Valor= " + valor + ", Câmbio= " + getCambio() + "]\n";
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
}
