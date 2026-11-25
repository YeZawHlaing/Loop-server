package com.server.loop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.loop.models.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
