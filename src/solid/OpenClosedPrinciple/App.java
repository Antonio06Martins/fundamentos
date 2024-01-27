package solid.OpenClosedPrinciple;


import solid.OpenClosedPrinciple.ComPrincipio.Movie;
import solid.OpenClosedPrinciple.ComPrincipio.TVShow;
import solid.OpenClosedPrinciple.ComPrincipio.Video;

public class App {
    public static void main (String [] Args) {
        solid.OpenClosedPrinciple.SemPrincipio.Video videoSemPrincipio = new solid.OpenClosedPrinciple.SemPrincipio.Video();
        videoSemPrincipio.score();

        Video videoComPrincipio = new Movie();
        videoComPrincipio.score();

        videoComPrincipio = new TVShow();
        videoComPrincipio.score();

        /*
           Se no futuro for criado outros novos tipos de vídeo, não haverá necessidade de mudar em nada as classes
           já criadas que atendem ao princípio no Caso Movie e TVShow

           Exemplo:
             videoComPrincipio = new Cartoon();
             videoComPrincipio.score();

        */
    }
}
