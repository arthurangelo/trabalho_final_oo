package model.domain;

import java.util.Date;

public class TransacaoImportacao extends ImportacaoDefault {
	private char detalhe;
	private Integer numeroConta;
	private Integer numeroPlastico;
	private Double valorTransacao;
	private Date dataTransacao;
	private Integer codigoEstabelecimento;
	
	public TransacaoImportacao() {
		
	}
	
	public char getDetalhe() {
		return detalhe;
	}
	public void setDetalhe(char detalhe) {
		this.detalhe = detalhe;
	}
	public Integer getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}
	public Integer getNumeroPlastico() {
		return numeroPlastico;
	}
	public void setNumeroPlastico(Integer numeroPlastico) {
		this.numeroPlastico = numeroPlastico;
	}
	public Double getValorTransacao() {
		return valorTransacao;
	}
	public void setValorTransacao(Double valorTransacao) {
		this.valorTransacao = valorTransacao;
	}
	public Date getDataTransacao() {
		return dataTransacao;
	}
	public void setDataTransacao(Date dataTransacao) {
		this.dataTransacao = dataTransacao;
	}
	public Integer getCodigoEstabelecimento() {
		return codigoEstabelecimento;
	}
	public void setCodigoEstabelecimento(Integer codigoEstabelecimento) {
		this.codigoEstabelecimento = codigoEstabelecimento;
	}
	@Override
	public String toString() {
		return "TransacaoImportacao [detalhe=" + detalhe + ", numeroConta=" + numeroConta + ", numeroPlastico="
				+ numeroPlastico + ", valorTransacao=" + valorTransacao + ", dataTransacao=" + dataTransacao
				+ ", codigoEstabelecimento=" + codigoEstabelecimento + "]";
	}
	
}
