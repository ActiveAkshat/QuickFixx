package com.quickfixxMicroservice.electricianService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.*;
import jakarta.persistence.Id;


import java.util.List;

@Entity
@Table(name = "t_electricianDB")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Electrician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long contact;
    private String location;
    private String address;
    private List<String> qualification;
}
