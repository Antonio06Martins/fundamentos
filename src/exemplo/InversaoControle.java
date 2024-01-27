package exemplo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InversaoControle {
    public static void main(String [] args) {
        /*
            POO -> S.O.L.I.D D = Dependency Inversion Principle -> Dependa de abstrações e não de implementações
            Dependa de abstrações e não de implementações
        */

        InversaoControle.semInversaoControle();

        InversaoControle.comInversaoControle(new ArrayList());//injeção de dependência

        InversaoControle.comInversaoControle(new LinkedList());//injeção de dependência

    }

    private static void semInversaoControle() {
        ArrayList umaLista = new ArrayList();//acoplamento forte pois estou dependendo de implementações
        //umaLista.add();
        //mais códigos....
    }

    private static void comInversaoControle(List list) {
        List umaLista = list;//acoplamento fraco pois estou dependendo de abstração (interface)
        //umaLista.add();
        //mais códigos....
    }
}