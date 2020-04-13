package ayushproject.ayushecommerce.entities;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role implements GrantedAuthority {

    @Id
    private Integer roleid;
    private String role_authority;

    @ManyToMany(mappedBy = "roles",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<User> user;

    public Role(Integer roleid,String role_authority){
        this.roleid=roleid;
        this.role_authority=role_authority;
    }

    public Role() {
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleid=" + roleid +
                ", role_authority='" + role_authority + '\'' +
                ", user=" + user +
                '}';
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRole_authority() {
        return role_authority;
    }

    public void setRole_authority(String authority) {
        this.role_authority = authority;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    @Override
    public String getAuthority() {
        return null;
    }
}
