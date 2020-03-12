package ru.vlsu.animalSpecification.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "auth")
public class Authority  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_role")
    private String userRole;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authority authority = (Authority) o;
        return Objects.equals(id, authority.id) &&
                Objects.equals(userId, authority.userId) &&
                Objects.equals(userRole, authority.userRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, userRole);
    }

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", userId=" + userId +
                ", userRole='" + userRole + '\'' +
                '}';
    }
}
