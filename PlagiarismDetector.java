import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class PlagiarismDetector {
    public static void main(String[] args) throws IOException, NullPointerException{
        /*StringBuilder build = new StringBuilder() ;

        Files.walk(Paths.get("/Users/ashwin/IdeaProjects/PlagiarismDetector/src/data/"))
                .filter(Files::isRegularFile)
                .forEach( p -> build.append(readFile(p.toString())) );
        new KMP(readFile("/Users/ashwin/IdeaProjects/PlagiarismDetector/src/data/trial.txt"), build.toString()) ;

        Files.walk(Paths.get("/Users/ashwin/IdeaProjects/PlagiarismDetector/src/data/"))
                .filter(Files::isRegularFile)
                .forEach(p-> simulate("/Users/ashwin/IdeaProjects/PlagiarismDetector/src/data/trial.txt",
                        p.toString()));
        System.out.println("----------===========--------------===================================---------");*/
        new BoyerMoore() ;

    }

    synchronized  private static void simulate(String pattern, String text){
        System.out.println("File read : "+text) ;
        //new BoyerMoore("aaabbbbaaaa ", "aabbbbaaabbbbaaaa") ;
        new NaiveSearch(readFile(pattern), readFile(text)) ;
        new LeastCommonSubSequence(readFile(pattern), readFile(text)) ;
    }

    private static String readFile(String filePath){
        try {
            return new String(Files.readAllBytes(Paths.get(filePath))) ;
        }catch(IOException ex){
            System.err.println(ex.getMessage()) ;
        }
        return "" ;
    }
}
