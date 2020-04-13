package ayushproject.ayushecommerce.entities;

import ayushproject.ayushecommerce.enums.IN_STOCK;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "Category",discriminatorType = DiscriminatorType.STRING)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Integer id;
    private String name;
    private String brand;
    private Integer quantity;
    @Enumerated(EnumType.STRING)
    private IN_STOCK inStock;
    private String description;

    @ManyToOne
    private Seller seller;

    @OneToMany(cascade = CascadeType.ALL)
    public List<Reviews> reviews;

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
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

    public String getBrand() {
        return brand;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public IN_STOCK getInStock() {
        return inStock;
    }

    public void setInStock(IN_STOCK inStock) {
        this.inStock = inStock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
