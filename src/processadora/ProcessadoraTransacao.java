package processadora;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.domain.LoteImportacao;
import model.domain.PlasticoImportacao;
import model.domain.TransacaoImportacao;

public class ProcessadoraTransacao implements IProcessadoraDefault {
	private LoteImportacao loteImportacao;

	@Override
	public TransacaoImportacao getLinha(String linha) throws ParseException {
		TransacaoImportacao transacao = new TransacaoImportacao();
		
		transacao.setCodigoEstabelecimento(Integer.parseInt(linha.substring(42,48)));
		
		String data = linha.substring(35,40);
		String hora = linha.substring(41,46);
		
		transacao.setDataTransacao(new SimpleDateFormat("ddMMyyyy hhmmss").parse(data + " " + hora ));
		transacao.setDetalhe(linha.charAt(0));
		transacao.setNumeroConta(new Integer(linha.substring(1,7)));
		transacao.setNumeroPlastico(new Integer(linha.substring(8,15)));
		transacao.setValorTransacao(new Double(linha.substring(16,27)));

		return transacao;
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
