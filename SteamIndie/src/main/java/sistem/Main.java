package sistem;

import controller.UsuarioControllerLocal;
import model.DataTypes.DataUsuario;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UsuarioControllerLocal controller = Fabric.getUsuarioController();
		DataUsuario du = new DataUsuario(null, "Agustin", "Peraza", 20, "aguspe458@outlook.com", "1234");
		controller.registrarUsuario(du);
	}

}
