package demo.wangjq.designPattern;

/**
 * Created by wangjq on 2018/7/10.
 */
public class ChainClient {


    public static void main(String[] args) {
        User user = new User(1600, "wangjq");

        Division d0 = new ChallengerDivision(null);
        Division d1 = new DiamondDivision(d0);
        Division d2 = new PlatnumDivision(d1);
        Division d3 = new GoldDivision(d2);
        Division d4 = new SilverDivision(d3);
        Division d5 = new BronzeDivision(d4);

        d5.dealChain(user);

    }

}

class User {
    private int grade;
    private String name;


    public User(int grade, String name) {
        this.grade = grade;
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

interface Chain {
    int order();

    Chain next();

    Grade getGrade();

    void dealChain(User user);
}

enum Grade {
    CHALLENGER(2200, "王者"), DIAMOND(2100, "砖石"), PLATNUM(2000, "铂金"), GOLD(1900, "黄金"), SILVER(1800, "白银"), BRONZE(1700, "青铜");

    private int value;
    private String name;

    Grade(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}

abstract class Division implements Chain {
    protected Chain chain;
    protected Grade grade;


    public Division(Chain chain, Grade grade) {
        this.chain = chain;
        this.grade = grade;
    }

    public int order() {
        return grade.getValue();
    }

    public Chain next() {
        return chain;
    }

    public Grade getGrade() {
        return grade;
    }

    public void dealChain(User user) {
        if (chain == null) {
            System.out.println("name:" + user.getName() + ",段位为:" + grade.name());
            return;
        }
        if (user.getGrade() >= chain.getGrade().getValue()) {
            chain.dealChain(user);
        } else {
            System.out.println("name:" + user.getName() + ",段位为:" + grade.name());
        }


    }
}

class ChallengerDivision extends Division implements Chain {

    public ChallengerDivision(Chain chain) {
        super(chain, Grade.CHALLENGER);
    }

}

class DiamondDivision extends Division implements Chain {

    public DiamondDivision(Chain chain) {
        super(chain, Grade.DIAMOND);
    }


}

class PlatnumDivision extends Division implements Chain {

    public PlatnumDivision(Chain chain) {
        super(chain, Grade.PLATNUM);
    }

}

class GoldDivision extends Division implements Chain {

    public GoldDivision(Chain chain) {
        super(chain, Grade.GOLD);
    }
}

class SilverDivision extends Division implements Chain {

    public SilverDivision(Chain chain) {
        super(chain, Grade.SILVER);
    }
}

class BronzeDivision extends Division implements Chain {

    public BronzeDivision(Chain chain) {
        super(chain, Grade.BRONZE);
    }

}




