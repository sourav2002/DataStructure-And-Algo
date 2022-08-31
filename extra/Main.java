package extra;

import java.util.*;
        import java.io.*;

public class Main {
    public static int processArray(ArrayList<Integer> list) {
        for(int i=0; i<list.size(); i++){
            int n = list.get(i);
            if(n > 46 && n % 10 == 3){
                list.set(i, -1);
            }
            else if(n > 46){
                list.set(i, -3);
            }else if(n % 10 == 3){
                list.set(i, -9);
            }
        }
        return list.size();
    }

    public static void main (String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int num = in.nextInt();
            if (num < 0)
                break;
            arrayList.add(new Integer(num));
        }
        int new_length = processArray(arrayList);
        for(int i=0; i<new_length; i++)
            System.out.println(arrayList.get(i));
    }
}