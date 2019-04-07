import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Math ;

class LeastCommonSubSequence {

    private String test, corpora;
    private StringBuilder sequence ;

    /**
     *
     * @param pattern Text 1 which is to be matched for the sequence.
     * @param text Text 2 which is to be matched for the sequence.
     */
    LeastCommonSubSequence(String pattern, String text){
        long start = System.nanoTime() ;
        this.test = pattern ;
        this.corpora = text;
        this.sequence = new StringBuilder() ;
        getSequenceLength() ;
        System.out.println("LCSS subsequence:"+getSequence()) ;
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
        System.out.println("Time Elapsed :" + String.valueOf(System.currentTimeMillis()-start)) ;
    }

    /**
     *
     * @return length of the smallest sequence.
     */
    private int getSequenceLength(){
        return getSequenceLength(test, corpora) ;
    }

    /**
     *
     * @param test the sequence that is to be found.
     * @param corpora the text in which the sequence is to be found.
     * @return the length of the sequence.
     */
    private int getSequenceLength(String test, String corpora){
        if ( test.length() == 0 || corpora.length() == 0) {
            return 0;
        }

        if (test.charAt(0) == corpora.charAt(0)) {
            if (!sequence.toString().contains(Character.toString(test.charAt(0)))) {
                sequence.append(test.charAt(0));
            }
            return 1 + getSequenceLength(
                    (new StringBuilder(test).deleteCharAt(0).toString()),
                    (new StringBuilder(corpora).deleteCharAt(0).toString()));
        }

        else
            return Math.max(
                    getSequenceLength(test, (new StringBuilder(corpora).deleteCharAt(0).toString())),
                    getSequenceLength(new StringBuilder(test).deleteCharAt(0).toString(), corpora)) ;
    }

    /**
     *
     * @return the smallest sequence as a String.
     */
    String getSequence(){
        return sequence.toString() ;
    }
}

