import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class NaiveSearch {

    private String text, pattern;


    /**
     *
     * @param text - text in which the pattern needs to be found.
     * @param pattern - pattern that is to be found.
     */
    NaiveSearch(String pattern, String text) {
        long start = System.nanoTime() ;
        this.text = text;
        this.pattern = pattern;
        this.search() ;
        CharSequence time_taken = String.valueOf( System.nanoTime()-start );
        File file = new File("time.txt") ;
        File file_ = new File("length.txt") ;
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.append(time_taken).append("\n");
            writer.close();
            writer = new FileWriter(file_, true) ;
            writer.append(String.valueOf(text.length())).append("\n");
            writer.close();
        }catch(IOException ex){
            System.err.println(ex.getMessage()) ;
        }
        System.out.println("Time Elapsed :" + String.valueOf(System.nanoTime()-start)) ;
    }

    /**
     *
     * @return boolean - result based on the pattern found.
     */
    private boolean search() {
        int found , temp ;
        boolean pattern_occured = false;
        for (int i = 0; i < (this.text.length() - this.pattern.length() - 1); i++) {
            found = 0;
            temp = i;
            for (char p : this.pattern.toCharArray()) {
                if (this.text.charAt(temp) == p){
                    found++;
                    if (found == this.pattern.length()) {
                        System.out.println("Naiver Search : Pattern starts from :"+ temp);
                        pattern_occured = true ;
                    }
                } else
                    break;
                temp++;
            }
        }
        return pattern_occured ;
    }

}