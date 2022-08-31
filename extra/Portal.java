package extra;

public class Portal {
    public static void main(String[] args) {
        Bank b = new Bank();
        int am = b.getAmount();
        System.out.println(am);

        System.out.println(b.getName());
        int bc = 10/0;

        System.out.println(b.getName());
    }
}

