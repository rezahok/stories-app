package com.rongpencil.app.stories;

public class StoryData {
    private String mTitle;
    private String mSummary;
    private int mThumbnail;
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

    public int getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.mThumbnail = thumbnail;
    }

    public String getImageUrl()   { return this.mImagePreviewUrl; }

    public void setImageUrl(String url) { this.mImagePreviewUrl = url; }

}
