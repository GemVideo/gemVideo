package importarVideos;

import javax.xml.bind.annotation.XmlElement;

public class Image {
	
	
	private String texto;
	
	private String size;
	
	@XmlElement(name="#text")
	public String getText() {
		return texto;
	}
	
	public void setText(String text) {
		this.texto = text;
	}
	
	@XmlElement(name="size")
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	
}
