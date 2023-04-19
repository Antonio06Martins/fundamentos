package estudos;

import java.util.Objects;

public class Teste {
    public static void main(String[] args) {
        //String nome = null;
        String nome = "Antonio";
        var verificaSeEhNulo = Objects.nonNull(nome);
        System.out.println(verificaSeEhNulo);
        System.out.println(nome);

    }
}
