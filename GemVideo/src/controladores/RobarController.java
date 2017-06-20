package controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import importarVideos.ProcesarFicheros;

@Controller
public class RobarController {

	@Autowired
	ProcesarFicheros pf;
	
	@RequestMapping("/robar.do")
	public void robar(){
		pf.procesarVideos();
	}
}
