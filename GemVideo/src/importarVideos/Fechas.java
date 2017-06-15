package importarVideos;

import java.util.ArrayList;

public class Fechas {
	private ArrayList <Fecha> fechaItems = new ArrayList();
	
	public ArrayList<Fecha> getFechaItems() {
		return fechaItems;
	}

	public void setFechaItems(ArrayList<Fecha> fechaItems) {
		this.fechaItems = fechaItems;
	}

	public Fechas(int numeFechas){
		//2017-06-01T00:00:00Z
		 int anio=2017;
		 int mes=1;
		 int dia=1;
		 Fecha auxFecha;
		 for (int cont=0;cont<numeFechas;cont++){
			 auxFecha=new Fecha();
			 String fecha = anio + "-" + mes + "-" + dia ;
			 auxFecha.setDesde(fecha );
			 fecha = anio + "-" + (mes+1) + "-" + dia ;
			 auxFecha.setHasta(fecha );
			 
			 fechaItems.add(auxFecha);
		 }
		
	}
}
