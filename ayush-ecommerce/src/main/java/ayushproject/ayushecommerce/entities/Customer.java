package ayushproject.ayushecommerce.entities;

import javax.persistence.*;
import java.util.List;
@Entity
@DiscriminatorValue("Customer")
public class Customer extends  User{
    private Integer custid=getId();

    @ElementCollection
    private List<Address> address;
    @OneToMany
    private List<Reviews> reviews;
    @OneToMany
    private List<Product> products;

    public Customer(){this.addRole(new Role(3,"ROLE_CUSTOMER"));}

    public Integer getCustid() {
        return custid;
    }

    public void setCustid(Integer custid) {
        this.custid = custid;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
