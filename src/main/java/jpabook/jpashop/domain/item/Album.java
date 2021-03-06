package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A") // 구분할 이름을 지정해준다.
@Getter @Setter
public class Album extends Item {

	private String artist;
	private String etc;
}
