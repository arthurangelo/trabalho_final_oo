package processadora;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.domain.ClienteImportacao;
import model.domain.ContaImportacao;
import model.domain.LoteImportacao;

public class ProcessadoraConta implements IProcessadoraDefault {
	private LoteImportacao loteImportacao;

	@Override
	public ContaImportacao getLinha(String linha) throws ParseException {
		ContaImportacao conta = new ContaImportacao();
		conta.setTipo(linha.charAt(1));
		conta.setCpf(linha.substring(2,13));
		conta.setValorLimite(new Double(linha.substring(13,25).trim()));
		conta.setNumercoConta(Integer.parseInt(linha.substring(27,34)));
		conta.setDtVencimento(10);
		return conta;
	}
	@Override
	public List<String> processaLote(List<String> linhas, String arquivo) {
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
