import java.sql.Connection;

import model.contato.ContatoVO;
import model.contato.dao.IContatoDAO;
import model.contato.dao.ContatoDAO;
import services.ContatoService;
import utils.ConnectionFactory;

public class Playground {
    public static void main(String[] args) {
        try {
            // Criando a conexão com o banco de dados
            ConnectionFactory connectionFactory = new ConnectionFactory();
            Connection connection = connectionFactory.getConnection();

            // Criando o DAO e o Service
            IContatoDAO contatoDAO = new ContatoDAO(connection);
            ContatoService contatoService = new ContatoService(contatoDAO);

            // Criando e persistindo os contatos
            ContatoVO contato1 = new ContatoVO();
            contato1.setNome("John Doe");
            contato1.setEmail("john.doe@example.com");
            contatoService.salvar(contato1);

            ContatoVO contato2 = new ContatoVO();
            contato2.setNome("Jane Doe");
            contato2.setEmail("jane.doe@example.com");
            contatoService.salvar(contato2);

            ContatoVO contato3 = new ContatoVO();
            contato3.setNome("Alice Smith");
            contato3.setEmail("alice.smith@example.com");
            contatoService.salvar(contato3);

            System.out.println("Contatos persistidos com sucesso!");

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
