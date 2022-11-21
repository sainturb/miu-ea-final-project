package miu.edu.repository.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import miu.edu.model.Director;
import miu.edu.repository.dao.DirectorDAO;

@Component
@RequiredArgsConstructor
public class DirectorDAOImpl implements DirectorDAO {

    private final EntityManager em;

    @Override
    public List<Director> findDirectorByFirstOrLastName(String name) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Director> cq = cb.createQuery(Director.class);
        Root<Director> from = cq.from(Director.class);
        cq.select(from);

        Expression<String> exp1 = cb.concat(from.<String>get("firstName"), " ");
        exp1 = cb.concat(exp1, from.<String>get("lastName"));
        Expression<String> exp2 = cb.concat(from.<String>get("lastName"), " ");
        exp2 = cb.concat(exp2, from.<String>get("firstName"));
        Predicate whereClause = cb.or(cb.like(exp1, "%" + name + "%"), cb.like(exp2, "%" + name + "%"));

        cq.where(whereClause);
        TypedQuery<Director> query = em.createQuery(cq);

        return query.getResultList();

    }

}
