package CustomerDatabaseManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrderDTO {
    private Long customerId;
    private Long customerOrderID;
    private String productName;
    private String value;
    private Date orderDate;
}
