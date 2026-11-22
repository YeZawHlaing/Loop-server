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
@Table(name = "hashtags")
@ToString
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Hashtag extends MasterData {

    @Column(name = "hashtag_name", nullable = false, unique = true)
    private String hashtagName;

    // Many hashtags can belong to one hashtag tier
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tier_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private HashtagTier tier;

    // One hashtag can have many closet items (not included in the issue)
    @OneToMany(mappedBy = "hashtag", fetch = FetchType.LAZY)
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<ClosetItems> closetItems = new ArrayList<>();

    // One hashtag can have many profile hashtags
    @OneToMany(mappedBy = "hashtag", fetch = FetchType.LAZY)
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<ProfileHashtag> profileHashtags = new ArrayList<>();

}
