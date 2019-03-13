package it.sky.sop.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ALLARME_FILE")
public class AllarmeFile extends ModelEntity implements Serializable {

	private static final long serialVersionUID = 1730322937406616043L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
    private Integer id;
	
	@Column(name = "FILE_NAME")
	private String fileName;

	@Column(name = "LAST_EDIT_OWNER")
	private String lastEditOwner;

	@Column(name = "LAST_EDIT_DATE")
	public String lastEditDate;
	
	@Transient
	List<Allarme> allarme;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the lastEditOwner
	 */
	public String getLastEditOwner() {
		return lastEditOwner;
	}

	/**
	 * @param lastEditOwner the lastEditOwner to set
	 */
	public void setLastEditOwner(String lastEditOwner) {
		this.lastEditOwner = lastEditOwner;
	}

	/**
	 * @return the lastEditDate
	 */
	public String getLastEditDate() {
		return lastEditDate;
	}

	/**
	 * @param lastEditDate the lastEditDate to set
	 */
	public void setLastEditDate(String lastEditDate) {
		this.lastEditDate = lastEditDate;
	}

	/**
	 * @return the allarme
	 */
	public List<Allarme> getAllarme() {
		return allarme;
	}

	/**
	 * @param allarme the allarme to set
	 */
	public void setAllarme(List<Allarme> allarme) {
		this.allarme = allarme;
	}
}
