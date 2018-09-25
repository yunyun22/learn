package demo.wangjq.collection;

/**
 * Created by wangjq on 2018/7/30.
 */
public class Apple {

    private Integer seqNo;
    private String country;
    private Integer wight;

    public Integer getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getWight() {
        return wight;
    }

    public void setWight(Integer wight) {
        this.wight = wight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "seqNo=" + seqNo +
                ", country='" + country + '\'' +
                ", wight=" + wight +
                '}';
    }
}
