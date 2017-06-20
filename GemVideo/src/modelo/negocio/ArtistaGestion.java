package modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entidades.Artista;
import entidades.Video;
import modelo.dao.ArtistaRepository;

@Service
public class ArtistaGestion {

	@Autowired
	ArtistaRepository artistaRepo;

	public List<Artista> buscarArtistas(String busqueda) {
		List<Artista> artistas = artistaRepo.findByNombre(busqueda);
		List<Artista> listaCuatroArtistas = new ArrayList<>();
		if (artistas != null) {
			if (artistas.size() < 4) {
				for (int i = 0; i < artistas.size(); i++) {
					listaCuatroArtistas.add(artistas.get(i));
				}
			} else {
				for (int i = 0; i < 4; i++) {
					listaCuatroArtistas.add(artistas.get(i));
				}
			}
		}

		return listaCuatroArtistas;
	}

	public Artista mostrarArtista(Integer idArtista) {

		return artistaRepo.findOne(idArtista);
	}

	@Transactional
	public boolean registro(Artista artista) {
		List<Artista> artistas = artistaRepo.findByNombre(artista.getNombre());
		if (artistas.size() == 0) {
			artistaRepo.save(artista);
			return true;
		} else {
			return false;
		}
	}

	@Transactional
	public boolean actualiza(Artista artista) {
		List<Artista> artistas = artistaRepo.findByNombre(artista.getNombre());
		if (artistas.size() > 0) {
			artistaRepo.save(artista);
			return true;
		} else {
			return false;
		}
	}

	public List<Artista> buscarArtista(Artista artista) {
		List<Artista> artistas = artistaRepo.findByNombre(artista.getNombre());
		if (artistas != null) {
			return artistas;
		} else {
			return null;
		}
	}

}
