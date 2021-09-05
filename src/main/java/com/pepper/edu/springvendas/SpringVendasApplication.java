package com.pepper.edu.springvendas;

import com.pepper.edu.springvendas.enums.TipoClienteEnum;
import com.pepper.edu.springvendas.model.CategoriaEntity;
import com.pepper.edu.springvendas.model.CidadeEntity;
import com.pepper.edu.springvendas.model.ClienteEntity;
import com.pepper.edu.springvendas.model.EnderecoEntity;
import com.pepper.edu.springvendas.model.EstadoEntity;
import com.pepper.edu.springvendas.model.ProdutoEntity;
import com.pepper.edu.springvendas.repository.CategoriaRepository;
import com.pepper.edu.springvendas.repository.CidadeRepository;
import com.pepper.edu.springvendas.repository.ClienteRepository;
import com.pepper.edu.springvendas.repository.EnderecoRepository;
import com.pepper.edu.springvendas.repository.EstadoRepository;
import com.pepper.edu.springvendas.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringVendasApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringVendasApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        CategoriaEntity cat1 = new CategoriaEntity(null, "Informática");
        CategoriaEntity cat2 = new CategoriaEntity(null, "Escritório");

        ProdutoEntity p1 = new ProdutoEntity(null, "Computador", 2000.0);
        ProdutoEntity p2 = new ProdutoEntity(null, "Impressora", 800.0);
        ProdutoEntity p3 = new ProdutoEntity(null, "Mouse", 80.0);

        cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

        EstadoEntity est1 = new EstadoEntity(null, "Minas Gerais");
        EstadoEntity est2 = new EstadoEntity(null, "São Paulo");

        CidadeEntity c1 = new CidadeEntity(null, "Uberlândia", est1);
        CidadeEntity c2 = new CidadeEntity(null, "São Paulo", est2);
        CidadeEntity c3 = new CidadeEntity(null, "Campinas", est2);

        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2, c3));

        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

        ClienteEntity cli1 = new ClienteEntity(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoClienteEnum.PESSOAFISICA);

        cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));

        EnderecoEntity e1 = new EnderecoEntity(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
        EnderecoEntity e2 = new EnderecoEntity(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);

        cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

        clienteRepository.saveAll(Arrays.asList(cli1));
        enderecoRepository.saveAll(Arrays.asList(e1, e2));
    }
}
