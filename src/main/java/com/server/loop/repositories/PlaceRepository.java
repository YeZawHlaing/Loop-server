package com.server.loop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.loop.models.Place;

public interface PlaceRepository extends JpaRepository<Place, Long> {

}
