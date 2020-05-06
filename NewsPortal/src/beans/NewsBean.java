package beans;

public class NewsBean {

	private String headline,description,category;
   private int reporterid ,id;
	public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

	public int getReporterid() {
	return reporterid;
}

public void setReporterid(int reporterid) {
	this.reporterid = reporterid;
}

	public String getheadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
