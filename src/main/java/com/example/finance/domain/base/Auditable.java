package com.example.finance.domain.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable<U> {
    @CreatedBy
    @JsonIgnore
    @Column(name = "created_by")
    private String createdBy;

    @CreatedDate
    @JsonIgnore
    @Column(name = "created_date")
    private Date createdDate;

    @LastModifiedBy
    @JsonIgnore
    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @LastModifiedDate
    @JsonIgnore
    @Column(name = "last_modified_date")
    private Date updatedDate;
}
