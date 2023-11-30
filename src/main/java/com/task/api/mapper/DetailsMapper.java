package com.task.api.mapper;

import com.task.api.model.GitHubDetails;
import com.task.api.model.UserDetailsDto;
import org.springframework.stereotype.Component;

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
            userDetails.setCalculations(gitHubDetails.getFollowers(), gitHubDetails.getPublicRepos());
        }

        return userDetails;
    }
}