package demo.wangjq.app.beandefinition;

import java.beans.PropertyEditorSupport;

/**
 * @author jinqwang
 */
public class MyCustomEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) {
        System.out.println("text = " + text);
        setValue("hello world");
    }
}
