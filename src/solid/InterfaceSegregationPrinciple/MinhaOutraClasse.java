package solid.InterfaceSegregationPrinciple;

/*
    I = Interface Segregation Principle -> Uma classe não é obrigada a implementar métodos da interface
    que ela não utilizará.
*/
public class MinhaOutraClasse implements InterfaceSegregada1, InterfaceSegregada2 {
    @Override
    public void metodo1() {
        //do something...
    }

    @Override
    public void metodo2() {
        //do something...
    }
}
