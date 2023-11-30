package com.task.api.mapper;

import com.task.api.model.GitHubDetails;
import com.task.api.model.UserDetailsDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class DetailsMapper {
    public UserDetailsDto toDto(GitHubDetails gitHubDetails) {
        UserDetailsDto userDetails = new UserDetailsDto();
        if (gitHubDetails != null) {
            userDetails.setName(gitHubDetails.getName());
            userDetails.setId(gitHubDetails.getId());
            userDetails.setLogin(gitHubDetails.getLogin());
            userDetails.setType(gitHubDetails.getType());
            userDetails.setAvatarUrl(gitHubDetails.getAvatarUrl());
            userDetails.setCreatedAt(gitHubDetails.getCreatedAt());
            userDetails.setCalculations(doCalculations(gitHubDetails.getFollowers(), gitHubDetails.getPublicRepos()));
        }

        return userDetails;
    }

    private BigDecimal doCalculations(Long followersCnt, Long publicReposCnt) {
        if (followersCnt == 0) return BigDecimal.valueOf(-1);
        else return BigDecimal.valueOf(6)
                .divide(BigDecimal.valueOf(followersCnt), 10, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(2 + publicReposCnt));
    }
}