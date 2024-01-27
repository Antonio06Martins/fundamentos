package solid.OpenClosedPrinciple.SemPrincipio;

/*
    O = Open Closed Principle -> Aberta para extenção, mas fechada para modificação.
 */
public class Video {
    private String type;

    public void score() {
        if(this.type.equals("Movie")) {
            //do something...
        }
        else if (this.type.equals("TVShow")) {
            //do something...
        }
        //Se no futuro existirem outros tipos como Documentary, Cartoon teremos que alterar essa classe!
    }
}
