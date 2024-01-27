package exemplo;

public class OperadoresAritmeticos {
    public static void main (String [] args) {
        /*
           O cálculo segue a mesma precedência utilizada na matemática convencinal.

           Primeiro * / %
           Depois   + -

           O operador % é o mod e retorna o resto de uma divisão.

           Se deseja mudar a precedencia você deve utilizar o recurso dos parênteses para isolar o cálculo
         */

        //Exemplos:
        System.out.println(10 + 10 - 3 * 20 / 5); // Retorna 8
        System.out.println(10 + (10 - 3) * (20 / 5));//Retorna 38
        System.out.println((10 + 10 - 3) * (20 / 5));//Retorna 68
        System.out.println(10 + (10 - 3 * 20) / 5);//Retorna 0
        System.out.println((10 + 10 - 3) * (20 / 5));//Retorna 68

        System.out.println(10%2);//Retorna 0 porque 10/2 tem o resto da divisão = 0
        System.out.println(10%3);//Retorna 1 porque 10/3 tem resto da divisão = 1
    }
}
