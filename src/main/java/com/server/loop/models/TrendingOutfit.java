package com.server.loop.models;

import java.util.ArrayList;
import java.util.List;

import com.server.loop.common.entity.MasterData;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * TrendingOutfit
 */
@Entity
@Table(name = "trending_outfits")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)

public class TrendingOutfit extends MasterData {

    @Column(name = "outfit_name", nullable = false)
    private String outfitName;

    @Column(name = "outfit_image", nullable = false)
    private String outfitImage;

    @Column(name = "caption", nullable = false)
    private String caption;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    // Many trending outfits can belong to one place
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Place place;

    // Many trending outfits can have the same hashtag
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hashtag_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Hashtag hashtag;

    // Many trending outfits can belong to one body type
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "body_type_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private BodyType bodyType;

    // One trending outfit can have many votes
    @OneToMany(mappedBy = "trendingOutfit", fetch = FetchType.LAZY)
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Vote> votes = new ArrayList<>();
}
