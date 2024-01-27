package padroes.gof.criacional.Builder.src;

public class FishBuilder extends SanduicheBuilder{

	private Sanduiche s = new Fishburguer(); 
	
	public void abrePao() {
		System.out.println("Abre p�o de fishburguer.");
	}

	public void insereIngredientes() {
		System.out.println("Insere fil� de peixe.");
	}

	public void fechaPao() {
		System.out.println("Fecha p�o de fishburguer.");
	}

	public Sanduiche getSanduiche() {
		System.out.println("Fishburguer est� pronto !");
		return s;
	}
}
