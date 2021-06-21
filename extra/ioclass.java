package extra;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ioclass {

    public static void main(String[] args) throws IOException {
        System.out.println("simple message");
        System.err.println("error message");


        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream("input.txt");
            out = new FileOutputStream("output.txt");
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
