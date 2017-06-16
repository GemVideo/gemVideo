package importarVideos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlElement;

@Embeddable
public class Snippet {
//	private String publishedAt;
//	private String channelId;
	private String title;
	private String description;
	private List<Thumbnails> thumbnails;
	
//	private Thumbnail thumbnails;
	
	@XmlElement(name="title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@XmlElement(name="description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
		
	@XmlElement(name="thumbnails")
	public List<Thumbnails> getThumbnails() {
		return thumbnails;
	}
	public void setThumbnails(List<Thumbnails> thumbnails) {
		this.thumbnails = thumbnails;
	}
	public Snippet() {
		super();
		// TODO Auto-generated constructor stub
		thumbnails = new ArrayList<>();
	}
	
	
}
