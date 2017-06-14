package modelo.negocio;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import controladores.List;
import controladores.Video;

@Service
public class VideoGestion {

	VideoRepo videoRepo;
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
}
