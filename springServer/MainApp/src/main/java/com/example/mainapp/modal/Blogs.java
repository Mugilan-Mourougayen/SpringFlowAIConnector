package com.example.mainapp.modal;

import jakarta.persistence.*;
import org.hibernate.sql.Update;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Blogs")
public class Blogs {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String title;
    private String description;
    private String userName;
    private String content;
    private Date lastUpdateAt;
    private Date publishedAt;
    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean published;

    public Blogs(UUID uuid, String title, String description,String userName, String content, Date lastUpdateAt, Date publishedAt,Boolean published) {
        this.uuid = uuid;
        this.title = title;
        this.description = description;
        this.userName = userName;
        this.content = content;
        this.lastUpdateAt = lastUpdateAt;
        this.publishedAt = publishedAt;
        this.published = published;
    }

    public Blogs() {

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    @Override
    public String toString() {
        return "Blogs{" +
                "uuid=" + uuid +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", userName='" + userName + '\'' +
                ", content='" + content + '\'' +
                ", lastUpdateAt=" + lastUpdateAt +
                ", publishedAt=" + publishedAt +
                ", published=" + published +
                '}';
    }
}

