package demo.wangjq.base.annotation;

import java.io.Serializable;

/**
 * @author wangjq
 */
public class User implements Serializable {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Builder builder() {
        return new Builder(this);
    }

    public static class Builder {
        private User user;

        public Builder(User user) {
            this.user = user;
        }

        public User setName(String name) {
            user.setName(name);
            return user;
        }

        public User setId(Integer id) {
            user.setId(id);
            return user;
        }
    }
}
