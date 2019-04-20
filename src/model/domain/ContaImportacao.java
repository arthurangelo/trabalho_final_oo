package model.domain;

import java.util.Date;

public class ContaImportacao extends ImportacaoDefault {
	private char tipo;
	private String detalhe;
	private String cpf;
	private Double valorLimite;
	private Integer dtVencimento;
	private Integer numercoConta;
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	public String getDetalhe() {
		return detalhe;
	}
	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Double getValorLimite() {
		return valorLimite;
	}
	public void setValorLimite(Double valorLimite) {
		this.valorLimite = valorLimite;
	}
	public Integer getDtVencimento() {
		return dtVencimento;
	}
	public void setDtVencimento(Integer dtVencimento) {
		this.dtVencimento = dtVencimento;
	}
	public Integer getNumercoConta() {
		return numercoConta;
	}
	public void setNumercoConta(Integer numercoConta) {
		this.numercoConta = numercoConta;
	}
	@Override
	public String toString() {
		return "ContaImportacao [tipo=" + tipo + ", detalhe=" + detalhe + ", cpf=" + cpf + ", valorLimite="
				+ valorLimite + ", dtVencimento=" + dtVencimento + ", numercoConta=" + numercoConta + "]";
	}
}
