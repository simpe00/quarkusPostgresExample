package org.acme.stock;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Currency;

@Entity(name = "HISTORICAL_STOCK")
@Builder
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class HistoricalStockEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String symbol;
    private Currency currency;
    private OffsetDateTime stockDate;
    private BigDecimal open;
    private BigDecimal low;
    private BigDecimal high;
    private BigDecimal close;
}

