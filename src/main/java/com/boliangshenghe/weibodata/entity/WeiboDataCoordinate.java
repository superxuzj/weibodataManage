package com.boliangshenghe.weibodata.entity;

public class WeiboDataCoordinate {
    private Integer id;

    private String weiboId;

    private String coordinate;

    private String weiboImg;

    private String weiboVideo;

    private Integer repostNum;

    private Integer commentNum;

    private Integer praiseNum;

    private String uid;

    private Integer isOrigin;

    private String device;

    private String weiboUrl;

    private String createTime;

    private Integer commentCrawled;

    private Integer repostCrawled;

    private String weiboCont;
    
    public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	private Integer start;
    
    private Integer limit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWeiboId() {
        return weiboId;
    }

    public void setWeiboId(String weiboId) {
        this.weiboId = weiboId == null ? null : weiboId.trim();
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate == null ? null : coordinate.trim();
    }

    public String getWeiboImg() {
        return weiboImg;
    }

    public void setWeiboImg(String weiboImg) {
        this.weiboImg = weiboImg == null ? null : weiboImg.trim();
    }

    public String getWeiboVideo() {
        return weiboVideo;
    }

    public void setWeiboVideo(String weiboVideo) {
        this.weiboVideo = weiboVideo == null ? null : weiboVideo.trim();
    }

    public Integer getRepostNum() {
        return repostNum;
    }

    public void setRepostNum(Integer repostNum) {
        this.repostNum = repostNum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public Integer getIsOrigin() {
        return isOrigin;
    }

    public void setIsOrigin(Integer isOrigin) {
        this.isOrigin = isOrigin;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device == null ? null : device.trim();
    }

    public String getWeiboUrl() {
        return weiboUrl;
    }

    public void setWeiboUrl(String weiboUrl) {
        this.weiboUrl = weiboUrl == null ? null : weiboUrl.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public Integer getCommentCrawled() {
        return commentCrawled;
    }

    public void setCommentCrawled(Integer commentCrawled) {
        this.commentCrawled = commentCrawled;
    }

    public Integer getRepostCrawled() {
        return repostCrawled;
    }

    public void setRepostCrawled(Integer repostCrawled) {
        this.repostCrawled = repostCrawled;
    }

    public String getWeiboCont() {
        return weiboCont;
    }

    public void setWeiboCont(String weiboCont) {
        this.weiboCont = weiboCont == null ? null : weiboCont.trim();
    }
}