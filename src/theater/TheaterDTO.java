package theater;

public class TheaterDTO {

	Integer tid,areacode,project,maxproject,specialp,specialp2,specialp3;
	
	String name;
	
	
	
	
	
	
	
	public TheaterDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Integer getMaxproject() {
		return maxproject;
	}



	public void setMaxproject(Integer maxproject) {
		this.maxproject = maxproject;
	}



	public Integer getSpecialp() {
		return specialp;
	}



	public void setSpecialp(Integer specialp) {
		this.specialp = specialp;
	}



	public Integer getSpecialp2() {
		return specialp2;
	}



	public void setSpecialp2(Integer specialp2) {
		this.specialp2 = specialp2;
	}



	public Integer getSpecialp3() {
		return specialp3;
	}



	public void setSpecialp3(Integer specialp3) {
		this.specialp3 = specialp3;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public Integer getAreacode() {
		return areacode;
	}
	public void setAreacode(Integer areacode) {
		this.areacode = areacode;
	}
	public Integer getProject() {
		return project;
	}
	public void setProject(Integer project) {
		this.project = project;
	}
	
	public String getJSON() {

			return "{ \"areacode\":"+areacode + 
					",\"name\":\"" +name+"\"}";
		}
	
	public String getJSON2() {

		return "{ \"tid\":"+tid + 
				",\"name\":\"" +name+"\"}";
	}
	
	
}
