package demo.wangjq.base.reflect;

import demo.wangjq.base.reference.PhantomReferenceTest;

/**
 * @author:wangjq
 * @Date: 2019/7/26 16:53
 */
public class PointJoinTest {

    public static void main(String[] args) {


        String canonicalName = PhantomReferenceTest.class.getCanonicalName();

        System.out.println(canonicalName);

        //ReflectiveMethodInvocation reflectiveMethodInvocation = new ReflectiveMethodInvocation();
    }

}
