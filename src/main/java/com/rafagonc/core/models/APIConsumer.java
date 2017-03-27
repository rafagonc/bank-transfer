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

    @Column(nullable = false)
    @SafeHtml
    private String key;

    @Column(nullable = false)
    private Integer calls;

    public APIConsumer() {
    }
}
