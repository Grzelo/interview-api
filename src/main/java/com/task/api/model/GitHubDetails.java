package com.task.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubDetails {
    Long id;
    String login;
    String name;
    String type;
    @JsonProperty("avatar_url")
    String avatarUrl;
    @JsonProperty("created_at")
    String createdAt;
    Long followers;
    @JsonProperty("public_repos")
    Long publicRepos;
}
