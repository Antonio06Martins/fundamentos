package exemplo;

import exercicios.ContaCorrente;

import java.util.ArrayList;
import java.util.List;

public class Composicao {
    /*
        É um tipo de associação que permite que um objeto contenha outro objeto.
        E porque fazemos isso?

        Para obter:
            Organização: divisão de responsabilidade;
            Coesão: Cada objeto é responsável por uma única coisa evitando que uma classe "faça mais do que deve" ou seja
            cada classe tem determinada responsabilidade;
                POO : -> Princípio da Responsabilidade Única (S) do (S.O.L.I.D)
            Reuso: O mesmo objeto pode ser reaproveitado em mais de um lugar.
                Exemplo: Classe de envio de mensagem SMS poderia ser reutilizada em diversos
                pontos do projeto e até de outros projetos.
    */
    public static void main (String [] args) {
        //Exemplo de uma composição
        ContaCorrente contaCorrente  = new ContaCorrente("12345-9");
        contaCorrente.imprimirSaldo();

        //Exemplo de uma composição
        List<ContaCorrente> banco = new ArrayList<>();
        banco.add(contaCorrente);
    }
}
