import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;

/**
 * Created by Vincent on 2/06/2016.
 */
public class Util {
    public static String readFileToString(String fileName){
        String output = "";
        try {
            output = new String(Files.readAllBytes(FileSystems.getDefault().getPath(fileName)));
        } catch(IOException e){
            e.printStackTrace();
        }
        return output;
    }
}
