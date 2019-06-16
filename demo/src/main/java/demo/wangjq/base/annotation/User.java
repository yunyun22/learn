package demo.wangjq.base.annotation;

import java.io.Serializable;

/**
 * @author wangjq
 */
public class User implements Serializable {
    private Long id;
    private String name;


    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

        public User setId(Long id) {
            user.setId(id);
            return user;
        }
    }
}
