# Interactive Style OS & Trend Discovery Platform

A **Content-First, Gamified Social Commerce & Style OS** built for Gen Z and Millennials in Myanmar. Unlike passive inspiration boards or empty social commerce catalogs, this platform combines real-world personal wardrobe utility (**Smart Closet & Beauty Cabinet**), hyper-localized venue discovery (**Places**), and gamified daily crowd-validation (**Fit Check or Skip**) to answer the daily question: *"What should I wear for where I am going today?"*

---

## Core Features

1. **User Onboarding & Aesthetic Calibration**
    - Social & OTP authentication with profile creation.
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
    - Instant post-vote consensus feedback (e.g., *"88% of users in your Body Cluster voted FIT"*).
    - Daily streak tracking (``) and gated utility unlocks for top daily venue trends.

4. **Smart Closet & Beauty Cabinet**
    - Digital inventory logging for owned apparel, footwear, and cosmetics (shade codes, quantities, fit notes).
    - Automated **Fit Match Confidence Scores** displayed on community outfit posts.

5. **Social Vlogs, Combo Posts & Reviews**
    - Short-form beauty/styling vlogs, multi-item combo breakdowns, and community fashion reviews.

---

## System Architecture

The system uses a **Decoupled Client-Server Single Page Application (SPA)** architecture:

```text
┌───────────────────────────┐       HTTP / JSON       ┌───────────────────────────┐
│      Client Frontend      │ ◄─────────────────────► │      Backend API Server   │
│  (AngularJS / Mobile SPA) │      RESTful APIs       │      (Laravel / PHP)      │
└───────────────────────────┘                         └─────────────┬─────────────┘
                                                                    │ Eloquent ORM
                                                                    ▼
                                                      ┌───────────────────────────┐
                                                      │     Relational Database   │
                                                      │       (MySQL / SQL)       │
                                                      └───────────────────────────┘