package padroes.gof.estrutural.Bridge.src;

public class MinhaApp {

	public static void main(String[] args) {
		
		Professor grad = new ProfessorGraduacao(new ProfessorImplGraduacao());
		grad.op();
	}

}
