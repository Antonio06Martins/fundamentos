package padroes.gof.estrutural.Decorator.src;

//ConcreteDecorator
public class Estrela extends Decoracao{
		
	public Estrela(Arvore a) {
		super(a);
	}

	public void showEnfeites() {
		super.showEnfeites();
		System.out.print("Estrela, ");
	}
}
