package exemplo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class InterfaceFuncionalConsumer {
    public static void main(String [] args) {
        /*
        https://docs.oracle.com/javase/10/docs/api/java/util/function/Consumer.html

        public interface Consumer<T> {
            void accept(T t);
        }

        Útil para executar algum procedimento numa lista.
     */

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Marcos", 30));
        pessoas.add(new Pessoa("André", 28));
        pessoas.add(new Pessoa("Gustavo", 21));
        pessoas.add(new Pessoa("Ricardo", 15));

        Consumer<Pessoa> consumer = pessoa -> {
            if(pessoa.getIdade() < 21) {
                pessoa.setNome(pessoa.getNome().toLowerCase());
            }
            else {
                pessoa.setNome(pessoa.getNome().toUpperCase());
            }
        };

        //altera o atributo nome de cada elemento.
        pessoas.forEach(consumer);

        // pessoas.forEach(pessoa -> pessoa.setNome(pessoa.getNome().toUpperCase()));

        pessoas.forEach(System.out::println);
    }
}
