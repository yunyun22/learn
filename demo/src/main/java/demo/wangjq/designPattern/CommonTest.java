package demo.wangjq.designPattern;

/**
 * Created by wangjq on 2018/7/10.
 */
public class CommonTest {

    public static void main(String[] args) {
        Receiver receiver = new Soldier();

        Common common = new ShotCommon(receiver);

        Invoker invoker = new Invoker(common);

        invoker.call();
    }
}

class Invoker {
    private Common common;

    public Invoker(Common common) {
        this.common = common;
    }

    public void call() {
        System.out.println("将军发出命令");
        common.execute();
    }

}

interface Common {
    void execute();
}

class ShotCommon implements Common {

    private Receiver receiver;

    public ShotCommon(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}


interface Receiver {
    void action();
}

class Soldier implements Receiver {
    @Override
    public void action() {
        System.out.println("shot...");
    }
}