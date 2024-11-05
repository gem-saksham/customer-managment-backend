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
public class CustomerMarket extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customerMarketID")
    private Long customerMarketID;

    @Column(name = "customerId")
    private Long customerId;
    @Column(name = "customerMarket")
    private String customerMarket;
    @Column(name = "customerMarketSubCategory")
    private String customerMarketSubCategory;





}
