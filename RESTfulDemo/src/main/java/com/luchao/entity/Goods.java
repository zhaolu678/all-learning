package com.luchao.entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Goods implements Serializable {

    /**
     * id
     */
    private int id;
    /**
     * 名称
     */
    @Pattern(regexp = "^[^><&#]{1,50}$", message = "{pattern}")
    @NotNull(message = "{notNull}")
    private String name;
    /**
     * 价格
     */
    @Min(value = 1, message = "必须大于或等于1")
    private double price;
    /**
     * 图片
     */
    private String picture;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getPicture() {
        return picture;
    }

    public Goods(int id, String name, double price, String picture) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.picture = picture;
    }

    public Goods() {

    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", picture='" + picture + '\'' +
                '}';
    }
}