package CustomerDatabaseManagement.entity;


import CustomerDatabaseManagement.Auditable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSubject extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customerSubjectID")
    private Long customerSubjectID;

    @Column(name = "customerId")
    private Long customerId;

    @Column(name = "subjectName")
    private String subjectName;

    @Column(name= "subjectNameSubCategory")
    private  String subjectNameSubCategory;

}
