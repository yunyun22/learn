package demo.wangjq.designpattern;

/**
 * Created by wangjq on 2018/7/12.
 */
public class StrategyTest {

    public static void main(String[] args) {

        BasktbllShotStrategy basktbllShotStrategy = new TallManShotStrategy();

        Context context = new BasktbllShotContext(basktbllShotStrategy);

        context.execute();
    }
}

interface Context {
    void execute();
}

class BasktbllShotContext implements Context {

    private BasktbllShotStrategy basktbllShotStrategy;

    public BasktbllShotContext(BasktbllShotStrategy basktbllShotStrategy) {
        this.basktbllShotStrategy = basktbllShotStrategy;
    }

    @Override
    public void execute() {
        basktbllShotStrategy.shoting();
    }
}


interface BasktbllShotStrategy {
    void shoting();
}

class TallManShotStrategy implements BasktbllShotStrategy {
    @Override
    public void shoting() {
        System.out.println("投篮");
    }
}

class ShortManShotStrategy implements BasktbllShotStrategy {
    @Override
    public void shoting() {
        System.out.println("突破");
    }
}
