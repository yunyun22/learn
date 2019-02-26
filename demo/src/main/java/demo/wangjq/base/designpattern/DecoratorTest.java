package demo.wangjq.base.designpattern;

/**
 * Created by wangjq on 2018/7/11.
 */
public class DecoratorTest {
}

abstract class Human {

    public abstract void sayChar(char c);


    public static void main(String[] args) {
        Human human = new Man();

        SayStringMan sayStringMan = new SayStringMan(human);


        sayStringMan.sayString("1314520");
    }
}


class Man extends Human {

    @Override
    public void sayChar(char c) {
        System.out.println(c);
    }
}

class SayStringMan extends Human {
    private Human human;

    public SayStringMan(Human human) {
        this.human = human;
    }

    @Override
    public void sayChar(char c) {
        human.sayChar(c);
    }

    public void sayString(String s) {
        char[] chars = new char[s.length()];
        s.getChars(0, s.length(), chars, 0);
        for (char c : chars) {
            sayChar(c);
        }
    }
}