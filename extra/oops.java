package extra;

public class oops {

    int interest;
    int abc = 10;
    public oops (int x){
        interest = x;
        abc = x;
    }
    public static void main(String[] args) {
        oops obj = new oops(50);
        System.out.println("my size is " + obj.interest);

        obj.SBI();
        obj.PNB();
        System.out.println(obj.abc);
    }

    public void SBI(){
        oops obj = new oops(8);
        System.out.println("our bank interest  is " + obj.interest);
    }
    public void PNB(){
        oops obj = new oops(10);
        System.out.println("our bank interest  is " + obj.interest);
    }
}

// () parenthesis ....   {} curley braces......[] square bracket
