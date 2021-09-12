package de.simpe.rest;

import de.simpe.stock.HistoricalStockEntity;
import de.simpe.stock.StockRepository;
import lombok.AllArgsConstructor;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/rest/stock")
@AllArgsConstructor(onConstructor = @__(@Inject))
public class StockRest {

    private final StockRepository stockRepository;

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<HistoricalStockEntity> stocks() {
        return stockRepository.findAll().list();
    }
}
