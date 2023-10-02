package com.TestNexa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class OrganizationAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long org_admin_id;
    private String email;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_ref_id")
    @JsonBackReference
    private Organization organization;
}
