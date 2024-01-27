package exemplo;

public class Matriz {
    public static void main(String [] args) {
        int linha = 3;
        int coluna = 2;

        String [] [] minhaMatriz = new String [linha][coluna];

        minhaMatriz [0][0] = "João";
        minhaMatriz [0][1] = "30 anos";
        minhaMatriz [1][0] = "Maria";
        minhaMatriz [1][1] = "25 anos";
        minhaMatriz [2][0] = "Rodrigo";
        minhaMatriz [2][1] = "40 anos";

        for (String [] resultado : minhaMatriz) {
            System.out.println("A pessoa -> " + resultado[0] + " tem " + resultado[1]);
        }
    }
}
