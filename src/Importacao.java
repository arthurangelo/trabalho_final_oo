import java.util.ArrayList;
import java.util.List;

import model.domain.ClienteImportacao;
import model.domain.ImportacaoDefault;
import model.domain.LoteImportacao;
import services.Services;

public class Importacao {
	public static void main(String args[]) throws Exception {

		
		List<String> arquivos = Services.getArquivosProcessar();

		for (String arquivo : arquivos) {

			ProcessadoraArquivo processadora = getProcessadora(arquivo);

			List<ImportacaoDefault> listaImportada = processadora.processaArquivo(arquivo);
			
			System.out.println(listaImportada);
			System.out.println(processadora.getLoteProcessado());
			
			Services.save(processadora.getLoteProcessado());
			
			for(ImportacaoDefault importacao : listaImportada) {
				Services.save(importacao);
			}

		}

	}

	private static ProcessadoraArquivo getProcessadora(String arquivo) {
		IProcessadoraDefault tipoProcessadora = ProcessadorasEnum.getProcessadoraByArquivo(arquivo);

		ProcessadoraArquivo processadora = new ProcessadoraArquivo(tipoProcessadora);
		return processadora;
	}
}
