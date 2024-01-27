package exemplo;

import java.util.Date;

public class App {
    public static void main(String [] args) {
        Date dataCadastro = new Date();
        MinhaClasse minhaClasse = new MinhaClasse();
        MinhaClasse minhaOutraClasse = new MinhaClasse("Marcos", dataCadastro);

        minhaClasse.setNome("Miguel");
        minhaClasse.setDataCadastro(dataCadastro);

        System.out.println(minhaClasse);
        System.out.println(minhaOutraClasse);
    }
}
