package modelo.negocio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;


@Service
public class VideoGestion {

	VideoRepository videoRepo;
	PlaylistRepository playlistRepo;
	
	public Video playVideo(Integer idVideo){
		Video video = videoRepo.find(idVideo);
		return video;
	}
	
	@Transactional
	public void actualizarPlaylist(Integer idPlaylist, Integer idVideo) {
		Video video = videoRepo.find(idVideo);
		PlayList playlist = playlistRepo.find(idPlaylist);
		playlist.getListaVideos().add(video);
		playlistRepo.save(playlist);
	}

	public List<Video> buscarVideos(String busqueda) {
		
		List<Video> videos = videoRepo.buscarVideosPorNombre(busqueda);
		return videos;
	}

	public List<Video> obtenerPeliculasHome() {
		return videoRepo.obtenerPeliculasHome();
		
	}
}
