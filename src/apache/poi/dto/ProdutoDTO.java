package apache.poi.dto;

import java.math.BigDecimal;

public class ProdutoDTO {

	private Long id;

	private String descricao;

	private Long gtin;

	private BigDecimal preco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getGtin() {
		return gtin;
	}

	public void setGtin(Long gtin) {
		this.gtin = gtin;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
