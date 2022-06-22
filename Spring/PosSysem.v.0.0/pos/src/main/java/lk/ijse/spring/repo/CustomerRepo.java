package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepo  extends JpaRepository<Customer, String> {


    @Query(value = "SELECT CustomerId FROM Customer", nativeQuery =  true)
    public List<String> getAllCustomerIds();

}
