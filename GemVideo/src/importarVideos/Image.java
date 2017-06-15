package importarVideos;

import javax.xml.bind.annotation.XmlElement;

public class Image {
	@XmlElement(name="#text")
	private String text;
	private String size;
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
