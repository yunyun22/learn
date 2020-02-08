package demo.wangjq.app.domain;

import com.sun.org.glassfish.gmbal.ManagedData;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author wangjq
 */
public class QuestionTemplate {

    private String id;

    private String templateName;

    private List<Question> questions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
