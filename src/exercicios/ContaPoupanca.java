package exercicios;


import exemplo.Tipo;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(String identificadorConta) {
        super.identificadorConta = identificadorConta;
        super.tipo = Tipo.CONTA_POUPANCA;
    }

    public double rendimentos() {
        return super.saldo * 0.01;
    }

    public void imprimirSaldo() {
        System.out.println("Conta: " + super.identificadorConta + " Saldo: " + super.saldo + " tipo: " + super.tipo + " Rendimentos: " + rendimentos());
    }
 }
