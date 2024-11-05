package CustomerDatabaseManagement.repository;

import CustomerDatabaseManagement.entity.CustomerMarket;
import CustomerDatabaseManagement.entity.CustomerSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerSubjectRepository extends JpaRepository<CustomerSubject, Integer> {
    Optional<CustomerSubject> findByCustomerIdAndSubjectNameAndSubjectNameSubCategory(Long customerId, String subjectName, String subjectNameSubCategory);

    List<CustomerSubject> findByCustomerId(Long customerId);
}
