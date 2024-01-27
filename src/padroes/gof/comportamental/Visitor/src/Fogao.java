package padroes.gof.comportamental.Visitor.src;

//ConcreteElement
public class Fogao extends Equipamento {

	public Fogao(String nome, double preco) {
		super(nome, preco);
	}

	public void accept(EquipamentoVisitorInterface visitor) {
		visitor.visitFogao(this);
	}
	
}