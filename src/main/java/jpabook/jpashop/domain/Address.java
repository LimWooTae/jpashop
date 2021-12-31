package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {
	// 값 타입은 setter를 제공하지 않는다. 초기 설정한 값을 바꿀 수 없다.
	private String city;
	private String street;
	private String zipcode;

	protected Address(){
	}

	public Address(String city, String street, String zipcode){
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
	}
}
