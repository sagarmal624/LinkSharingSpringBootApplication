package com.sagarandcompany.linkSharing.domains;

import com.sagarandcompany.linkSharing.utility.Visibility;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity()
public class Topic extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long topic_id;
    @Column(name = "topicName")
    private String name;
    @OneToOne
    private User createdBy;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "topic_resource", joinColumns = {@JoinColumn(name = "topic_id")}, inverseJoinColumns = {@JoinColumn(name = "resource_id")})
    private List<Resource> resources = new ArrayList<>();

    private Visibility visibility;

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public Long getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(Long topic_id) {
        this.topic_id = topic_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topic_id=" + topic_id +
                ", name='" + name + '\'' +
                ", createdBy=" + createdBy +
                '}';
    }
}
