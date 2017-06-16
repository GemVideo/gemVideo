package importarVideos;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Artist {
	
	private String name;
	private String mbid;
	private String url;
	private List<Image> image;
	private Bio bio;
	
	@XmlElement(name="image")
	public List<Image> getImage() {
		return image;
	}
	public void setImage(List<Image> image) {
		this.image = image;
	}
	@XmlElement(name="bio")
	public Bio getBio() {
		return bio;
	}
	public void setBio(Bio bio) {
		this.bio = bio;
	}
	public Artist() {
		
		image = new ArrayList<>();
	}
	@XmlElement(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement(name="mbid")
	public String getMbid() {
		return mbid;
	}
	public void setMbid(String mbid) {
		this.mbid = mbid;
	}
	@XmlElement(name="url")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
