package movielist;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MovieListDTO {
	
	Integer mid, year, play, genre1, genre2, genre3, genre4;
	String name, story, murl, imgurl,
		   foreman, actor, country;
	Date open;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getPlay() {
		return play;
	}
	public void setPlay(Integer play) {
		this.play = play;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStory() {
		return story;
	}
	
	public String getStoryBr() {
		return story.replace("\r\n", "<br>");
	}
	
	public void setStory(String story) {
		this.story = story;
	}
	public String getMurl() {
		return murl;
	}
	public void setMurl(String murl) {
		this.murl = murl;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getForeman() {
		return foreman;
	}
	public void setForeman(String foreman) {
		this.foreman = foreman;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	
	public Integer getGenre1() {
		return genre1;
	}
	public void setGenre1(Integer genre1) {
		this.genre1 = genre1;
	}
	public Integer getGenre2() {
		return genre2;
	}
	public void setGenre2(Integer genre2) {
		this.genre2 = genre2;
	}
	public Integer getGenre3() {
		return genre3;
	}
	public void setGenre3(Integer genre3) {
		this.genre3 = genre3;
	}
	public Integer getGenre4() {
		return genre4;
	}
	public void setGenre4(Integer genre4) {
		this.genre4 = genre4;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getOpen() {
		return open;
	}
	public void setOpen(Date open) {
		this.open = open;
	}
	
	public String getRegdateStr() {
		return sdf.format(open);
	}

	public void setOpen(String open) {
			try {
				this.open = sdf.parse(open);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
