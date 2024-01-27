package exercicios;


import exemplo.Tipo;

public class ContaCorrente extends Conta {
    public ContaCorrente(String identificadorConta) {
        super.identificadorConta = identificadorConta;
        super.tipo = Tipo.CONTA_CORRENTE;
        //super.tipo = Tipo.valueOf("CONTA_CORRENTE");
    }

    public void imprimirSaldo() {
        System.out.println("Conta: " + super.identificadorConta + " Saldo: " + super.saldo + " tipo: " + super.tipo);
    }
}
