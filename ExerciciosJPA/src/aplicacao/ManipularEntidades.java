package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dominio.Aereo;
import dominio.Contratado;
import dominio.Departamento;
import dominio.Efetivo;
import dominio.Empregado;
import dominio.Endereco;
import dominio.Sexo;
import dominio.Terrestre;
import dominio.Veiculo;

public class ManipularEntidades {

	public static void persiste(Object obj, EntityManager em){
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(obj);
		et.commit();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExerciciosJPA");
		EntityManager em = emf.createEntityManager();
		
		
		Departamento departamento = new Departamento();
		departamento.setId(170);
		departamento.setNome("DCOMP");
		
		persiste(departamento, em);
		
		Endereco endereco = new Endereco();
		endereco.setCep("49.150-000");
		endereco.setCidade("Aracaju");
		endereco.setRua("Rua A");
		endereco.setSgEstado("SE");	
		
		
		Empregado efetivo1 = new Efetivo("Monteiro", Sexo.MASCULINO, 10000.54);
		Empregado efetivo2 = new Efetivo("Debora", Sexo.FEMININO, 10000.10);
		Empregado contratado = new Contratado("André", Sexo.MASCULINO, 2000.25);
		
		efetivo1.setEndereco(endereco);
		efetivo1.setDepartamento(departamento);
		
		efetivo2.setEndereco(endereco);
		efetivo2.setDepartamento(departamento);
		
		contratado.setEndereco(endereco);
		contratado.setDepartamento(departamento);
		
		persiste(efetivo1, em);
		persiste(efetivo2, em);
		persiste(contratado, em);
		
		
		departamento.addEmpregado(efetivo1);
		departamento.addEmpregado(efetivo2);
		departamento.addEmpregado(contratado);
		
		//Adicionando Veículos
		Veiculo terrestre1 = new Terrestre("Carro", 5, "HZH-4567");
		terrestre1.addDepartamento(departamento);
		
		Veiculo terrestre2 = new Terrestre("Moto", 2, "HZH-7890");
		terrestre2.addDepartamento(departamento);
		
		Veiculo aereo = new Aereo("Aviao", 100, "XXX-Registro");
		aereo.addDepartamento(departamento);
	
		
		persiste(terrestre1, em);
		persiste(terrestre2, em);
		persiste(aereo, em);
		
		
		departamento.addVeiculo(terrestre1);
		departamento.addVeiculo(terrestre2);
		departamento.addVeiculo(aereo);
		
		
		//Criando Novo Departamento e associando um veículo ao mesmo.
		departamento = new Departamento();
		departamento.setId(210);
		departamento.setNome("DMAT");
		departamento.addVeiculo(terrestre1);
		
		
		persiste(departamento, em);
		
		
		
		em.getTransaction().begin();
		terrestre1.addDepartamento(departamento);
		em.getTransaction().commit();
		
		
		//Listando funcionarios
		Query query = em.createQuery("SELECT d FROM Departamento d");
		
		departamento = (Departamento) query.getResultList().get(0);
		
		System.out.println("\n##### " + departamento.getNome() + " ####");
		System.out.println("##### LISTANDO FUNCIONARIOS ####");
		
		for (Empregado e:departamento.getEmpregados()){
			System.out.println("\nNome: " + e.getNome());
			
			if (e.getClass() == Efetivo.class){
				System.out.println("Salario: " + ((Efetivo) e).getSalario());
			} else if (e.getClass() == Contratado.class){
				System.out.println("Custo Hora: " + ((Contratado) e).getCustoHora());
			}
		}
		
		
		System.out.println("\n#### LISTANDO VEICULOS ####");
		for (Veiculo v: departamento.getVeiculos()){
			System.out.println("\nDescricao: " + v.getDescricao());
			
			if (v.getClass() == Terrestre.class){
				System.out.println("Placa: " + ((Terrestre) v).getPlaca());
			} else if (v.getClass() == Aereo.class){
				System.out.println("Registro: " + ((Aereo) v).getRegistro());
			}
		}
		
		em.close();
		emf.close();
		
	}

}
