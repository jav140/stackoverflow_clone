package com.example.stackoverflow_mono.domains;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Embeddable
public class Auditable {

    @Column(nullable = false, unique = true)
    private Long createdBy;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdAt", nullable = false,
            columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private Date createdAt;
    @Column(nullable = false, unique = true)
    private Long updatedBy;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updatedAt", nullable = false,
            columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private Date updatedAt;


}
