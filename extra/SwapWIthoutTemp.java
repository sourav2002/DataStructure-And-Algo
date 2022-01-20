package extra;

public class SwapWIthoutTemp {
    public static void main(String[] args) {
//        String a = "Love";
//        String b = "You";
//        System.out.println("before swap : " + a +" "+ b);
        //  1st way
//        a = a+ b;
//        System.out.println(a);
//        b = a.substring(0, a.length() - b.length());
//        System.out.println(b);
//        a = a.substring(b.length());
//        System.out.println(a);

        // 2nd way with Math
//        int x = 4;
//        int y = 6;
//
//        System.out.println("before swap:" + "x = "+ x + " y = " +y);
//        x = x * y;
//        y = x / y;
//        x = x / y;
//        System.out.println("now x = "+ x +" y = "+ y);


        // 3rd way using bitwise operators
        int x = 10;
        int y = 5;

        System.out.println("Before swap: x = "
                + x + ", y = " + y);
        // Code to swap 'x' (1010) and 'y' (0101)
        x = x ^ y; // x now becomes 15 (1111)
        y = x ^ y; // y becomes 10 (1010)
        x = x ^ y; // x becomes 5 (0101)

        System.out.println("After swap: x = "
                + x + ", y = " + y);
    }
}
