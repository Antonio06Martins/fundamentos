package exercicios.app;

import exemplo.TipoValor;
import exercicios.Conta;
import exercicios.ContaCorrente;
import exercicios.ContaPoupanca;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main (String [] args) {
        ContaCorrente contaCorrente = new ContaCorrente("123456-0");
        contaCorrente.depositar(100.00);
        contaCorrente.sacar(70.00);

        ContaCorrente contaCorrente2 = new ContaCorrente("923456-0");
        contaCorrente2.depositar(1000.00);

        ContaPoupanca contaPoupanca = new ContaPoupanca("11789-0");
        contaPoupanca.depositar(5000);
        ContaPoupanca contaPoupanca2 = new ContaPoupanca("18789-0");
        contaPoupanca2.depositar(500);

        List<ContaCorrente> contascorrente = new ArrayList<>();
        contascorrente.add(contaCorrente);
        contascorrente.add(contaCorrente2);

        List<ContaPoupanca> contaspoupanca = new ArrayList<>();
        contaspoupanca.add(contaPoupanca);
        contaspoupanca.add(contaPoupanca2);

        for(ContaCorrente conta : contascorrente) {
            conta.imprimirSaldo();
        }

        for(ContaPoupanca conta : contaspoupanca) {
            conta.imprimirSaldo();
        }

        System.out.println("----------uso do instanceof para identificar o tipo do objeto----------");
        System.out.println();

        List<Conta> contas = new ArrayList<>();
        contas.add(contaCorrente);
        contas.add(contaCorrente2);
        contas.add(contaPoupanca);
        contas.add(contaPoupanca2);

        for(Conta conta : contas) {
            if(conta instanceof ContaCorrente){
                ((ContaCorrente) conta).imprimirSaldo();
            }
            if(conta instanceof ContaPoupanca){
                ((ContaPoupanca) conta).imprimirSaldo();
            }
        }

        App app = new App();
        app.meuMetodoComEnum(TipoValor.CONTA_CORRENTE);
        //app.meuMetodoComEnum(1);
        app.meuMetodoSemEnum(8);//Enum garante maior segurança quanto ao valor que está sendo inserido como parâmetro.

    }

    private void meuMetodoSemEnum(Integer tipoValor) {
        System.out.println(tipoValor);
    }

    private void meuMetodoComEnum(TipoValor tipoValor) {
        System.out.println("O tipo selecionado foi " + tipoValor + " que vale " +  tipoValor.getValor());
    }
}
