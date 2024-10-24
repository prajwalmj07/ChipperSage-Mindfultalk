package com.chipperSage.chipperSage.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ContentMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contentMasterId;
    private String contentMasterName;
    private String contentMasterDesc;
    private String contentOrigin;
    private String contentTopic;

    public ContentMaster() {
    }

    public String getContentTopic() {
        return contentTopic;
    }

    public void setContentTopic(String contentTopic) {
        this.contentTopic = contentTopic;
    }

    public String getContentOrigin() {
        return contentOrigin;
    }

    public void setContentOrigin(String contentOrigin) {
        this.contentOrigin = contentOrigin;
    }

    public String getContentMasterDesc() {
        return contentMasterDesc;
    }

    public void setContentMasterDesc(String contentMasterDesc) {
        this.contentMasterDesc = contentMasterDesc;
    }

    public String getContentMasterName() {
        return contentMasterName;
    }

    public void setContentMasterName(String contentMasterName) {
        this.contentMasterName = contentMasterName;
    }

    public int getContentMasterId() {
        return contentMasterId;
    }

    public void setContentMasterId(int contentMasterId) {
        this.contentMasterId = contentMasterId;
    }
    // Getters and Setters
}