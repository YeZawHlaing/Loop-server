package com.server.loop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.loop.models.TrendingOutfit;

public interface TrendingOutfitRepository extends JpaRepository<TrendingOutfit, Long>{
    
}
