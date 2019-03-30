package apache.poi.dto;

import java.util.Date;
import java.util.List;

import apache.poi.annotation.ExcelReport;

public class GradeDTO {

	private Long id;

	private String descricao;

	private Date dataInicio;

	private Date dataFim;

	@ExcelReport(nivel = "1")
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
