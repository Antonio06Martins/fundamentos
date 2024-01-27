package padroes.gof.comportamental.Mediator.src;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

//Sala de chat
public class ChatMediator extends Mediator {

	private Hashtable<String, Participante> participantes = new Hashtable<String, Participante>();
	
	private List<String> palavrasProibidas = new ArrayList<String>();
	
	public ChatMediator() {
		//Carrega a lista de palavras proibidas na sala de chat.
		palavrasProibidas.add("xxxxx");
		palavrasProibidas.add("@!xxx");
		palavrasProibidas.add("###@!");
	}
	
	public void registraParticipante(Participante p) {
		//Verifica se n�o existem dois participantes com o mesmo apelido na sala de chat.
		if(!participantes.containsKey(p.getNome())){
			participantes.put(p.getNome(), p);
		}
		else{
			System.out.println("Usu�rio j� cadastrado.");
		}
	}
	
	public void enviaMensagem(String remetente, String destinatario, String mensagem) {
		//Verifica se o remetente e o destinatario est�o na sala de chat.
		if(participantes.containsKey(remetente) && participantes.containsKey(destinatario)){
			//Obt�m o usu�rio remetente
			Participante pRemetente = participantes.get(remetente);
			//Obt�m o usu�rio destinat�rio
			Participante pDestinatario = participantes.get(destinatario);
			
			//Verifica se a mensagem cont�m palavras proibidas.
			for(String proibido : palavrasProibidas){
				if(mensagem.contains(proibido)){
					pRemetente.recebeMensagem("Mediador", "Voc� escreveu uma mensagem contendo palavras impr�prias.");
					return;
				}
			}
			
			//Se n�o h� palavras proibidas na mensagem, ent�o ela � enviada ao destinat�rio
			pDestinatario.recebeMensagem(remetente, mensagem);
		}
	}

}
