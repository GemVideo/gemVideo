package importarVideos;

import java.util.ArrayList;
import java.util.List;


public class Resultados {

//	 private String kind;
//	 private String etag;
//	 private String nextPageToken;
//	 private String pageInfo;
//	 private String totalResults;
//	 private String resultsPerPage;
	
	private List<Videos> items;
	
//	private String channelTitle;
//	private String type;
	
	public List<Videos> getItems() {
		return items;
	}
	public void setItems(List<Videos> items) {
		this.items = items;
	}
	public Resultados() {
		items = new ArrayList<>();
	}
	public List<Videos> getResults() {
		return items;
	}
	public void setResults(List<Videos> data) {
		this.items = data;
	}
	
	
	public String toString() {
        return ("Resultado de la llamada. elementos: " + items.size());
	}
}
