package com.example.classbjunit.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.classbjunit.model.Item;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

	@Autowired
	private ItemRepository itemRepository;
	
	@Test
	public void findAll_success () {
		List<Item> items = itemRepository.findAll();
		assertEquals(4, items.size());
	}
	
	@Test
	public void findOne_success() throws JSONException {
		Optional<Item> itemOption = itemRepository.findById(101);
		assertTrue(itemOption.isPresent());
		
		/*JSONObject expected = null;
		expected.put("id",101);
		expected.put("name","Item1");
		expected.put("price",10);
		expected.put("quantity",100);
		*/
		//JSONAssert.assertEquals(expected, new JSONObject(itemOption.get()), true);
	}
	
}
