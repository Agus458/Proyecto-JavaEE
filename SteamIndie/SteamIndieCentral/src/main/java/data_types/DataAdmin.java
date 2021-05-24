package data_types;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataAdmin extends DataUsuario {

	public DataAdmin() {
	}

	public DataAdmin(Integer id, String nombre, String apellido, String email, String password, String nickname) {
		super(id, nombre, apellido, email, password, nickname);
	}

}
