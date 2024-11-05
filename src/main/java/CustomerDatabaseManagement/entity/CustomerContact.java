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
public class CustomerContact extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customerContactID")
    private Long customerContactID;
    @Column(name = "customerId")
    private Long customerId;
    @Column(name = "customerName")
    private String customerName;
    @Column(name = "salutation")
    private String salutation ;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "middleName")
    private String middleName;
    @Column(name = "designation")
    private String designation;

    @Column(name="role")
    private String role;

    @Column(name = "emailAddressOne")
    private String emailAddressOne;

    @Column(name = "emailAddressTwo")
    private String emailAddressTwo;
    @Column(name = "officialEmail")
    private String officialEmail;

    @Column(name = "mobileOne")
    private String mobileOne;

    @Column(name = "mobileTwo")
    private String mobileTwo;
    @Column(name = "skypeId")
    private String skypeId;

    @Column(name = "linkedInLink")
    private String  linkedInLink;

    @Column(name = "dateOfBirth")
    private String dateOfBirth;


    @Column(name = "contactSubjectKeyword")
    private String contactSubjectKeyword;


}
