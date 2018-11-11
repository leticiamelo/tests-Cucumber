package br.ce.wcaquino.servicos;

import java.util.Calendar;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.NotaAluguel;
import br.ce.wcaquino.entidades.TipoAluguel;
import br.ce.wcaquino.utils.DateUtils;

public class AluguelService {

	public NotaAluguel alugar(Filme filme, TipoAluguel tipo) {
		if (filme.getEstoque() ==0) 
			throw new RuntimeException("Filme sem estoque");
		
		NotaAluguel nota = new NotaAluguel();
		switch (tipo){
			case COMUM: 
				nota.setPreco(filme.getAluguel());
				nota.setDataEntrega(DateUtils.obterDiferencaDias(1));
				nota.setPontucao(1);
				break;
			case EXTENDIDO:
				nota.setPreco(filme.getAluguel() * 2);
				nota.setDataEntrega(DateUtils.obterDiferencaDias(3));
				nota.setPontucao(2);
				break;
			case SEMANAL:
				nota.setPreco(filme.getAluguel() * 3);
				nota.setDataEntrega(DateUtils.obterDiferencaDias(7));
				nota.setPontucao(3);
				break;
		}
				
		filme.setEstoque(filme.getEstoque() - 1);
		return nota;
	
	}

}
