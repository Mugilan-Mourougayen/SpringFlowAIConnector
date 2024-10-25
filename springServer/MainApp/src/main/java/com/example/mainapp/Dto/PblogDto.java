package com.example.mainapp.Dto;

import java.util.Date;
import java.util.UUID;

public class PblogDto {
    private UUID uuid;
    private String title;

    private String description;
    private String userName;
    private Date publishedAt;
    private Boolean published;


    public PblogDto(UUID uuid, String title, String description, String userName, Date publishedAt, Boolean published) {
        this.uuid = uuid;
        this.title = title;
        this.description = description;
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
