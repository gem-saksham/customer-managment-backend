package CustomerDatabaseManagement.entity;

import CustomerDatabaseManagement.Auditable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrder extends Auditable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customerOrderID")
    private Long customerOrderID;


    @Column(name = "customerId")
    private Long customerId;

    @Column(name = "productName")
    private String productName;

    @Column(name = "value")
    private String value;

    @Column(name="orderDate")
    private Date orderDate;




}
