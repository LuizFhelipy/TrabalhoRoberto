package testsvaga;

import java.util.Date;

import dao.VagaDAO;
import modal.Vaga;
public class Insertvaga {
	public static void main(String[] args) {
	Vaga vaga = new Vaga();
	VagaDAO vagadao = new VagaDAO();
	
	vaga.setData_vaga(new Date());
	vaga.setEmpresa("Teste");
	vaga.setExperiencia("Trabalhar 5 anos");
	vaga.setNome_vaga("Analista de Sistemas");
	vaga.setLocal("São Paulo");
	
	vagadao.insertNewVaga(vaga);
	
	
	}
}
