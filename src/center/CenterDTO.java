package center;

import java.util.Date;

public class CenterDTO {	//moviebox DTO

	
	
	
	Integer cid,pw,cnt;
	String name,title,content,file,cate;
	Date regdate;
	
	Integer lev,seq;
	

	public Integer getLev() {
		return lev;
	}

	public void setLev(Integer lev) {
		this.lev = lev;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}


	
	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getPw() {
		return pw;
	}

	public void setPw(Integer pw) {
		this.pw = pw;
	}

	public Integer getCnt() {
		return cnt;
	}

	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "CenterDTO [cid=" + cid + ", pw=" + pw + ", cnt=" + cnt + ", name=" + name + ", title=" + title
				+ ", content=" + content + ", file=" + file + ", cate=" + cate + ", regdate=" + regdate + ", lev=" + lev
				+ ", seq=" + seq + "]";
	}




	
	
	
	
}
