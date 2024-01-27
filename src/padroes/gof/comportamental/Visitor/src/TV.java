package padroes.gof.comportamental.Visitor.src;

//ConcreteElement
public class TV extends Equipamento {

	public TV(String nome, double preco) {
		super(nome, preco);
	}

	public void accept(EquipamentoVisitorInterface visitor) {
		visitor.visitTV(this);
	}
	
}