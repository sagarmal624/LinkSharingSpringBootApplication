package com.sagarandcompany.linkSharing.utility;

public enum LinkSharingKeyword {
    USER("User"),
    SUBSCRIPTION("Subscription"),
    TOPIC("Topic"),
    RESOURCE("Resource"),
    LINK_SHARING_RESOURCE("Link Sharing Resource"),
    DOCUMENT_SHARING_RESOURCE("Document Sharing Resource"),
    READING_ITEM("Reading Item");
    final String value;

    LinkSharingKeyword(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
