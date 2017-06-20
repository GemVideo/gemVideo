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

	public List<Video> buscarVideos(String nombre) {
		
		List<Video> videos = videoRepo.findByTitulo(nombre);
		return videos;
	}

	public List<Video> obtenerPeliculasHome() {
		List<Video> videos = videoRepo.findFirst12ByOrderByTitulo();
		return videos;
	}
	
	@Transactional
	public Video registro(Video video){
		Video videoConfirmado=null;
		List <Video> videos = videoRepo.findByTitulo(video.getTitulo()) ;
		if(videos.size() == 0)
		{
			videoConfirmado=videoRepo.save(video);
			return videoConfirmado;
		}
		else {
			return videoConfirmado;
		}
	}
	
	public PlayList reprodPlaylist(Integer idPlaylist){
		PlayList playList = playlistRepo.findOne(idPlaylist);
		return playList;
	}
	
	
}
