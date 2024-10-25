package com.example.mainapp.Dto;

import java.util.Date;
import java.util.UUID;

public class PersonalBlogDto {
    private UUID uuid;
    private String title;
    private String description;
    private Date lastUpdateAt;
    private Date publishedAt;
    private Boolean published;

    public PersonalBlogDto(UUID uuid, String title, String description, Date lastUpdateAt, Date publishedAt, Boolean published) {
        this.uuid = uuid;
        this.title = title;
        this.description = description;
        this.lastUpdateAt = lastUpdateAt;
        this.publishedAt = publishedAt;
        this.published = published;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLastUpdateAt() {
        return lastUpdateAt;
    }

    public void setLastUpdateAt(Date lastUpdateAt) {
        this.lastUpdateAt = lastUpdateAt;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }
}
