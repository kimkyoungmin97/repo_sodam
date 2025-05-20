package com.a5a5lab.module.user.api;

import com.a5a5lab.module.common.BaseVo;

public class apiDto extends BaseVo{
	private String title;
    private String address;
    private String imageUrl;
    private String contentId;
    private String overview;
    private Double mapX; // 경도
    private Double mapY; // 위도
//-----
    
    
    public String getTitle() {
        return title;
    }

    public Double getMapX() {
		return mapX;
	}

	public void setMapX(Double mapX) {
		this.mapX = mapX;
	}

	public Double getMapY() {
		return mapY;
	}

	public void setMapY(Double mapY) {
		this.mapY = mapY;
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
