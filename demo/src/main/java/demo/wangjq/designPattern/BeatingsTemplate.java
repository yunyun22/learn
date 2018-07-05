package demo.wangjq.designPattern;

/**
 * Created by wangjq on 2018/7/5.
 */
public abstract class BeatingsTemplate {


    public static void main(String[] args) {
        Person p = new Person("yangchao");

        BeatingsTemplate beatings = new BeatingYangChao();

        beatings.beatings(p);
    }

    public boolean beatings(Person p) {

        System.out.println("受刑人姓名：" + p.getName());

        if (isBeatings(p)) {
            method();
            explain();
            return true;
        }

        return false;
    }

    public abstract boolean isBeatings(Person p);

    public abstract void method();

    public abstract void explain();
}

class BeatingYangChao extends BeatingsTemplate {

    @Override
    public boolean isBeatings(Person p) {
        if ("yangchao".equals(p.getName())) {
            return true;
        }
        return false;
    }

    @Override
    public void method() {
        System.out.println("受刑方式：电击");
    }

    @Override
    public void explain() {
        System.out.println("受刑原因：超哥装了逼");
    }
}


class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                '}';
    }
}