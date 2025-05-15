package com.a5a5lab.module.user.api;

import com.a5a5lab.module.common.BaseVo;

public class apiDto extends BaseVo{
	private String title;
    private String address;
    private String imageUrl;
    private String contentId;
    private String overview;
//-----
    
    
    public String getTitle() {
        return title;
    }

    public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
