package padroes.gof.criacional.FactoryMethod.src;

import java.util.Calendar;

//F�brica concreta
public class EmpresaOnibusInterestadual extends Empresa {

	public Passagem emitePassagem(String origem, String destino, Calendar dataHoraPartida) {
		
		return new PassagemOnibusInterestadual(origem, destino, dataHoraPartida);
	}

	

}
