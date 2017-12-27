package com.sagarandcompany.linkSharing.utility;

public class ReadingItemVO {
    private Long reading_item_id;
    private Long resource_id;
    private Long user_id;
    private boolean is_read;

    public Long getReading_item_id() {
        return reading_item_id;
    }

    public void setReading_item_id(Long reading_item_id) {
        this.reading_item_id = reading_item_id;
    }

    public Long getResource_id() {
        return resource_id;
    }

    public void setResource_id(Long resource_id) {
        this.resource_id = resource_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public boolean isIs_read() {
        return is_read;
    }

    public void setIs_read(boolean is_read) {
        this.is_read = is_read;
    }
}
