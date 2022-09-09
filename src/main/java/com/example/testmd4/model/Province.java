package com.example.testmd4.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "province")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double area;
    private double population;
    private double gdp;
    private String introduce;
    @ManyToOne
    private Country country;

}
