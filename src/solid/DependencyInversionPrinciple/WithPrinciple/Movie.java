package solid.DependencyInversionPrinciple.WithPrinciple;
/*
    D = Dependency Inversion Principle -> Dependa de abstrações e não de implementações
*/
public class Movie {
    private Category category;

    public Movie(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
