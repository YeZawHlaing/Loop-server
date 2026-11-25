package com.server.loop.models;

import com.server.loop.common.entity.MasterData;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user_body_metrics")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)

public class UserBodyMetrics extends MasterData {

    @Column(name = "height")
    private Double height;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "shoulder_width")
    private Double shoulderWidth;

    @Column(name = "foot_size")
    private Double footSize;

    @Column(name = "skin_tone")
    private String skinTone;

    @Column(name = "under_tone")
    private String underTone;

    @Column(name = "skin_type")
    private String skinType;

    // One user can have only one body metrics
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", unique = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User user;

    // Many user body metrics can have the same body type
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "body_type_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private BodyType bodyType;

    // Many user body metrics can have the same hashtag
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hashtag_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Hashtag hashtag;

}
