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
    private String userName;
    private String content;
    private Date lastUpdateAt;
    private Date publishedAt;

    public Blogs(UUID uuid, String title, String userName, String content, Date lastUpdateAt, Date publishedAt) {
        this.uuid = uuid;
        this.title = title;
        this.userName = userName;
        this.content = content;
        this.lastUpdateAt = lastUpdateAt;
        this.publishedAt = publishedAt;
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
}

