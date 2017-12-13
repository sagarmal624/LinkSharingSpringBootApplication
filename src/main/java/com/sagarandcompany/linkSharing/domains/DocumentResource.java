package com.sagarandcompany.linkSharing.domains;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DocumentResource")
public class DocumentResource extends Resource {
    @Column(name = "filePath")
    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "DocumentResource{" +
                "filePath='" + filePath + '\'' +
                '}';
    }
}
