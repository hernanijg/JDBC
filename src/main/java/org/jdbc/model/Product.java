package org.jdbc.model;

//import java.sql.Date;

import java.util.Date;

public class Product {
    private Long id;
    private String name;
    private Integer price;
    private Date registerDate;
    private String sku;

    public Product() {}

    public Product(Long id, String name, Integer price, Date registerDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.registerDate = registerDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", registerDate=" + registerDate +
                ", sku=" + sku +
                '}';
    }
}
