package modal;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="candidatos")
public class Candidatos implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    @Column(name = "id_candidatos")
    private Integer id_candidato;

    @Column(name="nome_candidatos")
    private String  nome_candidato;

    @Column(name="curriculo")
    private String curriculo;

    @Column(name="endereco")
    private String endereco;
    
    @ManyToOne
    @JoinColumn(name="id_vaga")
    private Vaga vaga;

	public Integer getId_candidato() {
		return id_candidato;
	}

	public void setId_candidato(Integer id_candidato) {
		this.id_candidato = id_candidato;
	}

	public String getNome_candidato() {
		return nome_candidato;
	}

	public void setNome_candidato(String nome_candidato) {
		this.nome_candidato = nome_candidato;
	}

	public String getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(String curriculo) {
		this.curriculo = curriculo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

}
