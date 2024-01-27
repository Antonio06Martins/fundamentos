package padroes.padroesEstruturais.facade;


import padroes.padroesEstruturais.facade.services.ServicoFacade;

public class App {
    public static void main(String[] args) {
        ServicoFacade servicoFacade = new ServicoFacade();
        servicoFacade.executaServicoD();
    }
}