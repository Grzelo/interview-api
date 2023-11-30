package com.task.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsDto {
    Long id;
    String login;
    String name;
    String type;
    String avatarUrl;
    String createdAt;
    BigDecimal calculations;
}
