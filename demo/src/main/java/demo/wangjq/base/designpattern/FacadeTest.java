package demo.wangjq.base.designpattern;

/**
 * Created by wangjq on 2018/7/16.
 */
public class FacadeTest {

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.stat();
    }
}


class Computer {

    private CPU cpu = new CPU();

    private Disk disk = new Disk();

    public void stat() {
        cpu.start();
        disk.start();
        System.out.println("computer start");
    }


}

class CPU {

    public void start() {
        System.out.println("start CPU");
    }

}

class Disk {

    public void start() {
        System.out.println("start disk");
    }

}