package padroes.gof.estrutural.Bridge.src;

public class ProfessorPosGraduacao extends Professor{

	public ProfessorPosGraduacao(Implementador imp){
		super(imp);
	}
	
	public void op() {
		imp.opImpl();
	}
}
