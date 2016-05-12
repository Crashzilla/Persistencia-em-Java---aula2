package br.com.fiap.programa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.fiap.entity.Forum;
import br.com.fiap.entity.Usuario;
import br.com.fiap.helper.ForumHelper;

public class TesteForum {
	public static void main(String[] args){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
		EntityManager em = emf.createEntityManager();
		ForumHelper dao = new ForumHelper(em);
		
		Forum forum = new Forum();
		forum.setAssunto("JPA");
		forum.setDescricao("Java Persistencia API");
		
		System.out.println(dao.salvar(forum));
		
		Usuario u1 = new Usuario();
		u1.setNome("Jose Antonio");
		u1.setEmail("jose@antonio.com.br");
		u1.setForum(forum);
		
		System.out.println(dao.adicionarUsuario(forum.getId(), u1));;
		
		Usuario u2 = new Usuario();
		u1.setNome("Maria Jose");
		u1.setEmail("maria@fiap.com.br");
		u1.setForum(forum);
		
		forum.getUsuarios().add(u2);
		
		JOptionPane.showMessageDialog(null, dao.salvar(forum));
	}
}
