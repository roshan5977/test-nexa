package com.TestNexa.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long org_id;
    private String org_name;
    private String org_code;
    private Date start_date;
    private Date expire_date;
    private String org_admin_email;
    private String org_description;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ExamAdmin> examAdmins;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> students;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrganizationAdmin> organizationAdmins;
}
