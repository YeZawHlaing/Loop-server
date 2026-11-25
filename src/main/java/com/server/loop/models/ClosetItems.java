package com.server.loop.models;

import com.server.loop.common.entity.MasterData;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "closet_items")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)

public class ClosetItems extends MasterData {

    @Column(name = "closet_image", nullable = false)
    private String closetImage;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    // Many closet items can belong to one user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User user;

    // Many closet items can relate to one hashtag
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hashtag_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Hashtag hashtag;

    // Many closet items can belong to one trending outfit
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trending_outfit_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private TrendingOutfit trendingOutfit;

}
