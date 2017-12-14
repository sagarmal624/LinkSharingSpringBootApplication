package com.sagarandcompany.linkSharing.domains;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "Type")
public abstract class Resource extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "resource_id")
    private Long resource_id;

    private String description;

    @OneToOne
    private User createdBy;
    @OneToOne
    private Topic topic;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + resource_id +
                ", description='" + description + '\'' +
                ", createdBy=" + createdBy +
                ", topic=" + topic +
                '}';
    }
}
