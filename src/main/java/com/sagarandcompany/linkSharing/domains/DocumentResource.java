package com.sagarandcompany.linkSharing.domains;

public class DocumentResource {
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
