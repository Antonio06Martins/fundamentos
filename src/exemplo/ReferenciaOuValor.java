package exemplo;

public class ReferenciaOuValor {
    public static void main(String[] args) {
        int valor = 1;
        meuMetodoPrimitivo(valor);
        System.out.println(valor);

        System.out.println("-------------");

        Pessoa pessoa = new Pessoa("Marcos", 30);
        meuMetodoObjeto(pessoa);
        System.out.println(pessoa);
    }

    //passagem de parâmetro em Java é sempre por valor
    private static void meuMetodoPrimitivo(int parametro) {
        //a alteração feita aqui não afeta por ser apenas uma cópia da variável externa informada no parâmetro.
        parametro = 30;
    }

    //passagem de parâmetro em Java é sempre por valor
    private static void meuMetodoObjeto(Pessoa parametro) {
        //consigo alterar porque a cópia feita aponta para o mesmo endereço na memória da variável externa.
        parametro.setNome("José");
        parametro.setIdade(80);


        /*
            A alteração aqu não afeta a variável externa por ser apenas uma cópia e o novo objeto estará numa
            num outro endereço diferente da variável externa.
        */
        parametro = new Pessoa("Fernando", 5);
    }
}