package CustomerDatabaseManagement.repository;

import CustomerDatabaseManagement.entity.CustomerContact;
import CustomerDatabaseManagement.entity.CustomerMarket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerMarketRepository extends JpaRepository<CustomerMarket, Integer> {
    Optional<CustomerMarket> findByCustomerIdAndCustomerMarketAndCustomerMarketSubCategory(Long customerId, String customerMarket,
                                                                              String customerMarketSubCategory);

    List<CustomerMarket> findByCustomerId(Long customerId);
}

