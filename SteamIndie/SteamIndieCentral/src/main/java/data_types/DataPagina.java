package data_types;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataPagina {

	public Integer pagina;
	public Integer cantPaginas;
	public List<DataPost> data;

	/**
	 * @param pagina
	 * @param cantPaginas
	 * @param data
	 */
	public DataPagina(Integer pagina, Integer cantPaginas, List<DataPost> data) {
		super();
		this.pagina = pagina;
		this.cantPaginas = cantPaginas;
		this.data = data;
	}

	/**
	 * @return the pagina
	 */
	public Integer getPagina() {
		return pagina;
	}

	/**
	 * @return the cantPaginas
	 */
	public Integer getCantPaginas() {
		return cantPaginas;
	}

	/**
	 * @return the data
	 */
	public List<DataPost> getData() {
		return data;
	}

}
