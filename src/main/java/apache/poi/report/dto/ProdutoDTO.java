package apache.poi.report.dto;

import java.math.BigDecimal;

public class ProdutoDTO {

	public Long id;

	public String descricao;

	public Long gtin;

	public String unidadeMedida;

	public Long qtdeEmbalagem;

	public BigDecimal valor;

	public BigDecimal valorDisponivel;

	public Long qtdeMinima;

	public Long qtdeMaxima;

	public Long qtdeMultipla;

	public String prefixo;

	public ProdutoDTO(Long id, String descricao, Long gtin, String unidadeMedida, Long qtdeEmbalagem, BigDecimal valor,
			BigDecimal valorDisponivel, Long qtdeMinima, Long qtdeMaxima, Long qtdeMultipla, String prefixo) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.gtin = gtin;
		this.unidadeMedida = unidadeMedida;
		this.qtdeEmbalagem = qtdeEmbalagem;
		this.valor = valor;
		this.valorDisponivel = valorDisponivel;
		this.qtdeMinima = qtdeMinima;
		this.qtdeMaxima = qtdeMaxima;
		this.qtdeMultipla = qtdeMultipla;
		this.prefixo = prefixo;
	}

}
