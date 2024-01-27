package exercicios;

import java.util.Scanner;

public class Exercicio002 {
    public static void main (String [] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite um valor: ");
        double valor1 = teclado.nextDouble();
        System.out.println("Digite outro valor: ");
        double valor2 = teclado.nextDouble();
        System.out.println("Digite outro valor: ");
        double valor3 = teclado.nextDouble();
        System.out.println("Digite outro valor: ");
        double valor4 = teclado.nextDouble();
        teclado.close();
        double media = (valor1 + valor2 + valor3 + valor4) / 4;

        if(media >= 7.0) {
            System.out.println("Parabéns! Você aprovado com média: " + media);
        }
        else {
            System.out.println("Você foi reprovado com média: " + media);
        }
    }
}
