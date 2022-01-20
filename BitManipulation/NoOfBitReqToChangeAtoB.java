package BitManipulation;
// find the number of bits required to change to convent A to B

public class NoOfBitReqToChangeAtoB {

    // count number of setbits in the result of a xor b
    public static int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    // Function that return count of
    // flipped number
    public static int FlippedCount(int a, int b) {
        // Return count of set bits in
        // a XOR b
        return countSetBits(a ^ b);
    }

    public static void main(String[] args) {
        int a = 0, b = 15; // in binary form  a = 0 is 0000  and b = 15 is 1111

        System.out.println(FlippedCount(a, b));
    }
}
