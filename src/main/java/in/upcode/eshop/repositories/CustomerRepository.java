package in.upcode.eshop.repositories;

import in.upcode.eshop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


    List<Customer> findByUserName(String username);
}
