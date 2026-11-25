package com.server.loop.models;

import com.server.loop.common.entity.MasterData;

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
@Table(name = "profile_hashtags")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)

public class ProfileHashtag extends MasterData {

    private String profileHashtagName;

    // Many profile hashtags can belong to one profile
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Profile profile;

    // Many profile hashtags can relate to one hashtag
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hashtag_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Hashtag hashtag;
}
