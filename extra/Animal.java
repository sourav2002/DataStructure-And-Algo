package extra;

class Animal {
    void eat(){
        System.out.println("eating...");
    }
}
class Dog extends Animal{
    void bark(){
        System.out.println("barking...");
    }
}
class BabyDog extends Dog{


//    public void weep(String s){
//        System.out.println("weeping...");
//    }
//    public int weep(int y){
//        System.out.println("helooww");
//        return 1;
//    }
    void print(String s){
        System.out.println("my name is "+ s);
    }

    int val = 100;

}
class TestInheritance2 extends BabyDog {

    void print(String s){
        System.out.println("hellow "+ s);
    }


     int val = 200;

    void ans(){
        System.out.println(val);
        System.out.println(super.val);
    }

    public static void main(String args[]){
        TestInheritance2 t = new TestInheritance2();

        t.ans();


    }
}