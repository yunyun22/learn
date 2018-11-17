package demo.wangjq.designpattern;

import java.util.List;

/**
 * Created by wangjq on 2018/7/9.
 */

class XiaoMiPhone implements Cloneable {

    private String version;
    private List<String> program;


    @Override
    protected XiaoMiPhone clone() throws CloneNotSupportedException {

        return (XiaoMiPhone) super.clone();
    }


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<String> getProgram() {
        return program;
    }

    public void setProgram(List<String> program) {
        this.program = program;
    }


    @Override
    public String toString() {
        return "XiaoMiPhone{" +
                "version='" + version + '\'' +
                ", program=" + program +
                '}';
    }
}

