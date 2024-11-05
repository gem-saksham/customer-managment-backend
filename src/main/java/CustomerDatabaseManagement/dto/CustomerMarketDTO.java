package CustomerDatabaseManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerMarketDTO {
    private Long customerId;
    private Long customerMarketID;
    private String customerMarket;
    private String customerMarketSubCategory;
}
