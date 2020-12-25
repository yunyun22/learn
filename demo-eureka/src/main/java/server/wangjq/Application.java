package server.wangjq;



import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;

/**
 * @author wangjq
 */
public class Application {


    public static void main(String[] args) {

        Domain domain = new Domain();
        domain.setName("name");
        try {
            doConsume(domain::getCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void doConsume(SerializableSupplier<String> consumer) throws Exception {
        Method writeReplace = consumer.getClass().getDeclaredMethod("writeReplace");
        writeReplace.setAccessible(true);
        Object sl = writeReplace.invoke(consumer);

        SerializedLambda serializedLambda = (SerializedLambda) sl;
        String implMethodName = serializedLambda.getImplMethodName();
        Object capturedArg = serializedLambda.getCapturedArg(0);
        System.out.println(implMethodName);
        System.out.println(serializedLambda);
    }

}
interface SerializableSupplier<T> extends Serializable {
    T get();
}