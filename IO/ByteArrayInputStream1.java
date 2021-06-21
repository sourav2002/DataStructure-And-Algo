package IO;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteArrayInputStream1 {
    public static void main(String[] args) throws IOException {
        byte[] buf = new byte[128];
        for (byte i = 0; i <127; i++){
            buf[i] = i;
        }

        // Create the new byte array input stream  
        ByteArrayInputStream byt = new ByteArrayInputStream(buf);
        int k = 0;
        while ((k = byt.read()) != -1) {
            //Conversion of a byte into character
            char ch = (char) k;
            System.out.println("ASCII value of Character is:" + k + "; Special character is: " + ch);
        }
    }
}

