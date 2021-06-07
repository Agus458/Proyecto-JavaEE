package data_types;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataMuro {

	private Integer id;
	
	private List<DataPost> posts;

	/**
	 * @param id
	 * @param posts
	 */
	public DataMuro(Integer id, List<DataPost> posts) {
		super();
		this.id = id;
		this.posts = posts;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the posts
	 */
	public List<DataPost> getPosts() {
		return posts;
	}
	
}
