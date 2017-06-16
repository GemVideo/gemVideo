package importarVideos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.PROPERTY)
public class Thumbnails {
	
	private Thumbnail default1;
	private Thumbnail medium;
	private Thumbnail high;
	
	@XmlElement(name="default")
	public Thumbnail getDefault1() {
		return default1;
	}
	public void setDefault1(Thumbnail default1) {
		this.default1 = default1;
	}
	@XmlElement(name="medium")
	public Thumbnail getMedium() {
		return medium;
	}
	public void setMedium(Thumbnail medium) {
		this.medium = medium;
	}
	@XmlElement(name="high")
	public Thumbnail getHigh() {
		return high;
	}
	public void setHigh(Thumbnail high) {
		this.high = high;
	}

	public Thumbnails() {
		super();
		// TODO Auto-generated constructor stub
	}

}
