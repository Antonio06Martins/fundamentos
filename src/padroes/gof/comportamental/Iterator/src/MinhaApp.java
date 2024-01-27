package padroes.gof.comportamental.Iterator.src;

public class MinhaApp {

	public static void main(String[] args) {
		//Criar objeto zoo
		Zoo zoo = new ZooImpl();
		
		//Adiciona animais ao zool�gico
		zoo.addAnimal(new Animal("tigre", "mamifero"));
		zoo.addAnimal(new Animal("pinguim", "ave"));
		zoo.addAnimal(new Animal("jacar�", "reptil"));
		zoo.addAnimal(new Animal("le�o", "mamifero"));
		zoo.addAnimal(new Animal("elefante", "mamifero"));
		
		AveIterator it = new AveIterator(zoo);
		
		while(it.hasNext()){
			System.out.println(it.next().getNome());
		}
	}

}
