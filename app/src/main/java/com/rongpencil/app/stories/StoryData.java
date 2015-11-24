package com.rongpencil.app.stories;

public class StoryData {

    private String mTitle;
    private String mSummary;
    private String mImagePreviewUrl;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String name) {
        this.mTitle = name;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        this.mSummary = summary;
    }

    public String getImageUrl() {
        return this.mImagePreviewUrl;
    }

    public void setImageUrl(String url) {
        url = url.replaceAll("200x150x1","320x150x1");
        this.mImagePreviewUrl = url;
    }
}
