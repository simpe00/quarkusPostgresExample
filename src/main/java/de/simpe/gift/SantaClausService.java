package de.simpe.gift;

import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@ApplicationScoped
public class SantaClausService {
    @Inject
    EntityManager em;

    @Transactional
    public void createGift(String giftDescription) {
        Gift gift = new Gift();
        gift.setName(giftDescription);
        em.persist(gift);
    }

    @Transactional
    public Gift persistGift(Gift gift) {
        Gift persistedGift = em.find(Gift.class, gift.getId());
        if (persistedGift==null){
            log.info("creating new gift");
        } else{
            log.info("updating gift with id: {} old = {}, new = {}", gift.getId(), persistedGift, gift);
        }
        return em.merge(gift);
    }

    public List<Gift> getGifts() {
        return em.createNamedQuery("Gift.findAll", Gift.class).getResultList();
    }
}
