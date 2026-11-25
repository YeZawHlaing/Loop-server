package com.server.loop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.loop.models.ClosetItems;

public interface ClosetItemRepository extends JpaRepository<ClosetItems, Long> {

}
