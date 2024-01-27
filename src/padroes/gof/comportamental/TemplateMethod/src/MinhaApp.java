package padroes.gof.comportamental.TemplateMethod.src;

public class MinhaApp {

	public static void main(String[] args) {
		Game game = new Futebol();
		
		game.play();
	}

}
