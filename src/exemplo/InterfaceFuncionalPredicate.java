package exemplo;

import java.util.ArrayList;
import java.util.List;

public class InterfaceFuncionalPredicate {
    public static void main(String [] args) {
    /*
        https://docs.oracle.com/javase/10/docs/api/java/util/function/Predicate.html

        public interface Predicate<T> {
            boolean test(T t);
        }

        Útil para testar algum critério que possa retornar verdadeiro ou falso (true / false) numa lista.

     */
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Marcos", 30));
        pessoas.add(new Pessoa("André", 28));
        pessoas.add(new Pessoa("Gustavo", 21));
        pessoas.add(new Pessoa("Ricardo", 15));

        int idadeMinima = 30;

        //Remove elementos cujo critério é verdadeiro
        pessoas.removeIf(pessoa -> pessoa.getIdade() < idadeMinima);
        for(Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }

        //Method reference (referência para método)
        pessoas.removeIf(Pessoa::pessoaMenor30Estatico);
        pessoas.removeIf(Pessoa::pessoaMenor30NaoEstatico);
        pessoas.forEach(System.out::println);
    }
}
