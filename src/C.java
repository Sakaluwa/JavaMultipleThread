import UserClass.B;

/**
 * Created by 94839 on 2016/9/17.
 */
public class C {
    private String c="我是C";
    public void getB(){
        System.out.println(c);
    }

    public static void main(String[] args) {
        B b=new B();
        b.getB();
    }
}
