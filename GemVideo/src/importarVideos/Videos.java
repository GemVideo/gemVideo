package importarVideos;

import javax.persistence.Embedded;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)

public class Videos {
	
	 private String kind;
	 
	private String etag;
	 
	private String id;
	@Embedded 
	private Snippet snippet; 
	 
	 
}
