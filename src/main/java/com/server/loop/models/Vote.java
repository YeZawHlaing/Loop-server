package com.server.loop.models;

import com.server.loop.common.constant.VoteType;
import com.server.loop.common.entity.MasterData;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "votes")
@ToString
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter 
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Vote extends MasterData {
    @Enumerated(EnumType.STRING)

    @Column(name = "vote_type", nullable = false)
    private VoteType voteType;

    // Many votes can belong to one user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User user;

    // Many votes can belong to one trending outfit
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trending_outfit_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private TrendingOutfit trendingOutfit;
}
