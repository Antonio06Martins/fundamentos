package padroes.gof.criacional.FactoryMethod.src;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class MinhaApp {

	public static void main(String[] args) {
		//Empresas de �nibus
		Empresa viacaoABCLocal = new EmpresaOnibusUrbano();
				
		Empresa viacaoXYZInter = new EmpresaOnibusInterestadual();
		
		//Emite passagens
		Passagem pUrbano = viacaoABCLocal.emitePassagem("S�o Paulo", "Campinas", new GregorianCalendar(2016, Calendar.MARCH, 10, 11, 0));
		
		Passagem pInterestadual = viacaoXYZInter.emitePassagem("S�o Paulo", "Rio de Janeiro", new GregorianCalendar(2016, Calendar.APRIL, 20, 8, 30));
		
		//Exibe detalhes da passagem
		pUrbano.exibeDetalhes();
		
		pInterestadual.exibeDetalhes();
	}

}
