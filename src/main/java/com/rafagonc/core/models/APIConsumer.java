package com.rafagonc.core.models;

import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.*;

/**
 * Created by rafagonc on 27/03/17.
 */
@Entity
@Table(name = "consumer")
public class APIConsumer {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(nullable = false)
    @SafeHtml
    private String name;

    @Column(nullable = false, unique = true)
    @SafeHtml
    private String key;

    @Column(nullable = false)
    private Integer calls;

    public APIConsumer() {
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getCalls() {
        return calls;
    }

    public void setCalls(Integer calls) {
        this.calls = calls;
    }
}
