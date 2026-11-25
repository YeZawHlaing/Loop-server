package com.server.loop.models;

import java.util.ArrayList;
import java.util.List;

import com.server.loop.common.entity.MasterData;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "hashtag_tiers")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)

public class HashtagTier extends MasterData {

    @Column(name = "tier_name", nullable = false)
    private String tierName;

    @Column(name = "tier_number", nullable = false, unique = true)
    private Integer tierNumber;

    // One hashtag tier can have many hashtags
    @OneToMany(mappedBy = "tier", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Hashtag> hashtags = new ArrayList<>();
}
