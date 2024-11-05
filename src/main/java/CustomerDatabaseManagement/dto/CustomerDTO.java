package CustomerDatabaseManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private Long customerId;
    private String customerName;
    private String customerAbbreviation;
    private String addressOne;
    private String addressTwo;
    private String addressThree;
    private String city;
    private String state;
    private String country;
    private String officialEmail;
    private String landLineOne;
    private String landLineTwo;
    private String fax;
    private String website;
    private String gstNo;
    private String panNo;
    private String customerType;
    private String twitterLink;
    private String skypeId;
    private String faceBookLink;
    private String linkedInLink;
}
