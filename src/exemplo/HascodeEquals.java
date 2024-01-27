package exemplo;

public class HascodeEquals {
    public static void main (String [] args) {
    /*
        HashCode e Equals são operações da classe Object utilizadas para comparar se um objeto é igual a outro.

        Hashcode é uma operação rápida, porém o resultado não é garantido 100% devido a
        a existir uma chance de objetos diferentes ter o mesmo hashcode.

        Equals é uma operação lenta (quando comparada com HasCode) porém é 100% garantida.

        Os tipos comuns (String, Date, Double, Integer, entre outros) possuem a implementação para essas operações.

        Já a nossas classes personalizadas precisam sobrepô-las.
     */

      Pessoa pessoa = new Pessoa("1234567-9", "Marcos", 30);
      Pessoa pessoa2 = new Pessoa("1234567-9","Marcos", 30);

      System.out.println(pessoa.hashCode());
      System.out.println(pessoa2.hashCode());
      System.out.println(pessoa == pessoa2);
      System.out.println(pessoa.equals(pessoa2));





    }
}
