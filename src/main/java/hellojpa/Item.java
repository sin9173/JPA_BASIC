package hellojpa;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) //JOINED : 테이블을 분할해서 조인하는 방식, SINGLE : 한 테이블에 모든 컬럼을 넣는 방식
@DiscriminatorColumn //DTYPE 을 지정
public abstract class Item {
    @Id @GeneratedValue
    private Long id;

    private String name;

    private int price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
