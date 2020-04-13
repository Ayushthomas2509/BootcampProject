package ayushproject.ayushecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull(message = "name cannot be empty")
    private String name;
//    @NotNull(message = "Cannot be blank")
//    private String password;
    //@JsonIgnore
private Date dob;
    @Transient
    @Size(min = 8,max = 15,message = "Limit must be from 8 to 15")
    @Pattern(regexp = ".*[A-z].*")
    @Pattern(regexp = ".*[a-z].*")
    @Pattern(regexp = ".*\\d.*")
    @Pattern(regexp = ".*[#@_].*")
    private String confirmPassword;
    @NotNull
    private String firstName;
    @Email
    private String email;
    private String lastName;
    private String gender;
    private Integer age;
    private String password;
    private boolean enabled=false;
    @JsonIgnore
    private Integer failedAttempts=0;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
               joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "roleid"))
    @JsonIgnore
     private Set<Role> roles;

    public User(String name,String firstName,String lastName){
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(Integer failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    public void addRole(Role role){
        if(roles==null)
            roles=new HashSet<>();

        roles.add(role);
    }

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", failedAttempts=" + failedAttempts +
                ", roles=" + roles +
                '}';
    }
}
