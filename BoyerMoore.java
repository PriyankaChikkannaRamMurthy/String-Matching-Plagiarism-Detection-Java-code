import java.util.ArrayList;
import java.util.Arrays;

class BoyerMoore{

    private String text, pattern ;

    BoyerMoore(String pattern, String text){
        long start = System.currentTimeMillis() ;
        this.text = text ;
        this.pattern = pattern ;
        System.out.println(text.length()) ;
        search() ;
        System.out.println("Time Elapsed :" + String.valueOf(System.currentTimeMillis()-start)) ;
    }

    private int[] badCharacterHeuristic(String pattern){
        int badChar[] = new int[256] ;
        Arrays.fill(badChar, -1);
        for( int i=0; i< pattern.length(); i++){
            int index = Character.getNumericValue( pattern.charAt(i)) ;
            badChar[index] = i;
        }
        return badChar ;
    }

    void search(){
        int[] badChar = badCharacterHeuristic(pattern) ;
        int s = 0, j ;
        while( s<= text.length()-pattern.length()){
            j = pattern.length()-1 ;
            while(j >= 0 && pattern.charAt(j) == text.charAt(s+j)){
                j -- ;
            }
            if(j < 0){
                System.out.println(String.format("Pattern occured at shift={%d}", s)) ;
                s+=(s+pattern.length()<text.length())?pattern.length()-badChar[text.charAt(s+pattern.length())]:1;
            }
            else{
                    s += Math.max(1, j-badChar[text.charAt(s+j)]);
            }
        }
    }
}
