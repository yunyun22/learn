//package demo.wangjq.btrace;
//
//import com.sun.btrace.annotations.BTrace;
//import com.sun.btrace.annotations.Kind;
//import com.sun.btrace.annotations.Location;
//import com.sun.btrace.annotations.OnMethod;
//import com.sun.btrace.annotations.ProbeClassName;
//import com.sun.btrace.annotations.ProbeMethodName;
//
//import static com.sun.btrace.BTraceUtils.*;
//
///**
// * Created by wangjq on 2018/10/25.
// */
//@BTrace
//public class BtraceTest {
//
//    @OnMethod(
//            clazz = "demo.wangjq.Application",
//            method = "getJson",
//            location = @Location(value = Kind.LINE, line = -1)
//    )
//    public static void online(@ProbeClassName String pcn, @ProbeMethodName String pmn, int line) {
//        println(pcn + "." + pmn + ":" + line);
//    }
//
//}
