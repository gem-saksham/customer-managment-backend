package CustomerDatabaseManagement.repository;

import CustomerDatabaseManagement.entity.CustomerContact;
import CustomerDatabaseManagement.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Integer> {
    Optional<CustomerOrder> findByCustomerIdAndProductName(Long customerId, String productName);

    List<CustomerOrder> findByCustomerId(Long customerId);
}

