package com.allianz.example230821.database.entity;

import com.allianz.example230821.util.dbutil.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column
    private String username;
    @Column
    private String firstName;
    @Column
    private String lastName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column
    private String photoLink;
    @Column
    private boolean isEnable;


    /*@JoinTable(name = "user_group",joinColumns = @JoinColumn(name="user_id"))
    @JoinColumn(name = "group_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Group> group;*/


    @ManyToMany(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinColumn(name = "role_id", nullable = false)
    private Set<RoleEntity> roles;

    {

    }

    public UserEntity() {
        isEnable = false;
    }
}
