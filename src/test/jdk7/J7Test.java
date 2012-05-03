package test.jdk7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author alan
 * @date 12-5-3
 * @history
 */
public class J7Test {

    static void readFirstLineFromFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
             br.readLine();
//        } catch (IOException e) {
        }
    }

    public static void main(String[] args) {
        try {
            readFirstLineFromFile("c:/aa.txt");
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
