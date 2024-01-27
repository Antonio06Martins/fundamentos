package exercicios;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exercicio003 {
    public static void main (String [] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Digite um valor: ");
        double valor = teclado.nextDouble();
        /*
            % é o operador módulo que retorna o resto da divisão por 2
            entende-se então que se o valor informado dividido por 2 dar resto igual a 0 então o
            valor informado é par.
         */
        boolean par = (valor % 2) == 0;
        if (par) {
            for (int i = 0; i < 4; i++){
                System.out.println("O valor informado é par");
            }
        }
        else {
            for (int i = 0; i < 3; i++){
                System.out.println("O valor informado é ímpar");
            }
        }
        System.out.println();
        System.out.print("Digite uma frase: ");
        teclado.nextLine();//necessário porque na última leitura do teclado a tecla "enter" ficou pendente de leitura.
        String frase = teclado.nextLine();
        StringBuilder stringBuilder = new StringBuilder(frase);
        System.out.println(stringBuilder.reverse().toString().toUpperCase());
        teclado.close();

        LocalDateTime localDateTime = LocalDateTime.now();
        String strLocalDateTime = localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        System.out.println(strLocalDateTime);
    }
}
