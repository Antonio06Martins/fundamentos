package padroes.gof.comportamental.Visitor.src;

public interface EquipamentoVisitorInterface {

    void visitGeladeira(Geladeira geladeira);
    void visitTV(TV tv);
    void visitFogao(Fogao fogao);
}
