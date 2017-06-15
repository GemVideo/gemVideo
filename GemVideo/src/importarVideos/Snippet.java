package importarVideos;

import javax.persistence.Embeddable;

@Embeddable
public class Snippet {
	private String publishedAt;
	private String channelId;
	private String title;
	private String description;
	private Thumbnail thumbnails;
}
