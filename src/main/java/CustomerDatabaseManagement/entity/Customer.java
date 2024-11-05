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
public class Customer extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customerId")
    private Long customerId;
    @Column(name = "customerName")
    private String customerName;
    @Column(name = "customerAbbreviation")
    private String customerAbbreviation;
    @Column(name = "AddressOne")
    private String AddressOne;
    @Column(name = "AddressTwo")
    private String AddressTwo;
    @Column(name = "AddressThree")
    private String AddressThree;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "country")
    private String country;
    @Column(name = "officialEmail")
    private String officialEmail;
    @Column(name = "landLineOne")
    private String landLineOne;
    @Column(name = "landLineTwo")
    private String landLineTwo;
    @Column(name = "fax")
    private String fax;
    @Column(name = "website")
    private String  website;
    @Column(name = "gstNo")
    private String gstNo;
    @Column(name = "panNo")
    private String panNo;
    @Column(name = "customerType")
    private String customerType;
    @Column(name = "twitterLink")
    private String twitterLink;
    @Column(name = "skypeId")
    private String skypeId;
    @Column(name = "faceBookLink")
    private String faceBookLink;
    @Column(name = "linkedInLink")
    private String linkedInLink;


}

