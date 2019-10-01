package event;

import java.util.Date;

public class MemberDTO {
   
   Integer mcode;
   Integer coupon,lev;
   double point;
   String  tel, email ,jumin;
   String name,id,pw;
   String genre;
   Date startdate;
   
   
   
   
   public MemberDTO() {
      // TODO Auto-generated constructor stub
   }




   public Integer getMcode() {
      return mcode;
   }




   public void setMcode(Integer mcode) {
      this.mcode = mcode;
   }




   public Integer getCoupon() {
      return coupon;
   }




   public void setCoupon(Integer coupon) {
      this.coupon = coupon;
   }




   public Integer getLev() {
      return lev;
   }




   public void setLev(Integer lev) {
      this.lev = lev;
   }




   public double getPoint() {
      return point;
   }




   public void setPoint(double point) {
      this.point = point;
   }




   public String getTel() {
      return tel;
   }




   public void setTel(String tel) {
      this.tel = tel;
   }




   public String getEmail() {
      return email;
   }




   public void setEmail(String email) {
      this.email = email;
   }




   public String getJumin() {
      return jumin;
   }




   public void setJumin(String jumin) {
      this.jumin = jumin;
   }




   public String getName() {
      return name;
   }




   public void setName(String name) {
      this.name = name;
   }




   public String getId() {
      return id;
   }




   public void setId(String id) {
      this.id = id;
   }




   public String getPw() {
      return pw;
   }




   public void setPw(String pw) {
      this.pw = pw;
   }




   public String getGenre() {
      return genre;
   }




   public void setGenre(String genre) {
      this.genre = genre;
   }




   public Date getStartdate() {
      return startdate;
   }




   public void setStartdate(Date startdate) {
      this.startdate = startdate;
   }




   @Override
   public String toString() {
      return "MemberDTO [mcode=" + mcode + ", coupon=" + coupon + ", lev=" + lev + ", point=" + point + ", tel=" + tel
            + ", email=" + email + ", jumin=" + jumin + ", name=" + name + ", id=" + id + ", pw=" + pw + ", genre="
            + genre + ", startdate=" + startdate + "]";
   }
   
   



   
}