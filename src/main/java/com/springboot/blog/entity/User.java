package com.springboot.blog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    /*
    Inside the JoinTable the name = user_roles this is the 3rd table which will be created by default by jpa
    soo and in the joinColumns we will pass the user_id that is the id of out User class
    soo in the inverseJoinColumns we have used the primary key of another table.
    => If we are doing this in the roles table we will do in the inverse
        But the JoinTable name = user_roles must be same
        but in the joinColumns we will use role_id and in the inverseJoinColumns we
        will use user_id
     */

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="users_roles",
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id")
    )
    private Set<Role> roles;
}
