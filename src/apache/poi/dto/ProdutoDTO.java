package apache.poi.dto;

import java.math.BigDecimal;

import apache.poi.annotation.ExcelReport;

public class ProdutoDTO {

	@ExcelReport(descricaoColuna = "CÓDIGO")
	private Long id;

	@ExcelReport(descricaoColuna = "DESCRIÇÃO")
	private String descricao;

	@ExcelReport(descricaoColuna = "NÚMERO GTIN")
	private Long gtin;

	@ExcelReport(descricaoColuna = "PREÇO")
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
