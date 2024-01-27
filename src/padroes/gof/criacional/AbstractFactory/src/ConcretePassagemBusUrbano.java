package padroes.gof.criacional.AbstractFactory.src;

import java.util.Calendar;

public class ConcretePassagemBusUrbano extends PassagemBusUrbano {

	public ConcretePassagemBusUrbano(String origem, String destino, Calendar dataHoraPartida) {
		
		super(origem, destino, dataHoraPartida);
	}

	public void exibeDetalhes() {
		System.out.println("Passagem de �nibus urbana: " + this.getOrigem() + 
				" para " + this.getDestino() + 
				", Data/Hora: " + super.df.format(this.getDataHoraPartida().getTime()));
	}

}
