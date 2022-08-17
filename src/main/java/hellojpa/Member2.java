package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Member")
public class Member2 {

    @Id
    private Long id;

    @Column(name = "name")
    private String username; //실제 컬럼명이 name 이고 객체에서의 변수명이 username인 경우

    private Integer age;

    @Enumerated(EnumType.STRING) //ORDINAL : enum 순서를 데이터베이스에 저장, STRING : enum 이름을 데이터베이스에 저장, 기본 : ORDINAL
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDateTime createDate2;

    public LocalDateTime getCreateDate2() {
        return createDate2;
    }

    public void setCreateDate2(LocalDateTime createDate2) {
        this.createDate2 = createDate2;
    }

    @Lob
    private String description;

    @Transient
    private int temp;

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public Member2() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
