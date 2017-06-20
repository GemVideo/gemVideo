package importarVideos;

import javax.xml.bind.annotation.XmlElement;

public class Thumbnail {

	  private String url;
	  private String width;
	  private String height;
	  @XmlElement(name="url")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@XmlElement(name="width")
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	@XmlElement(name="height")
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public Thumbnail() {
		super();
		// TODO Auto-generated constructor stub
	}
	  
}
