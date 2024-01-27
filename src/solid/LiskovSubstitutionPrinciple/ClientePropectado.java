package solid.LiskovSubstitutionPrinciple;

/*
    L = Liskov Substitution Principle -> Classes derivadas devem ser substituidas por suas classes bases.

    Este princípio ajuda a identificar que determinada classe não pertence a classe base e
    evita de extender classes de forma errada.

 */
public class ClientePropectado extends Cliente {
    /*
        Por definição não existe um cliente prospectado porque um potencial cliente é uma POSSIBILIDADE
        da entidade ser um cliente, ela não é de fato! Por exemplo,
        o método setRegistrationDate não faz sentido algum!
     */
}
