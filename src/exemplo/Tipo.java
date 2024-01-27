package exemplo;

public enum Tipo {
    /*
      Enumeration é um tipo que serve para especificar de forma literal um conjunto de constante relacionada.
      Vantagem: melhor semântica, código mais legível, maior segurança

      https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html

      As constantes enun são implicitamente final e static
    */
    CONTA_CORRENTE,
    CONTA_POUPANCA,
    CONTA_PAGAMENTO;
}
