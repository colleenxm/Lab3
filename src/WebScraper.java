import java.awt.desktop.SystemEventListener;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    public static void main(String[] unused) {
     String fullString = urlToString("http://erdani.com/tdpl/hamlet.txt");
     int wordCount = 0;
     fullString = fullString.trim();
     String[] fullStringArray = fullString.split(" ");
     for(int i = 0; i < fullStringArray.length; i++) {
         if(fullStringArray[i] == "") {
             continue;
         } else {
             wordCount += 1;
         }
     }
     System.out.println(wordCount);
    }
    //final iteration
}
