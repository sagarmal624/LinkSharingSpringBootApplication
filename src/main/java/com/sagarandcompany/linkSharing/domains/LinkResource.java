package com.sagarandcompany.linkSharing.domains;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("LinkResource")
public class LinkResource extends Resource {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "LinkResource{" +
                "url='" + url + '\'' +
                '}';
    }
}
