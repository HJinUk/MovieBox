package event;

import java.sql.Date;

public class EventDTO {
	
	String title,content,title_img,content_img;
	Integer eid,coupon,point;
	Date start_ev,finish_ev;
	
	public EventDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public Integer getCoupon() {
		return coupon;
	}

	public void setCoupon(Integer coupon) {
		this.coupon = coupon;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Date getstart_ev() {
		return start_ev;
	}

	public void setStart_ev(Date start_ev) {
		this.start_ev = start_ev;
	}

	public Date getfinish_ev() {
		return finish_ev;
	}

	public void setFinish_ev(Date finish_ev) {
		this.finish_ev = finish_ev;
	}

	public String getTitle_img() {
		return title_img;
	}

	public void setTitle_img(String title_img) {
		this.title_img = title_img;
	}

	public String getContent_img() {
		return content_img;
	}

	public void setContent_img(String content_img) {
		this.content_img = content_img;
	}

	
	
	
}
