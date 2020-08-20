package pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 * 班级 User:UserInfo 1:1
 */
public class UserInfo {

    private Integer id;
    private Integer user_id;
    private String card;
    private LocalDate birth_date;

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", card='" + card + '\'' +
                ", birth_date=" + birth_date +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }
}
