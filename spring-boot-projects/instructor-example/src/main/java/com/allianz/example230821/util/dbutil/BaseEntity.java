package com.allianz.example230821.util.dbutil;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;
import java.util.UUID;


@MappedSuperclass
@Data
@EntityListeners({AuditingEntityListener.class})
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @JdbcTypeCode(java.sql.Types.VARCHAR)
    private UUID uuid;

    @CreatedDate
    private Date creationDate;

    @LastModifiedDate
    private Date updatedDate;

    @CreatedBy
    private String createdBy;


    @PrePersist
    protected void onCreate() {
        setUuid(UUID.randomUUID());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = "";
        if (authentication == null || !authentication.isAuthenticated()) {
            username = "anonymous";
        } else {
            username = authentication.getPrincipal().toString();
        }

        setCreatedBy(username);

    }


}
