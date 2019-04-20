package model.domain;

public class PlasticoImportacao extends ImportacaoDefault {
	private String detalhe;
	private Integer conta;
	private String nomeCartao;
	private String cpf;
	private String numeroPlasticoGerado;

	public PlasticoImportacao() {

	}

	public String getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}

	public Integer getConta() {
		return conta;
	}

	public void setConta(Integer conta) {
		this.conta = conta;
	}

	public String getNomeCartao() {
		return nomeCartao;
	}

	public void setNomeCartao(String nomeCartao) {
		this.nomeCartao = nomeCartao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumeroPlasticoGerado() {
		return numeroPlasticoGerado;
	}

	public void setNumeroPlasticoGerado(String numeroPlasticoGerado) {
		this.numeroPlasticoGerado = numeroPlasticoGerado;
	}

	@Override
	public String toString() {
		return "PlasticoImportacao [detalhe=" + detalhe + ", conta=" + conta + ", nomeCartao=" + nomeCartao + ", cpf="
				+ cpf + ", numeroPlasticoGerado=" + numeroPlasticoGerado + "]";
	}
}
