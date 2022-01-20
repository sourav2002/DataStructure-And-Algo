package IO;

import java.io.FileOutputStream;
import java.io.IOException;

public class ByteOutputstream {
    public static void main(String[] args) throws IOException {
        try {
            FileOutputStream fout = new FileOutputStream("/home/sourav/Desktop/output.txt");
            String s = "my name is sourav \n";
            byte b[] = s.getBytes();// converting string into byte array
            System.out.println("Byte value is : ");
            fout.write(83);
            fout.write(b);
            fout.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
