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

@Entity
@Table(name = "places")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)

public class Place extends MasterData {

    @Column(name = "place_name", nullable = false, unique = true)
    private String placeName;

    @Column(name = "place_image")
    private String placeImage;

    // Many places can have the same hashtag
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hashtag_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Hashtag hashtag;

    // One place can have many trending outfits
    @OneToMany(mappedBy = "place", fetch = FetchType.LAZY)
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<TrendingOutfit> trendingOutfits = new ArrayList<>();

}
