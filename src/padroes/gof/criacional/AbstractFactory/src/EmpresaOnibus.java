package padroes.gof.criacional.AbstractFactory.src;

import java.util.Calendar;

public abstract class EmpresaOnibus {
	
	public abstract PassagemBusUrbano emitePassagemOnibusUrbano(String origem, String destino, Calendar dataHoraPartida);
	
	public abstract PassagemBusInterestadual emitePassagemOnibusInterestadual(String origem, String destino, Calendar dataHoraPartida);
	
}
