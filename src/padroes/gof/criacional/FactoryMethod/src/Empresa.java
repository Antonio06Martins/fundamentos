package padroes.gof.criacional.FactoryMethod.src;

import java.util.Calendar;

//F�brica
public abstract class Empresa {
	
	public abstract Passagem emitePassagem(String origem, String destino, Calendar dataHoraPartida);
	
}
