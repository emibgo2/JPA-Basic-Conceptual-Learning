package hellojpa.jpashop;

import javax.persistence.*;

@Entity
public class Delivery  extends BaseEntity{
    @Id @GeneratedValue
    private Long id;

    private String city;
    private String street;
    private String zipcode;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    @OneToOne(fetch = FetchType.LAZY ,mappedBy = "delivery")
    private Order order;

}
