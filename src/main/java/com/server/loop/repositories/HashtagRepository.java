package com.server.loop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.loop.models.Hashtag;

public interface HashtagRepository extends JpaRepository<Hashtag, Long> {
    
}
