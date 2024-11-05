package CustomerDatabaseManagement.repository;

import CustomerDatabaseManagement.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> { // Change Integer to Long if necessary
    Optional<Customer> findByCustomerNameOrOfficialEmailOrGstNo(String customerName, String officialEmail, String gstNo);

    Page<Customer> findByCustomerNameContainingOrOfficialEmailContainingOrCustomerAbbreviationContainingOrStateContainingOrCountryContainingOrCityContaining(String customerName, String officialEmail, String customerAbbreviation , String state, String country, String city ,  Pageable pageable);
}
