package testsvaga;

import java.util.Date;

import dao.VagaDAO;
import modal.Vaga;
public class VagaTestes {
	public static void main(String[] args) {
			//teste das funções
			testinsertvaga();
			}
		public static void testinsertvaga() {
			//teste de inserção
			Vaga vaga = new Vaga();
			VagaDAO vagadao = new VagaDAO();
			
			vaga.setData_vaga(new Date());
			vaga.setEmpresa("Teste");
			vaga.setExperiencia("Trabalhar 5 anos");
			vaga.setNome_vaga("Analista de Sistemas");
			vaga.setLocal("São Paulo");
			
			vagadao.insertNewVaga(vaga);
		}
		public static void testdeletevaga() {
			//teste de deleção
			VagaDAO vagadao = new VagaDAO();
			vagadao.deleteVaga(6);
		}
		public static void testupdatevaga() {
			//teste de update
			Vaga vaga = new Vaga();
			VagaDAO vagadao = new VagaDAO();
			vaga.setData_vaga(new Date());
			vaga.setEmpresa("Teste");
			vaga.setExperiencia("Trabalhar 5 anos");
			vaga.setNome_vaga("Analista de Sistemas");
			vaga.setLocal("São Paulo");
			vagadao.updateVaga(vaga);
		}
		public static void testselectvaga() {
			//teste de select
			VagaDAO vagadao = new VagaDAO();
			vagadao.getAllVaga();
		}
	
	
	}