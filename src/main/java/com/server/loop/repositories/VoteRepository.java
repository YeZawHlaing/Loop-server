package com.server.loop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.loop.models.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {

}
