package com.server.loop.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.server.loop.common.entity.MasterData;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
@Table(name = "profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(callSuper = true)

public class Profile extends MasterData {

    @Column(name = "bio")
    private String bio;

    @Column(name = "profile_name")
    private String profileName;

    @Column(name = "profile_image")
    private String profileImage;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "gender")
    private String gender;

    // One profile can belong ‌ေto one user
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", unique = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User user;

    // One profile can have many hashtags
    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    @Builder.Default
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<ProfileHashtag> profileHashtags = new ArrayList<>();

}
