package com.server.loop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.loop.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
