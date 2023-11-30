package com.task.api.repository;

import com.task.api.model.DetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RequestRepository extends JpaRepository<DetailsEntity, Long> {

    List<DetailsEntity> findDetailsEntitiesByLogin(String login);

    @Modifying(clearAutomatically = true)
    @Query("update DetailsEntity set requestCount = requestCount+1 where login=:login")
    void updateRequestCount(@Param("login") String login);
}
