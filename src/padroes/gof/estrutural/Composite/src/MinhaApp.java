package padroes.gof.estrutural.Composite.src;

public class MinhaApp {

	public static void main(String[] args) {
		//Cria programadores (folhas)
		Programador pEstagiario = new Programador("Jos�", 900);
		Programador pJunior = new Programador("Pedro", 2900);
		Programador pSenior = new Programador("Ricardo", 3900);
		
		//Gerentes
		Gerente g3 = new Gerente("Jo�o", 15000);
        Gerente g2 = new Gerente("Maria", 10000);
        Gerente g1 = new Gerente("Carlos", 5000);
        
        //Montar a estrutura em �rvore
        
        //Carlos superviosiona os programadores Jos� e Pedro
        g1.add(pEstagiario);
        g1.add(pJunior);
        
        //Maria superviosiona o programador Ricardo
        g2.add(pSenior);
        
        //Jo�o � raiz da estrutura em �rvore
        g3.add(g1);
        g3.add(g2);
        
        g3.print();
	}

}
