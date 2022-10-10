package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

//@Entity
@Table(name = "Member")
public class Member2 {

    @Id
    private Long id;

    @Column(name = "name")
    private String username; //실제 컬럼명이 name 이고 객체에서의 변수명이 username인 경우
    //name : 필드와 매핑할 테이블의 컬럼명
    //insertable, updatable : 등록, 변경 가능 여부 (기본값 TRUE)
    //nullable(DDL) : null 값의 허용여부를 설정 (DDL 생성시에 적용)
    //unique(DDL) : 한 컬럼에 유니크 제약조건을 설정 (DDL 생성시에 적용)
    //columnDefinition(DDL) : 데이터베이스 컬럼 정보를 직접 부여 (DDL 생성시에 적용) ex) varchar(100) default 'EMPTY'
    //length(DDL) : 문자 길이 제약조건, String 타입에만 사용 (DDL 생성시에 적용, 기본값 255)
    //precision, scale(DDL) :
    // - BigDecimal 타입에서 사용(BigInteger 도 사용가능)
    // - precision 은 소수점을 포함한 전체 자릿수를, scale 은 소수의 자릿수다.
    // - double, float 타입에는 적용되지 않음
    // - 정밀한 소수를 다루어야할 때 사용

    private Integer age;

    //ORDINAL : enum 순서를 데이터베이스에 저장
    //STRING : enum 이름을 데이터베이스에 저장
    // 기본 : ORDINAL
    // ORDINAL 은 enum 클래스 수정시 변경될 수 있기 때문에 쓰지 않는게 좋음
    @Enumerated(EnumType.STRING)
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

    //타입이 문자일 경우 clob 으로, 그외일 경우 blob 으로 매핑
    @Lob
    private String description;

    @Transient //db에 반영하지 않음
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
