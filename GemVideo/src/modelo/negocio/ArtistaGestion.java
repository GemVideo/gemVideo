package modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entidades.Artista;
import modelo.dao.ArtistaRepository;

@Service
public class ArtistaGestion {

	@Autowired
	ArtistaRepository artistaRepo;

	public List<Artista> buscarArtistas(String busqueda) {
		List<Artista> artistas = artistaRepo.findByNombre(busqueda);
		List<Artista> listaCuatroArtistas = new ArrayList<>();
		if (artistas != null) {
			for (int i = 0; i < 4; i++) {
				listaCuatroArtistas.add(artistas.get(i));
			}
		}
		return listaCuatroArtistas;
	}

	public Artista mostrarArtista(Integer idArtista) {

		return artistaRepo.findOne(idArtista);
	}

}
