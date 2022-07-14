package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {

	@Id @GeneratedValue
	@Column(name = "delivery_id")
	private Long id;

	@JsonIgnore
	@OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
	private Order order;

	@Embedded
	private Address address;

	@Enumerated(EnumType.STRING) // ORDINAL은 숫자로 저장되기때문에, 중간에 이넘가밧이 추가되면 꼬인다.
	private DeliveryStatus status; // READY, COMP
}
