package padroes.padroesComportamentais.strategy;


import padroes.padroesComportamentais.strategy.strategies.AdditionOperation;
import padroes.padroesComportamentais.strategy.strategies.DivisionOperation;
import padroes.padroesComportamentais.strategy.strategies.MultiplicationOperation;
import padroes.padroesComportamentais.strategy.strategies.SubtractionOperation;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(10, 5);
        System.out.println(calculator.getResult(new AdditionOperation()));
        System.out.println(calculator.getResult(new SubtractionOperation()));
        System.out.println(calculator.getResult(new MultiplicationOperation()));
        System.out.println(calculator.getResult(new DivisionOperation()));
    }
}