package padroes.gof.comportamental.Visitor.src;

//ConcreteElement
public class Geladeira extends Equipamento {

	public Geladeira(String nome, double preco) {
		super(nome, preco);
	}

	public void accept(EquipamentoVisitorInterface visitor) {
		visitor.visitGeladeira(this);
	}
	
}