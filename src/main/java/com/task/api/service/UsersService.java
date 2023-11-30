package com.task.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.api.model.DetailsEntity;
import com.task.api.model.GitHubDetails;
import com.task.api.repository.RequestRepository;
import jakarta.transaction.Transactional;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UsersService {
    Logger logger = LoggerFactory.getLogger(UsersService.class);

    private final static String GITHUB_API_GET_USER = "https://api.github.com/users/%s";
    RequestRepository requestRepository;

    @Transactional
    public GitHubDetails userDetails(String login) {
        ObjectMapper mapper = new ObjectMapper();
        GitHubDetails userDetails = null;
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet githubRequest = new HttpGet(String.format(GITHUB_API_GET_USER, login));
            userDetails = client.execute(githubRequest, httpResponse -> mapper.readValue(httpResponse.getEntity().getContent(), GitHubDetails.class));
            if (requestRepository.findDetailsEntitiesByLogin(login).isEmpty()) {
                requestRepository.saveAndFlush(new DetailsEntity(login, 1L));
            } else requestRepository.updateRequestCount(login);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }

        return userDetails;
    }

    @Autowired
    public void setRequestRepository(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }
}
