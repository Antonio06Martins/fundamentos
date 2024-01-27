package solid.SingleResposabilityPrinciple;

/*
    S = Single Responsability Principle: O princípio da responsabilidade única

    Uma classe deve ter uma única responsabilidade.
    Analise se a classe está fazendo mais do deveria.
*/
public class Course {
    private String name;
    private String category;

    public void connection() {
        //do something...
        //Esse método não deveria ser de responsabilidade desta classe.
    }

    public void createCategory() {
        //do something...
        //Esse método não deveria ser de responsabilidade desta classe.
    }

    public void createCourse() {
        //do something...
        //Dependendo do objetivo da classe esse método faça sentido existir.
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
