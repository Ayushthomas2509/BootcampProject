package ayushproject.ayushecommerce.entities;

import ayushproject.ayushecommerce.security.GrantAuthorityImpl;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("Seller")
public class Seller extends User {
        private Integer sellerId=getId();
        private Integer GST_No;
        @Embedded
        private Address address;
        @OneToMany(cascade = CascadeType.ALL)
        private List<Product> products;

        public Seller(){
            this.addRole(new Role(2,"ROLE_SELLER")); }

    public Seller(String name, String firstName, String lastName, Integer GST_No) {
        super(name, firstName, lastName);
        this.GST_No = GST_No;
        this.addRole(new Role(2,"ROLE_SELLER"));
    }

    public Integer getSellerId() {
            return sellerId;
        }

        public void setSellerId(Integer sellerId) {
            this.sellerId = sellerId;
        }

        public Integer getGST_No() {
            return GST_No;
        }

        public void setGST_No(Integer GST_No) {
            this.GST_No = GST_No;
        }

        public List<Product> getProducts() {
            return products;
        }

        public void setProducts(List<Product> products) {
            this.products = products;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

    @Override
    public String toString() {
        return "Seller{" +
                "sellerId=" + sellerId +
                ", GST_No=" + GST_No +
                ", address=" + address +
                ", products=" + products +
                '}';
    }

}


