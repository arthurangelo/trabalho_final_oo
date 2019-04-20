import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.domain.ClienteImportacao;
import model.domain.LoteImportacao;

public class ProcessadoraCliente implements IProcessadoraDefault {
	
	private LoteImportacao loteImportacao;
	
	@Override
	public ClienteImportacao getLinha(String linha) throws ParseException {
		ClienteImportacao cliente = new ClienteImportacao();
		cliente.setTipo(linha.charAt(1));
		cliente.setCpf(linha.substring(2,13));
		cliente.setNome(linha.substring(13,43).trim());
		cliente.setEndereco(linha.substring(43,73).trim());
		cliente.setBairro(linha.substring(73,103).trim());
		cliente.setCidade(linha.substring(103,133).trim());
		cliente.setEstado(linha.substring(133,135));
		String dataCadastro = linha.substring(135,143);
		String horaCadastro = linha.substring(143,149);
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy hhmmss");
		cliente.setDataHoraCadastro(sdf.parse(dataCadastro+" "+horaCadastro));
		return cliente;
	}

	@Override
	public List<String> processaLote(List<String> linhas,String arquivo) {
		loteImportacao = new LoteImportacao(linhas.get(0), arquivo );
		linhas.remove(0);
		return linhas;
	}

	@Override
	public LoteImportacao getLote() {
		return this.loteImportacao;
	}

	@Override
	public void setLoteImportacao(LoteImportacao lote) {
		this.loteImportacao = lote;
		
	}
	

}
