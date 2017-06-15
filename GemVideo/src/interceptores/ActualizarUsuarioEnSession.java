package interceptores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import entidades.Usuario;
import modelo.negocio.UsuarioGestion;

public class ActualizarUsuarioEnSession implements HandlerInterceptor{

	UsuarioGestion usuarioGestion;  
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handle, ModelAndView mav)
			throws Exception {
		if(mav.getViewName().equals("home") || mav.getViewName().equals("playVideo")
				|| mav.getViewName().equals("mostrarArtista")){
			System.out.println("Voy a Actualizar el usuario de session");
			Usuario viejo= (Usuario)request.getSession().getAttribute("usuario");
			Usuario user = usuarioGestion.obtenerPerfil(viejo.getNombre());
			request.getSession().setAttribute("usuario", user);
		}
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

	public UsuarioGestion getUsuarioGestion() {
		return usuarioGestion;
	}

	public void setUsuarioGestion(UsuarioGestion usuarioGestion) {
		this.usuarioGestion = usuarioGestion;
	}

	
}
