package padroes.gof.criacional.AbstractFactory.src;

import java.util.Calendar;

public class ConcreteEmpresaOnibus extends EmpresaOnibus {

	public PassagemBusUrbano emitePassagemOnibusUrbano(String origem, String destino, Calendar dataHoraPartida) {

		return new ConcretePassagemBusUrbano(origem, destino, dataHoraPartida);
	}

	public PassagemBusInterestadual emitePassagemOnibusInterestadual(String origem, String destino, Calendar dataHoraPartida) {

		return new ConcretePassagemBusInterestadual(origem, destino, dataHoraPartida);
	}

	
	
}
