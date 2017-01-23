package org.tgo.jpa.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.tgo.jpa.model.people.Actor;

@Stateless
public class ActorService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Actor> getAllActors() {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Actor> cq = cb.createQuery(Actor.class);
        Root<Actor> actorRoot = cq.from(Actor.class);
        cq.select(actorRoot);
        TypedQuery<Actor> typedQuery = entityManager.createQuery(cq);
        List<Actor> resultList = typedQuery.getResultList();
        return resultList;
    }

}
