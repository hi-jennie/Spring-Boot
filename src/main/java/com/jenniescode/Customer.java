package com.jenniescode;

import jakarta.persistence.*;
import java.util.Objects;

// 这个标记告诉Java这个类是一个“实体”，也就是说它对应数据库中的一张表
@Entity
public class Customer {
    /*
    •	如果使用GenerationType.IDENTITY，则不需要使用@SequenceGenerator，因为主键值是由数据库自动处理的。
	•	如果使用GenerationType.SEQUENCE，则需要使用@SequenceGenerator来定义序列的相关信息。
     */

    // This annotation indicates that the id field is the primary key for the Customer entity
    @Id
    // This annotation defines a sequence generator that specifies details about the sequence
    @SequenceGenerator(name = "customer_id_sequence",
            sequenceName = "customer_id_sequence"
            )
    // This annotation specifies that the value of id will be generated automatically, rather than being set manually
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence"
    )
    // @GeneratedValue(strategy = GenerationType.IDENTITY) is the same as the above two annotations

    private Integer id;
    private Integer age;
    private String name;
    private String email;

    public Customer(Integer id, Integer age, String name, String email) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.email = email;
    }

    public Customer() {

    }

    public Integer getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(age, customer.age) && Objects.equals(name, customer.name) && Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, name, email);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
