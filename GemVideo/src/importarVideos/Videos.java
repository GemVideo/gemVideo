package importarVideos;

import javax.persistence.Embedded;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;




public class Videos {
	
//	 private String kind;
//	 
//	private String etag;
//	 
//	private String id;
	
	private Snippet snippet;
	
	private Id id;

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public Snippet getSnippet() {
		return snippet;
	}

	public void setSnippet(Snippet snippet) {
		this.snippet = snippet;
	} 
	 
	 
}
