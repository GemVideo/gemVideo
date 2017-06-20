package modelo.negocio;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entidades.PlayList;
import entidades.Usuario;
import entidades.Video;
import modelo.dao.PlaylistRepository;
import modelo.dao.VideoRepository;


@Service
public class VideoGestion {

	@Autowired
	VideoRepository videoRepo;
	@Autowired
	PlaylistRepository playlistRepo;
	
	public Video playVideo(Integer idVideo){
		Video video = videoRepo.findOne(idVideo);
		return video;
	}
	
	@Transactional
	public void actualizarPlaylist(Integer idPlaylist, Integer idVideo) {
		Video video = videoRepo.findOne(idVideo);
		PlayList playlist = playlistRepo.findOne(idPlaylist);
		playlist.getListaVideos().add(video);
		playlistRepo.save(playlist);
	}

	public List<Video> buscarVideos(String busqueda) {
		
		List<Video> videos = videoRepo.findByTitulo(busqueda);
		return videos;
	}

	public List<Video> obtenerPeliculasHome() {
		List<Video> videos = videoRepo.findFirst12ByOrderByTitulo();
		return videos;
	}
	
	@Transactional
	public boolean registro(Video video){
		List <Video> videos = videoRepo.findByTitulo(video.getTitulo()) ;
		if(videos  == null){
			videoRepo.save(video);
			return true;
		}
		else {
			return false;
		}
	}
}
