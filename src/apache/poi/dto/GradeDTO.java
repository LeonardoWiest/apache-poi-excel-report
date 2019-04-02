package apache.poi.dto;

import java.util.Date;
import java.util.List;

import apache.poi.annotation.ExcelReport;

public class GradeDTO {

	@ExcelReport(descricaoColuna = "CÓDIGO")
	private Long id;

	@ExcelReport(descricaoColuna = "DESCRIÇÃO")
	private String descricao;

	@ExcelReport(descricaoColuna = "DATA INÍCIO")
	private Date dataInicio;

	@ExcelReport(descricaoColuna = "DATA FIM")
	private Date dataFim;

	@ExcelReport(nivel = "1", clazz = { ProdutoDTO.class })
	private List<ProdutoDTO> ProdutoDTO;

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

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public List<ProdutoDTO> getProdutoDTO() {
		return ProdutoDTO;
	}

	public void setProdutoDTO(List<ProdutoDTO> produtoDTO) {
		ProdutoDTO = produtoDTO;
	}

}
