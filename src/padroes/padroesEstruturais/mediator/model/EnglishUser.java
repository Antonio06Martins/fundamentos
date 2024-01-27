package padroes.padroesEstruturais.mediator.model;


import padroes.padroesEstruturais.mediator.mediator.Mediator;

public class EnglishUser extends User {

    public EnglishUser(String name, Mediator mediator) {
        super(name, mediator, Language.ENGLISH);
    }

}
