package model.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class LoteImportacao extends ImportacaoDefault {
	private Integer numeroLote;
	private Date dataImportacao;
	private String arquivo;

	public LoteImportacao(String lote, String arquivo) {
		this.numeroLote = new Integer(lote);
		this.arquivo = arquivo;
		this.dataImportacao = getDateAtual();
	}

	@Override
	public String toString() {
		return "LoteImportacao [numeroLote=" + numeroLote + ", dataImportacao=" + dataImportacao + ", arquivo="
				+ arquivo + "]";
	}

	public Integer getNumeroLote() {
		return numeroLote;
	}

	public void setNumeroLote(Integer numeroLote) {
		this.numeroLote = numeroLote;
	}

	public Date getDataImportacao() {
		return dataImportacao;
	}

	public void setDataImportacao(Date dataImportacao) {
		this.dataImportacao = dataImportacao;
	}

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	private Date getDateAtual() {

		return new Date();
	}

}
