package importarVideos;

import javax.xml.bind.annotation.XmlElement;

public class Image {
	
	private String text;
	private String size;
	
	@XmlElement(name="#text")
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
}
