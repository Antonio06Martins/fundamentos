package padroes.padroesEstruturais.bridge;


import padroes.padroesEstruturais.bridge.converters.CSVConverter;
import padroes.padroesEstruturais.bridge.converters.Converter;
import padroes.padroesEstruturais.bridge.converters.JsonConverter;
import padroes.padroesEstruturais.bridge.entities.Conta;
import padroes.padroesEstruturais.bridge.entities.ContaCorrente;
import padroes.padroesEstruturais.bridge.entities.ContaPoupanca;

public class App {
    public static void main(String[] args) {
        Converter csvConverter = new CSVConverter();
        Converter jsonConverter = new JsonConverter();

        Conta contaCorrente = new ContaCorrente("001", "123", 8000d, "Marcos");
        Conta contaPoupanca = new ContaPoupanca("002", "456", 9000d, "Rodrigo");

        System.out.println(csvConverter.getFormated(contaCorrente));
        System.out.println(jsonConverter.getFormated(contaCorrente));
        System.out.println(csvConverter.getFormated(contaPoupanca));
        System.out.println(jsonConverter.getFormated(contaPoupanca));
    }
}
