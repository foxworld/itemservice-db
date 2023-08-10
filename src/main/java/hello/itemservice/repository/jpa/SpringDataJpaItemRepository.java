package hello.itemservice.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hello.itemservice.domain.Item;

public interface SpringDataJpaItemRepository extends JpaRepository<Item, Long> {
	List<Item> findByItemNameLike(String itemName);

	List<Item> findByPriceLessThanEqual(Integer price);
	
	//쿼리메서드
	List<Item> findByItemNameLikeAndPriceLessThanEqual(String itemName, Integer price);
	           	
	//커리직접실행
	@Query("select i from Item i where i.itemName like :itemName and i.price <= :price")
	List<Item> findItems(@Param("itemName") String itemName, @Param("price") Integer price);
	
}
