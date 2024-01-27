package padroes.gof.estrutural.Flyweight.src;

public class Linha extends Figura {

	public Linha(){
		super();
	}
	
	public void desenha(String cor) {
		System.out.println("Figura linha " + cor);
	}

}
