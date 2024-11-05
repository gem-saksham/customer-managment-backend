package CustomerDatabaseManagement.repository;

import CustomerDatabaseManagement.entity.CustomerContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerContactRepository extends JpaRepository<CustomerContact, Integer> {
    Optional<CustomerContact> findByOfficialEmail(String officialEmail);
    List<CustomerContact> findByCustomerId(Long customerId);

    Optional<CustomerContact> findByCustomerContactID(Long ContactId);
}
