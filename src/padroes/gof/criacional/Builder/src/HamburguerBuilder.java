package padroes.gof.criacional.Builder.src;

public class HamburguerBuilder extends SanduicheBuilder{
	
	private Sanduiche s = new Hamburguer(); 
	
	public void abrePao() {
		System.out.println("Abre p�o de hamburguer.");
	}

	public void insereIngredientes() {
		System.out.println("Insere carne e queijo.");
	}

	public void fechaPao() {
		System.out.println("Fecha p�o de hamburguer.");
	}

	public Sanduiche getSanduiche() {
		System.out.println("Hamburguer est� pronto !");
		return s;
	}
}
