import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Example of JEP 226: UTF-8 Property Resource Bundles
 * Build and run first with a Java 8 JDK - the first two lines of output will be correct, the second will not
 * Re-build and run with Java 9, all 4 lines of output will be correct
 */
public class UTF8Properties {

    public static void main(String[] args){

        //In Java 8 and earlier ResourceBundle loaded files in ISO-8859-1 encoding
        //Messages in this encoding can be much harder to read if they include certain characters
        //e.g. gegrüßt must be encoded as gegr\u00fc\u00DFt, 今日は as \u4eca\u65e5\u306f
        //Java 9 can still read these files correctly
        Locale currentLocale = Locale.GERMANY;
        ResourceBundle isoGermanlabels = ResourceBundle.getBundle("ISO_LabelsBundle", currentLocale);
        System.out.println(isoGermanlabels.getString("hello"));

        currentLocale = Locale.JAPAN;
        ResourceBundle isoJapaneseLabels = ResourceBundle.getBundle("ISO_LabelsBundle", currentLocale);
        System.out.println(isoJapaneseLabels.getString("hello"));

        //Attempting to load a UTF-8 encoded file in Java 8 and earlier would lead to incorrect output
        // gegrüßt prints as gegrÃ¼Ãt, 今日は appears as ä»æ¥ã¯
        //Java 9 now reads as UTF-8 by default, and correctly handles the text
        currentLocale = Locale.GERMANY;
        ResourceBundle labels = ResourceBundle.getBundle("LabelsBundle", currentLocale);
        System.out.println(labels.getString("hello"));

        currentLocale = Locale.JAPAN;
        ResourceBundle japaneseLabels = ResourceBundle.getBundle("LabelsBundle", currentLocale);
        System.out.println(japaneseLabels.getString("hello"));
    }
}
