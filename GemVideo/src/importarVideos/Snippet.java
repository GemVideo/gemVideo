package importarVideos;

import javax.persistence.Embeddable;

@Embeddable
public class Snippet {
//	private String publishedAt;
//	private String channelId;
	private String title;
	private String description;
//	private Thumbnail thumbnails;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
