package com.TestNexa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ExamAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exam_admin_id;
    private String email;
    private String name;
    private String org_code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_ref_id")
    @JsonBackReference
    private Organization organization;
}
