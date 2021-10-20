package group.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Withdraw")
public class Withdraw {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long customerId;
    private BigDecimal transactionAmount;

    public Withdraw(Long id, Long customerId,
                    BigDecimal transactionAmount) {
        this.id = id;
        this.customerId = customerId;
        this.transactionAmount = transactionAmount;
    }

    public Withdraw(Long customerId, BigDecimal transactionAmount) {
        this.customerId = customerId;
        this.transactionAmount = transactionAmount;
    }

    public Withdraw() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
