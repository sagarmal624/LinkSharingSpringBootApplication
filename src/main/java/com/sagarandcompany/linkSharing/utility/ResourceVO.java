package com.sagarandcompany.linkSharing.utility;

import java.util.List;

public class ResourceVO {
    private String url;
    private Long resource_id;
    private String description;
    private String file;
    private TopicVO topic;
    private String resourceCreatedBy;

    public String getResourceCreatedBy() {
        return resourceCreatedBy;
    }

    public void setResourceCreatedBy(String resourceCreatedBy) {
        this.resourceCreatedBy = resourceCreatedBy;
    }

    public TopicVO getTopic() {
        return topic;
    }

    public void setTopic(TopicVO topic) {
        this.topic = topic;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getResource_id() {
        return resource_id;
    }

    public void setResource_id(Long resource_id) {
        this.resource_id = resource_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
