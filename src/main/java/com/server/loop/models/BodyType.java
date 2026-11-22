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
@Table(name = "body_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(callSuper = true)

public class BodyType extends MasterData {

    @Column(name = "body_type_name", nullable = false, unique = true)
    private String bodyTypeName;

    // Many body types can have the same hashtag
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hashtag_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Hashtag hashtag;

    // One body type can have many trending outfits
    @OneToMany(mappedBy = "bodyType", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<TrendingOutfit> trendingOutfits = new ArrayList<>();

}
