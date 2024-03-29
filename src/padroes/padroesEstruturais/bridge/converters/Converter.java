package padroes.padroesEstruturais.bridge.converters;


import padroes.padroesEstruturais.bridge.entities.Conta;

/*
	Bridge é um padrão de projeto estrutural que divide a lógica de negócio ou uma enorme classe em
	 hierarquias de classe separadas que podem ser desenvolvidas independentemente.
*/
public interface Converter {
	String getFormated(Conta conta);
}
