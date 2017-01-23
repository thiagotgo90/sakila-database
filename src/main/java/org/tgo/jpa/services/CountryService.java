package org.tgo.jpa.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import javax.xml.validation.TypeInfoProvider;

import org.tgo.jpa.model.location.City;
import org.tgo.jpa.model.location.Country;

@Stateless
public class CountryService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Country> getAllCountries() {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> cq = cb.createQuery(Country.class);
        Root<Country> root = cq.from(Country.class);
        cq.select(root);
        TypedQuery<Country> typedQuery = entityManager.createQuery(cq);
        List<Country> resultList = typedQuery.getResultList();
        return resultList;
    }

    public List<Country> getAllCountriesAndCities() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> cq = cb.createQuery(Country.class);
        Root<Country> root = cq.from(Country.class);
        cq.select(root);
        Fetch<Country, City> join = root.fetch("cities");
        TypedQuery<Country> typedQuery = entityManager.createQuery(cq);
        typedQuery.setMaxResults(10);
        List<Country> resultList = typedQuery.getResultList();
        return resultList;
    }

    public Country getCountryFetchCities(int countryId) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> cq = cb.createQuery(Country.class);
        Root<Country> root = cq.from(Country.class);
        Fetch<Country, City> fetch = root.fetch("cities");
        cq.select(root).where(cb.equal(root.get("id"),
                cb.parameter(Integer.class, "countryId")));

        TypedQuery<Country> typedQuery = entityManager.createQuery(cq);
        typedQuery.setParameter("countryId", countryId);

        Country country = typedQuery.getSingleResult();

        return country;
    }

    public  List<Country> getCountryWithCityNamed(String cityName) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> criteriaQuery = criteriaBuilder.createQuery(Country.class);
        Root<Country> countryRoot = criteriaQuery.from(Country.class);
        Join<Country, City> citiesJoin = countryRoot.join("cities");
        countryRoot.fetch("cities");
        
        ParameterExpression<String> cityParamter = criteriaBuilder.parameter(String.class, "cityName");
        
        criteriaQuery
            .select(countryRoot)
            .distinct(true)
            .where(criteriaBuilder.equal(citiesJoin.get("name"), cityParamter));
        
        TypedQuery<Country> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setParameter("cityName", cityName);
        
        List<Country> resultList = typedQuery.getResultList();
        
        
        return resultList;
        

    }

}
