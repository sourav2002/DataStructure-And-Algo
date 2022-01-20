package recursion;

// time complexity is O(n) because we traversed the full length of string
public class FirstLastOccurrence {

    static int first = -1;
    static int last = -1;

    public static void firstLastOccurrence(String st, char ch, int index) {
        if (index == st.length()) {
            System.out.println("First Occurrence of " + ch + " is at " + first + " and last occurrence is at " + last);
            return;
        }
        if (st.charAt(index) == ch) {
            if (first == -1) {
                first = index;
            } else {
                last = index;
            }
        }
        firstLastOccurrence(st, ch, index + 1);
    }

    public static void main(String[] args) {
        String st = "asbggadsava";
        firstLastOccurrence(st, 'a', 0);
    }
}
