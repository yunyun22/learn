package demo.wangjq.base.designpattern;

import java.util.List;

/**
 * Created by wangjq on 2018/7/6.
 */
public interface ArmyBuilder {

    void buildHead();

    void buildCommissar();

    void buildSoldiers();

    Army getArmy();
}


class Army {
    private String head;
    private String commissar;
    private List<?> soldiers;


    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getCommissar() {
        return commissar;
    }

    public void setCommissar(String commissar) {
        this.commissar = commissar;
    }

    public List<?> getSoldiers() {
        return soldiers;
    }

    public void setSoldiers(List<?> soldiers) {
        this.soldiers = soldiers;
    }
}

class Group {

    public void OrganizationArmy(ArmyBuilder armyBuilder) {
        armyBuilder.buildHead();
        armyBuilder.buildCommissar();
        armyBuilder.buildSoldiers();
    }

    public static void main(String[] args) {
        Group g = new Group();
        ArmyBuilder armyBuilder = new RedArmyBuilder();
        g.OrganizationArmy(armyBuilder);
        armyBuilder.getArmy();
    }
}


class RedArmyBuilder implements ArmyBuilder {

    private Army army = new Army();

    @Override
    public void buildHead() {
        System.out.println("以毛爷爷为首脑");
        army.setHead("mao");
    }

    @Override
    public void buildCommissar() {
        System.out.println("毛爷爷在就不用政委了");
        army.setCommissar(null);
    }

    @Override
    public void buildSoldiers() {
        System.out.println("召集工人");
        army.setSoldiers(null);
    }

    @Override
    public Army getArmy() {
        return army;
    }
}