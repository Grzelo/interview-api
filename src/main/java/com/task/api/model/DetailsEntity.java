package com.task.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DetailsEntity {
    @Id
    String login;

    @Column(name = "REQUEST_COUNT")
    Long requestCount;
}
