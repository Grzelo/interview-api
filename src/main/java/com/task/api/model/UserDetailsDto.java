package com.task.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

    public void setCalculations(Long followersCnt, Long publicReposCnt) {
        if (followersCnt == 0) this.calculations = BigDecimal.valueOf(-1);
        else this.calculations = BigDecimal.valueOf(6)
                .divide(BigDecimal.valueOf(followersCnt), 10, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(2 + publicReposCnt));
    }
}
