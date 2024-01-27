package padroes.gof.estrutural.Adapter.src;

//Adapter
public class AdapterEUAtoBrasil extends TomadaBrasileira {
	
	public String conecta(PlugAmericano plug) {
		return plug.obtemEletricidade() + this.getNomeRede();
	}
}
