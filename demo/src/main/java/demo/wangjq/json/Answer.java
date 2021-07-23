
package demo.wangjq.json;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Answer {

    private String answerEn;
    private String answerCn;
    private Boolean needInput;
    private String placeholder;
    private Object otherInputValue;
    private String note;

    public String getAnswerEn() {
        return answerEn;
    }

    public void setAnswerEn(String answerEn) {
        this.answerEn = answerEn;
    }

    public String getAnswerCn() {
        return answerCn;
    }

    public void setAnswerCn(String answerCn) {
        this.answerCn = answerCn;
    }

    public Boolean getNeedInput() {
        return needInput;
    }

    public void setNeedInput(Boolean needInput) {
        this.needInput = needInput;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public Object getOtherInputValue() {
        return otherInputValue;
    }

    public void setOtherInputValue(Object otherInputValue) {
        this.otherInputValue = otherInputValue;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }



}
