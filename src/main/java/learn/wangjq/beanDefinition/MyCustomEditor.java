package learn.wangjq.beanDefinition;

import java.beans.PropertyEditorSupport;

public class MyCustomEditor extends PropertyEditorSupport {

    public void setAsText(String text) {
        System.out.println("text = " + text);
        setValue("hello world");
    }
}
