package CustomerDatabaseManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerContactDTO {
    private Long customerId;
    private Long customerContactID;
    private String customerName;
    private String salutation;
    private String firstName;
    private String lastName;
    private String middleName;
    private String designation;
    private String role;
    private String roleInput;
    private String emailAddressOne;
    private String emailAddressTwo;
    private String officialEmail;
    private String mobileOne;
    private String mobileTwo;
    private String skypeId;
    private String linkedInLink;
    private String dateOfBirth;
    private String contactSubjectKeyword;
}

