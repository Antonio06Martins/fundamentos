package solid.DependencyInversionPrinciple.NoPrinciple;
/*
    D = Dependency Inversion Principle -> Dependa de abstrações e não de implementações
*/
public class Movie {
    private DramaCategory category;

    public DramaCategory getCategory() {
        return new DramaCategory();
    }

    public void setCategory(DramaCategory category) {
        this.category = category;
    }
}
