package padroes.gof.criacional.FactoryMethod.src;

import java.util.Calendar;

//F�brica concreta
public class EmpresaOnibusUrbano extends Empresa {

	public Passagem emitePassagem(String origem, String destino, Calendar dataHoraPartida) {
		
		return new PassagemOnibusUrbano(origem, destino, dataHoraPartida);
	}
	
}
