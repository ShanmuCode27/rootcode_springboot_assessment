package com.shanmu.assessment.database.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Data
@AllArgsConstructor
public abstract class BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    @CreationTimestamp
    private Date createdAt;

    @LastModifiedDate
    private Date modifiedOn;
}
