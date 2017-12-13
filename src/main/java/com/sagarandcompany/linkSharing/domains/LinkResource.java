package com.sagarandcompany.linkSharing.domains;

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
