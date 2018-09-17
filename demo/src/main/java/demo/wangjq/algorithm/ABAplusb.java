package demo.wangjq.algorithm;

/**
 * Created by wangjq on 2018/8/31.
 */
public class ABAplusb {

    public static void main(String[] args) {

        int i = 2;

        //左移
        // binray: 1  <<1 : 10
        // binray: 1  <<2 : 100
        System.out.print("1左移1位：");
        System.out.println(1 << 1);
        System.out.print("1左移2位：");
        System.out.println(1 << 2);

        // binray: 11  <<1 : 110
        // binray: 11  <<2 : 1100
        System.out.print("3左移1位：");
        System.out.println(3 << 1);
        System.out.print("3左移2位：");
        System.out.println(3 << 2);


        //右移
        // binray: 1  >>1 : 10
        // binray: 1  >>2 : 100
        System.out.print("1右移1位：");
        System.out.println(1 >> 1);
        System.out.print("1右移2位：");
        System.out.println(1 >> 2);

        // binray: 11  <<1 : 110
        // binray: 11  <<2 : 1100
        System.out.print("3右移1位：");
        System.out.println(3 >> 1);
        System.out.print("3右移2位：");
        System.out.println(3 >> 2);


    }
}
