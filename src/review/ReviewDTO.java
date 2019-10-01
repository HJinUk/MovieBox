package review;

import java.util.Date;

public class ReviewDTO {
	
	Integer mid, mcode, tat, reco;
	String text, id;
	Date date;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public Integer getMcode() {
		return mcode;
	}
	public void setMcode(Integer mcode) {
		this.mcode = mcode;
	}
	public Integer getTat() {
		return tat;
	}
	public void setTat(Integer tat) {
		this.tat = tat;
	}
	public Integer getReco() {
		return reco;
	}
	public void setReco(Integer reco) {
		this.reco = reco;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
