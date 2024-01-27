package padroes.gof.criacional.AbstractFactory.src;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class MinhaApp {

	public static void main(String[] args) {
		//Empresas de �nibus
		EmpresaOnibus viacaoXYZ = new ConcreteEmpresaOnibus();
		
		//Emite passagens
		PassagemBusUrbano pUrbano = viacaoXYZ.emitePassagemOnibusUrbano("S�o Paulo", "Campinas", new GregorianCalendar(2016, Calendar.MARCH, 10, 11, 0));
		
		PassagemBusInterestadual pInterestadual = viacaoXYZ.emitePassagemOnibusInterestadual("S�o Paulo", "Rio de Janeiro", new GregorianCalendar(2016, Calendar.APRIL, 20, 8, 30));
		
		//Exibe detalhes da passagem
		pUrbano.exibeDetalhes();
		
		pInterestadual.exibeDetalhes();
	}

}
