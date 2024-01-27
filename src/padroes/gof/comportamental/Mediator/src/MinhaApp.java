package padroes.gof.comportamental.Mediator.src;

public class MinhaApp {

	public static void main(String[] args) {
		//Cria-se o objeto mediador
		ChatMediator salaChat = new ChatMediator();
		
		//Criam-se os objetos participantes
		Participante joao = new ParticipanteImpl("Jo�o", salaChat);
		Participante maria = new ParticipanteImpl("Maria", salaChat);
		Participante carlos = new ParticipanteImpl("Carlos", salaChat);
		Participante renato = new ParticipanteImpl("Renato", salaChat);
		
		//Registra todos os participantes na sala de chat
		salaChat.registraParticipante(joao);
		salaChat.registraParticipante(maria);
		salaChat.registraParticipante(carlos);
		salaChat.registraParticipante(renato);
		
		//Inicia a conversa entre os participantes
		joao.enviaMensagem("Maria", "Ol� Maria, tudo bem ?");
		
		maria.enviaMensagem("Jo�o", "Oi tudo! E com voc� ?");
		
		carlos.enviaMensagem("Renato", "Renato, voc� � um @!xxx.");
		
		joao.enviaMensagem("Maria", "Voc� est� no trabalho agora ?");
	}

}
