package hellojpa;

import javax.persistence.*;

//@Entity
@Table(name = "Member")
public class Member3 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //AUTO : DB 방언에 따라 자동으로 값을 생성
    //IDENTITY : 기본키 생성을 데이터베이스에 위임 (Sequence, auto_increment)
    private String id;

    @Column(name = "name", nullable = false)
    private String username;

    public Member3() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
