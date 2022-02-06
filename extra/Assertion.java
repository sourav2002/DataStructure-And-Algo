package extra;

public class Assertion {
    /*
     * @param args
     */
    public static void main(String[] args) {
        // debugging without  Assertion
        int a = 0;
        while (true){
            if (a>1){
                System.out.println("code working correctly");
                break;
            }
            assert false : "something wrong!! "+ a+" should be greater than 1";
//            System.out.println("something wrong!!");
            break;
        }

        int x = -8;
        assert (x>0): "Asserting internal invariants";
//        System.out.println("Assertion error");
        assertionExample(5);
    }

    // pre condition
    public static void assertionExample(int a){
        assert a>0 && a<=100;
        int b = a+2; //method logic


        assert b>a;// post condition
    }
}
