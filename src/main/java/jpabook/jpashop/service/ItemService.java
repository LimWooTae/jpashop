package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

	private final ItemRepository itemRepository;

	@Transactional
	public void saveItem(Item item){
		itemRepository.save(item);
	}

	@Transactional
	public void updateItem(Long itemId, String name, int price, int stockQuantity){
		//Repository에서 find하면 영속성컨텍스트가 관리하는 엔티티를 가져온다.
		Item findItem = itemRepository.findOne(itemId);
		findItem.setName(name);
		findItem.setPrice(price);
		findItem.setStockQuantity(stockQuantity);
		//때문에 save를 호출하지 않아도 commit할때 변경감지를 해서 바꿔준다.
	}

	public List<Item> findItems(){
		return itemRepository.findAll();
	}

	public Item findOne(Long itemId){
		return itemRepository.findOne(itemId);
	}
}
