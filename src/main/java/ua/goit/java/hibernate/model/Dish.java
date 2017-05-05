package ua.goit.java.hibernate.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Raketa on 25.12.2016.
 */
@Entity
public class Dish {
  @Id
  @GeneratedValue(generator = "increment")
  @GenericGenerator(name = "increment", strategy = "increment")
  private Long id;
  @Column(name = "name")

  private String name;
  @Column(name = "category")

  @Enumerated(EnumType.STRING)
  private DishCategory category;

  @Column(name = "price")
  private Float price;

  @Column(name = "weight")
  private Float weight;

  @Override
  public String toString() {
    return "Dish{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", category=" + category +
            ", price=" + price +
            ", weight=" + weight +
            '}';
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DishCategory getCategory() {
    return category;
  }

  public void setCategory(DishCategory category) {
    this.category = category;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public float getWeight() {
    return weight;
  }

  public void setWeight(float weight) {
    this.weight = weight;
  }

}
