package demo.wangjq.base.generic;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wang, jinqiao
 * @date 15/04/2021
 */
public class GenericTest {

    public static void main(String[] args) {


        List<? extends String> list = new ArrayList<>();


        TypeVariable<? extends Class<? extends List>>[] typeParameters = list.getClass().getTypeParameters();


        for (TypeVariable<? extends Class<? extends List>> typeVariable : typeParameters) {

            Type[] bounds = typeVariable.getBounds();

            for (Type type : bounds) {
                System.out.println(type);
            }
        }


    }
}
