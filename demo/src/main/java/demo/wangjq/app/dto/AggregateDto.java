package demo.wangjq.app.dto;

/**
 * @author wangjq
 */
public class AggregateDto {

    private String _id;

    private String count;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "AggregateDto{" +
                "_id='" + _id + '\'' +
                ", count='" + count + '\'' +
                '}';
    }
}
