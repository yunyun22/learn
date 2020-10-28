package demo.wangjq.base.reference;

import java.util.concurrent.TimeUnit;
import sun.misc.Cleaner;

/**
 * @author jinqwang
 */
public class PhantomReferenceTest {


	public static void main(String[] args) throws InterruptedException {


		Cleaner cleaner = Cleaner.create(new Byte[1024 * 1024 * 16], () -> {
			System.out.println("清理其数据");
		});
		Byte[] bytes2 = new Byte[1024 * 1024 * 16];
		TimeUnit.SECONDS.sleep(5);
		System.gc();

		System.out.println("我去");

	}
}
