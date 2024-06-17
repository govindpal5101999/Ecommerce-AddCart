package ecommerce.Ecommerce;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface cartRepository extends JpaRepository<cartModel, Integer> {

	
}
