package reserve;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReserveDTO {

	Integer rid,sum,dsum,number,mid,tid,areacode;
	Date date,open;
	String seatnumber,name;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
public ReserveDTO() {
	// TODO Auto-generated constructor stub
}
	public Integer getRid() {
		return rid;
	}

	public Integer getAreacode() {
		return areacode;
	}
	public void setAreacode(Integer areacode) {
		this.areacode = areacode;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public Integer getDsum() {
		return dsum;
	}

	public void setDsum(Integer dsum) {
		this.dsum = dsum;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getDateStr() {
		return sdf.format(date);
	}

	public void setDateStr(String date) {
		try {
			this.date = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	public String getSeatnumber() {
		return seatnumber;
	}

	public void setSeatnumber(String seatnumber) {
		this.seatnumber = seatnumber;
	}

	public Date getOpen() {
		return open;
	}

	public void setOpen(Date open) {
		this.open = open;
	}
	
	public String getOpenStr() {
		return sdf.format(open);
	}

	public void setOpenStr(String open) {
		try {
			this.open = sdf.parse(open);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}



	
	public String getJSON() {

        return "{ \"areacode\":"+areacode + 
              ",\"name\":\"" +name+"\"}";
     }
	
	
}
 