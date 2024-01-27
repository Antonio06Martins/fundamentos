package exemplo;

public class ConversaoExplicita {
    public static void main (String [] args) {
        int valorI = 10;
        long valorL = 10L;

        long total = valorI + valorL;

        //int  total2 = valorI + valorL;//Não compila!

        int  total3 = valorI + (int) valorL;//Fazendo Casting, ou seja fazendo a coversão explicita de um tipo em outro.
    }
}
