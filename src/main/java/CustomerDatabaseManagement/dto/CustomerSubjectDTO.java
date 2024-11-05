package CustomerDatabaseManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSubjectDTO {
    private Long customerId;
    private Long customerSubjectID;
    private String subjectName;
    private String subjectNameSubCategory;
}
