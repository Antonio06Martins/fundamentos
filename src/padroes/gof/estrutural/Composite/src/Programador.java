package padroes.gof.estrutural.Composite.src;

//Leaf
public class Programador extends Empregado {
  
    public Programador(String nome, double salario) {
        super(nome, salario);
    }
 
    //Exibe detalhes do empregado
    public void print() {
        System.out.println(super.nome + ", $" + super.salario);
    }
     
    //Adiciona empregado � estrutura.
    public void add(Empregado e) {
        System.out.println("N�o � poss�vel adicionar empregado subordinado do programador");
    }
  
    //Remove empregado da estrutura.
    public void remove(Empregado e) {
        System.out.println("N�o � poss�vel remover empregado subordinado do programador");
    }
}