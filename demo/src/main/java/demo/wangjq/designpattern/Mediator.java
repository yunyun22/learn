package demo.wangjq.designpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjq on 2018/7/9.
 */
public abstract class Mediator {

    public abstract void sendToAll(String message, MakeFriendPerson sendPerson);

    public abstract void notify(String message, MakeFriendPerson person);

    public abstract void register(MakeFriendPerson person);

    public static void main(String[] args) {
        Mediator mediator = new HomosexualMediator();

        MakeFriendPerson p1 = new HomosexualMakeFriendPerson(mediator, "yaochao", Sex.MAN);

        MakeFriendPerson p2 = new HomosexualMakeFriendPerson(mediator, "搞基之王", Sex.MAN);

        MakeFriendPerson p3 = new HomosexualMakeFriendPerson(mediator, "同性爱好者", Sex.MAN);

        MakeFriendPerson p4 = new HomosexualMakeFriendPerson(mediator, "女同性爱好者", Sex.WOMEN);

        p1.send("I need a man", p2);

        p1.send("I need a man", p3);

        p1.sendToAll("I am yaochao,I need a person");


    }
}

class HomosexualMediator extends Mediator {
    private List<MakeFriendPerson> persons;

    public HomosexualMediator() {
        this.persons = new ArrayList<>();
    }

    @Override
    public void sendToAll(String message, MakeFriendPerson sendPerson) {
        persons.stream().filter((makeFriendPerson) -> !sendPerson.equals(makeFriendPerson))
                .forEach((makeFriendPerson -> makeFriendPerson.receive(message)));

    }

    @Override
    public void notify(String message, MakeFriendPerson person) {

        persons.stream().filter((makeFriendPerson) -> person.equals(makeFriendPerson) && makeFriendPerson.getSex().equals(Sex.MAN))
                .forEach((makeFriendPerson -> makeFriendPerson.receive(message)));

    }

    @Override
    public void register(MakeFriendPerson person) {
        persons.add(person);
    }

}


abstract class MakeFriendPerson {
    protected Mediator mediator;
    private String name;
    private Sex sex;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public MakeFriendPerson(Mediator mediator, String name, Sex sex) {
        this.mediator = mediator;
        this.name = name;
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MakeFriendPerson that = (MakeFriendPerson) o;

        if (mediator != null ? !mediator.equals(that.mediator) : that.mediator != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return sex == that.sex;
    }

    @Override
    public int hashCode() {
        int result = mediator != null ? mediator.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        return result;
    }

    public void send(String message, MakeFriendPerson person) {
        mediator.notify(message, person);
    }

    public void receive(String messaeg) {
        System.out.println(name + " receive messaeg  " + messaeg);
    }

    public void sendToAll(String messaeg) {
        mediator.sendToAll(messaeg, this);
    }
}


class HomosexualMakeFriendPerson extends MakeFriendPerson {

    public HomosexualMakeFriendPerson(Mediator mediator, String name, Sex sex) {
        super(mediator, name, sex);
        mediator.register(this);
    }
}


enum Sex {
    MAN, WOMEN;
}