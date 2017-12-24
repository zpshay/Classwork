import java.util.TreeMap;
import javax.swing.JFileChooser;
import java.util.StringTokenizer;
import java.lang.Object;
import java.io.*;

public class TextCounter {
      
   public static void main( String[] args ) {
   TreeMap<String,Integer> wordCount = new TreeMap<String,Integer>();
   try {
      JFileChooser chooser = new JFileChooser();
      chooser.showOpenDialog(null);
      File file = new File(chooser.getName());
      FileReader filename = new FileReader(file.getName());
      BufferedReader bufRead = new BufferedReader(filename);
      while (bufRead.readLine() != null) {
         String str = bufRead.readLine();
         StringTokenizer words = new StringTokenizer(" \'\"\n\r\t;:.,!?()-");
         while (words.hasMoreTokens()) {
            if (wordCount.get(words) == null) {
               Integer value = 1;
               wordCount.put(str, value);
            } else {
               wordCount.put(str,(wordCount.get(words) + 1));
            }
         }
      }
   } catch (FileNotFoundException ex) {
      System.out.println("File Not Found!");
   } catch (IOException ex) {
      System.out.println("Input error!");
   }
   }
}