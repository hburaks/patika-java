package com.allianz.example230821.util;

import com.allianz.example230821.util.dbutil.BaseEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseSpecification<Entity extends BaseEntity> implements Specification<Entity> {

    private List<SearchCriteria> criteriaList;

    public List<SearchCriteria> getCriteriaList() {
        return criteriaList;
    }

    public void setCriteriaList(List<SearchCriteria> criteriaList) {
        this.criteriaList = criteriaList;
    }

    @Override
    public Predicate toPredicate(Root<Entity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();

        for (SearchCriteria criteria : criteriaList) {

            Predicate predicate = null;

            if (criteria.getOperation().equalsIgnoreCase(">")) {
                predicate = criteriaBuilder.greaterThan(root.<String>get(criteria.getKey()), criteria.getValue().toString());
            } else if (criteria.getOperation().equalsIgnoreCase("<")) {
                predicate = criteriaBuilder.lessThan(root.<String>get(criteria.getKey()), criteria.getValue().toString());
            } else if (criteria.getOperation().equalsIgnoreCase(">=")) {
                predicate = criteriaBuilder.greaterThanOrEqualTo(root.<String>get(criteria.getKey()), criteria.getValue().toString());
            } else if (criteria.getOperation().equalsIgnoreCase("<=")) {
                predicate = criteriaBuilder.lessThanOrEqualTo(root.<String>get(criteria.getKey()), criteria.getValue().toString());
            } else if (criteria.getOperation().equalsIgnoreCase("=")) {
                predicate = criteriaBuilder.equal(root.<String>get(criteria.getKey()), criteria.getValue().toString());
            } else if (criteria.getOperation().equalsIgnoreCase(":")) {
                if (root.get(criteria.getKey()).getJavaType() == String.class) {
                    predicate = criteriaBuilder.like(criteriaBuilder.lower(root.<String>get(criteria.getKey())), "%" + criteria.getValue().toString().toLowerCase() + "%");
                } else {
                    predicate = criteriaBuilder.equal(root.<String>get(criteria.getKey()), criteria.getValue().toString());
                }
            } else {
                continue;
            }

            predicates.add(predicate);

        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
