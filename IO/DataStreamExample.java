package IO;

import java.io.*;

public class DataStreamExample {
    public static void main(String args[]) {
        try {
            FileInputStream fin = new FileInputStream("/home/sourav/Desktop/output.txt");
            int i = 0;
            while ((i = fin.read()) != -1) {
                System.out.print((char) i);
            }
            fin.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
