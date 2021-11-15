package demo.wangjq.base.rx;

import rx.Observable;
import rx.Observer;

/**
 * @author:wangjq
 * @Date: 2019/8/30 11:04
 */
public class App {

    public static void main(String[] args) {
        App app = new App();

        app.doExecute();
    }

    public void doExecute() {
        //声明一个观察者，用来响应被观察者发布的事件
        Observer<String> observer = new Observer<String>() {
            /**
             * 被观察者发布结束事件的时候，该方法会被调用
             */
            @Override
            public void onCompleted() {
                System.out.println("start onCompleted");
            }

            /**
             * 被观察者发布事件期间，和观察者处理事件期间，发生异常的时候，该方法都会被调用
             */
            @Override
            public void onError(Throwable throwable) {
                System.out.println("start onError : " + throwable);
            }

            /**
             * 被观察者发布事件后，该方法会被调用
             * @param s
             */
            @Override
            public void onNext(String s) {
                System.out.println("start onNext [" + s + "]");
            }
        };

        Observable<String> observable = Observable.create(subscriber -> {
            //向观察者发布事件
            subscriber.onNext("Hello");
            //再次向观察者发布事件
            subscriber.onNext("world");
            //通知观察者，订阅结束
            subscriber.onCompleted();
        });
        System.out.println("try subscribe");
        //执行订阅
        observable.subscribe(observer);

        System.out.println("finish doExecute");

    }
}
