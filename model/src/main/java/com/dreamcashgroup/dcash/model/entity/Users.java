package com.dreamcashgroup.dcash.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Users extends Model{

    @Column(unique = true)
    private String username;
    private String password;
    private boolean active;

    @ManyToMany(targetEntity = Roles.class, fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles = new HashSet<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    // Ajout et retrait des rôles à l'utilisateur
    public void addRole(Roles role) {
        getRoles().add(role);
    }

    public void removeRole(Roles role) {
        getRoles().remove(role);
    }

    /**
     * Vérifier si un utilisateur est un administrateur
     * @return
     */
    public boolean isAdmin(){
        return this.getRoles().stream()
                .anyMatch(role -> role.getRoleName().equals("ADMIN"));
    }
}
