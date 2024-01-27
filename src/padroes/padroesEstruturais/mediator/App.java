package padroes.padroesEstruturais.mediator;


import padroes.padroesEstruturais.mediator.mediator.Mediator;
import padroes.padroesEstruturais.mediator.mediator.TranslatorMediator;
import padroes.padroesEstruturais.mediator.model.EnglishUser;
import padroes.padroesEstruturais.mediator.model.PortugueseUser;
import padroes.padroesEstruturais.mediator.model.User;

public class App {
    public static void main(String[] args) {
        // Mediator chatRoom = new ChatMediator();
        Mediator chatRoom = new TranslatorMediator();

        User marcos = new EnglishUser("Marcos", chatRoom);
        User gustavo = new PortugueseUser("Gustavo", chatRoom);
        User simone = new EnglishUser("Simone", chatRoom);
        User vinicius = new PortugueseUser("Vinicius", chatRoom);

        chatRoom.addUser(marcos);
        chatRoom.addUser(gustavo);
        chatRoom.addUser(simone);

        marcos.sendMessage("Hello");
        gustavo.sendMessage("Oi", marcos);

        chatRoom.removeUser(simone);

        marcos.sendMessage("How are you?", gustavo);
        gustavo.sendMessage("Estou bem, obrigado.", marcos);

        chatRoom.addUser(vinicius);

        vinicius.sendMessage("Oi");

        chatRoom.removeUser(marcos);
    }
}
