package it.sky.sop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import it.sky.sop.excel.export.ExcelField;

@Entity
@Table(name = "SOP_IMPORT")
public class Allarme extends ModelEntity implements Serializable {

	private static final long serialVersionUID = -5653569114853904261L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
    private Integer idAllarme;
	
	@Column(name = "nome_allarme")
	private String nome_allarme;
	
	@Column(name = "modificato_da_sd_in_data")
	private String modificato_da_sd_in_data;
	
	@Column(name = "host")
	private String host;
	
	@Column(name = "sistema_operativo")
	private String sistema_operativo;
	
	@Column(name = "stato_macchina")
	private String stato_macchina;
	
	@Column(name = "stato_allarme")
	private String stato_allarme;
	
	@Column(name = "multimacchina")
	private String multimacchina;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "area_platform")
	private String area_platform;
	
	@Column(name = "severity")
	private String severity;
	
	@Lob
	private String testo_allarme;
	
	@Lob
	private String note_allarme;
	
	@Lob
	private String azioni;
	
	@Lob
	private String escalation;
	
	@Column(name = "scheda_di_monitoraggio")
	private String scheda_di_monitoraggio;
	
	@Column(name = "sop_procedure")
	private String sop_procedure;
	
	@Column(name = "tipo_allarme")
	private String tipo_allarme;
	
	@Column(name = "application")
	private String application;
	
	@Column(name = "message_group")
	private String message_group;
	
	@Column(name = "object")
	private String object;
	
	@Column(name = "message_text")
	private String message_text;
	
	@Column(name = "id_scheda_monitoraggio")
	private String id_scheda_monitoraggio;
	
	@ExcelField(field = "sistema_operativo", position = 3)
	public String getSistema_operativo() {
		return sistema_operativo;
	}

	@ExcelField(field = "sistema_operativo", position = 3)
	public void setSistema_operativo(String sistema_operativo) {
		this.sistema_operativo = sistema_operativo;
	}

	@ExcelField(field = "azioni", position = 12)
	public String getAzioni() {
		return azioni;
	}

	@ExcelField(field = "azioni", position = 12)
	public void setAzioni(String azioni) {
		this.azioni = azioni;
	}

	@ExcelField(field = "nome_allarme", position = 0)
	public String getNome_allarme() {
		return nome_allarme;
	}

	@ExcelField(field = "nome_allarme", position = 0)
	public void setNome_allarme(String nome_allarme) {
		this.nome_allarme = nome_allarme;
	}

	@ExcelField(field = "note_allarme", position = 11)
	public String getNote_allarme() {
		return note_allarme;
	}

	@ExcelField(field = "note_allarme", position = 11)
	public void setNote_allarme(String note_allarme) {
		this.note_allarme = note_allarme;
	}

	@ExcelField(field = "stato_allarme", position = 5)
	public String getStato_allarme() {
		return stato_allarme;
	}

	@ExcelField(field = "stato_allarme", position = 5)
	public void setStato_allarme(String stato_allarme) {
		this.stato_allarme = stato_allarme;
	}

	@ExcelField(field = "testo_allarme", position = 10)
	public String getTesto_allarme() {
		return testo_allarme;
	}

	@ExcelField(field = "testo_allarme", position = 10)
	public void setTesto_allarme(String testo_allarme) {
		this.testo_allarme = testo_allarme;
	}

	@ExcelField(field = "tipo_allarme", position = 16)
	public String getTipo_allarme() {
		return tipo_allarme;
	}
	
	@ExcelField(field = "tipo_allarme", position = 16)
	public void setTipo_allarme(String tipo_allarme) {
		this.tipo_allarme = tipo_allarme;
	}

	@ExcelField(field = "application", position = 17)
	public String getApplication() {
		return application;
	}

	@ExcelField(field = "application", position = 17)
	public void setApplication(String application) {
		this.application = application;
	}

	@ExcelField(field = "escalation", position = 13)
	public String getEscalation() {
		return escalation;
	}

	@ExcelField(field = "escalation", position = 13)
	public void setEscalation(String escalation) {
		this.escalation = escalation;
	}

	@ExcelField(field = "host", position = 2)
	public String getHost() {
		return host;
	}

	@ExcelField(field = "host", position = 2)
	public void setHost(String host) {
		this.host = host;
	}

	@ExcelField(field = "id_scheda_monitoraggio", position = 21)
	public String getId_scheda_monitoraggio() {
		return id_scheda_monitoraggio;
	}

	@ExcelField(field = "id_scheda_monitoraggio", position = 21)
	public void setId_scheda_monitoraggio(String id_scheda_monitoraggio) {
		this.id_scheda_monitoraggio = id_scheda_monitoraggio;
	}

	@ExcelField(field = "stato_macchina", position = 4)
	public String getStato_macchina() {
		return stato_macchina;
	}

	@ExcelField(field = "stato_macchina", position = 4)
	public void setStato_macchina(String stato_macchina) {
		this.stato_macchina = stato_macchina;
	}

	@ExcelField(field = "message_group", position = 18)
	public String getMessage_group() {
		return message_group;
	}

	@ExcelField(field = "message_group", position = 18)
	public void setMessage_group(String message_group) {
		this.message_group = message_group;
	}

	@ExcelField(field = "message_text", position = 20)
	public String getMessage_text() {
		return message_text;
	}

	@ExcelField(field = "message_text", position = 20)
	public void setMessage_text(String message_text) {
		this.message_text = message_text;
	}

	@ExcelField(field = "modificato_da_sd_in_data", position = 1)
	public String getModificato_da_sd_in_data() {
		return modificato_da_sd_in_data;
	}

	@ExcelField(field = "modificato_da_sd_in_data", position = 1)
	public void setModificato_da_sd_in_data(String modificato_da_sd_in_data) {
		this.modificato_da_sd_in_data = modificato_da_sd_in_data;
	}

	@ExcelField(field = "scheda_di_monitoraggio", position = 14)
	public String getScheda_di_monitoraggio() {
		return scheda_di_monitoraggio;
	}

	@ExcelField(field = "scheda_di_monitoraggio", position = 14)
	public void setScheda_di_monitoraggio(String scheda_di_monitoraggio) {
		this.scheda_di_monitoraggio = scheda_di_monitoraggio;
	}

	@ExcelField(field = "multimacchina", position = 6)
	public String getMultimacchina() {
		return multimacchina;
	}

	@ExcelField(field = "multimacchina", position = 6)
	public void setMultimacchina(String multimacchina) {
		this.multimacchina = multimacchina;
	}

	@ExcelField(field = "object", position = 19)
	public String getObject() {
		return object;
	}

	@ExcelField(field = "object", position = 19)
	public void setObject(String object) {
		this.object = object;
	}

	@ExcelField(field = "area_platform", position = 8)
	public String getArea_platform() {
		return area_platform;
	}

	@ExcelField(field = "area_platform", position = 8)
	public void setArea_platform(String area_platform) {
		this.area_platform = area_platform;
	}

	@ExcelField(field = "sop_procedure", position = 15)
	public String getSop_procedure() {
		return sop_procedure;
	}

	@ExcelField(field = "sop_procedure", position = 15)
	public void setSop_procedure(String sop_procedure) {
		this.sop_procedure = sop_procedure;
	}

	@ExcelField(field = "severity", position = 9)
	public String getSeverity() {
		return severity;
	}

	@ExcelField(field = "severity", position = 9)
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	@ExcelField(field = "url", position = 7)
	public String getUrl() {
		return url;
	}

	@ExcelField(field = "url", position = 7)
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the idAllarme
	 */
	public Integer getIdAllarme() {
		return idAllarme;
	}
	/**
	 * @param idAllarme the idAllarme to set
	 */
	public void setIdAllarme(Integer idAllarme) {
		this.idAllarme = idAllarme;
	}
	
}
