package padroes.padroesEstruturais.adapter.dispositivos;

import padroes.padroesEstruturais.adapter.interfaces.VGA;

public class MonitorVGA implements VGA {
    @Override
    public void setImagem(String imagem) {
        System.out.println("Imagem ok");
    }
}
