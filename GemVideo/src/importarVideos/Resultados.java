package importarVideos;

import java.util.ArrayList;
import java.util.List;


public class Resultados {

	private List<Videos> data;
	
	
	public Resultados() {
		data = new ArrayList<>();
	}
	public List<Videos> getResults() {
		return data;
	}
	public void setResults(List<Videos> data) {
		this.data = data;
	}
	
	
	public String toString() {
        return ("Resultado de la llamada. elementos: " + data.size());
	}
}
