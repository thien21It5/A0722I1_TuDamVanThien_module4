package codegym.vn.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private long id;

    @Column(name = "role_name")
    private String roleName;

    @OneToMany(targetEntity = UserRole.class)
    private Set<UserRole> userRoles;

    public Role() {
    }

    public Role(String roleName, Set<UserRole> userRoles) {
        this.roleName = roleName;
        this.userRoles = userRoles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
