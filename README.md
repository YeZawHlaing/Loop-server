# Interactive Style OS & Trend Discovery Platform 

A **Content-First, Gamified Social Commerce & Style OS** built for Gen Z and Millennials in Myanmar. Unlike passive inspiration boards or empty social commerce catalogs, this platform combines real-world personal wardrobe utility (**Smart Closet & Beauty Cabinet**), hyper-localized venue discovery (**Places**), and gamified daily crowd-validation (**Fit Check or Skip**) to answer the daily question: *"What should I wear for where I am going today?"*

---

## Tech Stack

- **Backend**: ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white) ![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white) ![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
- **Authentication**: ![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white) ![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white)
- **Database & Cache**: ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white) ![Redis](https://img.shields.io/badge/Redis-DC382D?style=for-the-badge&logo=redis&logoColor=white)
- **Cloud & Storage**: ![AWS](https://img.shields.io/badge/AWS-232F3E?style=for-the-badge&logo=amazonwebservices&logoColor=white)

---

## Core Features

1. **User Onboarding & Aesthetic Calibration**
    - Stateless JWT authentication (Access & Refresh tokens) with role-based access control (`USER`, `INFLUENCER`, `SELLER`, `ADMIN`).
    - Interactive aesthetic tag selection (`#Streetwear`, `#Y2K`, `#CleanGirl`, `#Minimalist`, etc.).
    - Private logging of physical body metrics (`height`, `weight`, `shoulder_width`, `foot_size`, `skin_tone`, `undertone`, `skin_type`).

2. **"Places" Contextual Outfit Discovery Engine (Home Hub)**
    - Venue-first exploration tailored for local lifestyle & cultural contexts across 10 core destinations:
        -  **Cafe & Coffee Shop** |  **Pagoda & Temple** |  **Corporate Office / Work**
        -  **University / Campus** |  **Park & Outdoor Picnic** |  **Bar, Rooftop & Night Out**
        - ️ **Shopping Mall & City Walk** |  **Travel & Getaway** |  **Wedding & Ceremony** | ️ **Gym & Fitness Studio**
    - Filters outfits ranked highest by users sharing the viewer's exact body cluster.

3. **Gamified "Fit Check or Skip" Daily Voting Loop**
    - Interactive story-card and grid-to-focus voting experience (`FIT` vs. `SKIP`).
    - Instant post-vote consensus feedback (e.g., *"88% of users in your Body Cluster voted FIT"*), backed by high-speed **Redis** vote counters and leaderboards.
    - Daily streak tracking (`s`) and gated utility unlocks for top daily venue trends.

4. **Smart Closet & Beauty Cabinet**
    - Digital inventory logging for owned apparel, footwear, and cosmetics (shade codes, quantities, fit notes) with media stored on **AWS S3**.
    - Automated **Fit Match Confidence Scores** displayed on community outfit posts.

5. **Social Vlogs, Combo Posts & Reviews**
    - Short-form beauty/styling vlogs, multi-item combo breakdowns, and community fashion reviews.

---

## System Architecture

The platform runs on a **Decoupled Cloud-Native Client-Server Architecture** powered by **Spring Boot**, **MySQL**, **Redis**, **JWT**, and **AWS**:

```text
┌───────────────────────────┐       HTTPS / JSON       ┌───────────────────────────┐
│      Client Frontend      │ ◄──────────────────────► │    Spring Boot REST API   │
│  (Web SPA / Mobile App)   │      JWT Bearer Auth     │   (Spring Security + JPA) │
└───────────────────────────┘                          └──┬──────────┬──────────┬──┘
                                                          │          │          │
                                    Spring Data JPA       │          │          │ AWS SDK
                                    ▼                     │          │          ▼
                      ┌───────────────────────────┐       │          │    ┌───────────────┐
                      │      MySQL Database       │       │          │    │    AWS S3 /   │
                      │    (AWS RDS Persistent)   │       │          │    │  CloudFront   │
                      └───────────────────────────┘       │          │    └───────────────┘
                                                          ▼          │
                                            ┌───────────────────────────┐
                                            │        Redis Cache        │
                                            │ (Streaks, TVI & Sessions) │
                                            └───────────────────────────┘