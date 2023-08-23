package com.allianz.example230821.database.specification;

import com.allianz.example230821.database.entity.CategoryEntity;
import com.allianz.example230821.database.entity.ProductEntity;
import com.allianz.example230821.util.BaseSpecification;
import com.allianz.example230821.util.SearchCriteria;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductSpecification extends BaseSpecification<ProductEntity> {

    private List<SearchCriteria> criteriaList;

    public List<SearchCriteria> getCriteriaList() {
        return criteriaList;
    }

    public void setCriteriaList(List<SearchCriteria> criteriaList) {
        this.criteriaList = criteriaList;
    }

    @Override
    public Predicate toPredicate(Root<ProductEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        for (SearchCriteria criteria : criteriaList) {

            Predicate predicate = null;

            if (criteria.getOperation().equalsIgnoreCase(">")) {
                predicate = criteriaBuilder.greaterThan(
                        root.<String>get(criteria.getKey()), criteria.getValue().toString());
            } else if (criteria.getOperation().equalsIgnoreCase("<")) {
                predicate = criteriaBuilder.lessThan(
                        root.<String>get(criteria.getKey()), criteria.getValue().toString());
            } else if (criteria.getOperation().equalsIgnoreCase(">=")) {
                predicate = criteriaBuilder.greaterThanOrEqualTo(
                        root.<String>get(criteria.getKey()), criteria.getValue().toString());
            } else if (criteria.getOperation().equalsIgnoreCase("<=")) {
                predicate = criteriaBuilder.lessThanOrEqualTo(
                        root.<String>get(criteria.getKey()), criteria.getValue().toString());
            } else if (criteria.getOperation().equalsIgnoreCase("=")) {
                if (criteria.getKey().equals("category")) {
                    Join<CategoryEntity, ProductEntity> joinCategory = root.join("categoryList");
                    predicate = criteriaBuilder.equal(joinCategory.get("name"), criteria.getValue());
                } else {
                    predicate = criteriaBuilder.equal(
                            root.<String>get(criteria.getKey()), criteria.getValue().toString());
                }
            } else if (criteria.getOperation().equalsIgnoreCase(":")) {
                if (root.get(criteria.getKey()).getJavaType() == String.class) {
                    predicate = criteriaBuilder.like(
                            criteriaBuilder.lower(root.<String>get(criteria.getKey())), "%" +
                                    criteria.getValue().toString().toLowerCase() + "%"
                    );
                } else {
                    predicate = criteriaBuilder.equal(
                            root.<String>get(criteria.getKey()), criteria.getValue().toString());
                }
            } else {
                continue;
            }

            predicates.add(predicate);

        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }


}
