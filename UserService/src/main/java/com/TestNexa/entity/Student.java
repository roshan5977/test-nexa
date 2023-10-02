package com.TestNexa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long s_id;
    private String s_name;
    private String s_regd_no;
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_ref_id")
    @JsonBackReference
    private Organization organization;
}
