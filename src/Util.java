import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;

/**
 * Created by Vincent on 2/06/2016.
 */
public class Util {
    public static String readFileToString(String fileName) {
        String output = "";
        try {
            output = new String(Files.readAllBytes(FileSystems.getDefault().getPath(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    public static String[][] generateCombinationsProper(String[] input) {
        String[][] result = new String[input.length * input.length][input.length];

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                int position = (i * input.length) + j;
                result[position][0] = input[i];
                result[position][1] = input[j];
            }
        }

        return result;
    }
}
