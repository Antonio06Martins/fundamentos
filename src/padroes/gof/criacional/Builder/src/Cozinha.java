package padroes.gof.criacional.Builder.src;

public class Cozinha{
	
	public void fazSanduiche(SanduicheBuilder builder){
		builder.abrePao();
		builder.insereIngredientes();
		builder.fechaPao();
	}
}
