
package demo.wangjq.json;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private String type;
    private Boolean required;
    private String questionEn;
    private String questionCn;
    private List<Answer> answers = new ArrayList<Answer>();
    private String otherInputValue;
    private String note;
    private String answerValue;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public String getQuestionEn() {
        return questionEn;
    }

    public void setQuestionEn(String questionEn) {
        this.questionEn = questionEn;
    }

    public String getQuestionCn() {
        return questionCn;
    }

    public void setQuestionCn(String questionCn) {
        this.questionCn = questionCn;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public String getOtherInputValue() {
        return otherInputValue;
    }

    public void setOtherInputValue(String otherInputValue) {
        this.otherInputValue = otherInputValue;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAnswerValue() {
        return answerValue;
    }

    public void setAnswerValue(String answerValue) {
        this.answerValue = answerValue;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }



}
