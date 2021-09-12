package de.simpe.stock;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StockRepository implements PanacheRepository<HistoricalStockEntity> {

}

