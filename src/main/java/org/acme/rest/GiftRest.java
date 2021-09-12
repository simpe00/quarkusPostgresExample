package org.acme.rest;

import lombok.extern.slf4j.Slf4j;
import org.acme.gift.Gift;
import org.acme.gift.SantaClausService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Slf4j
@Path("/rest")
public class GiftRest {

    @Inject
    SantaClausService santaClausService;


    @POST
    @Path("/saveGift")
    @Produces(MediaType.APPLICATION_JSON)
    public Gift add(Gift gift) {
        log.info("save Gift");
        return santaClausService.persistGift(gift);
    }

    @GET
    @Path("/getGift")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Gift> getGift() {
        log.info("get Gift");
        List<Gift> giftData = santaClausService.getGifts();
        log.info("received gifts: {}", giftData.size());
        return giftData;
    }

}
