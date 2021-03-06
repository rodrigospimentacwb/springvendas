package com.pepper.edu.springvendas;

import com.pepper.edu.springvendas.enums.EstadoPagamentoEnum;
import com.pepper.edu.springvendas.enums.TipoClienteEnum;
import com.pepper.edu.springvendas.model.CategoriaEntity;
import com.pepper.edu.springvendas.model.CidadeEntity;
import com.pepper.edu.springvendas.model.ClienteEntity;
import com.pepper.edu.springvendas.model.EnderecoEntity;
import com.pepper.edu.springvendas.model.EstadoEntity;
import com.pepper.edu.springvendas.model.ItemPedidoEntity;
import com.pepper.edu.springvendas.model.PagamentoComBoletoEntity;
import com.pepper.edu.springvendas.model.PagamentoComCartaoEntity;
import com.pepper.edu.springvendas.model.AbstractPagamentoEntity;
import com.pepper.edu.springvendas.model.PedidoEntity;
import com.pepper.edu.springvendas.model.ProdutoEntity;
import com.pepper.edu.springvendas.repository.CategoriaRepository;
import com.pepper.edu.springvendas.repository.CidadeRepository;
import com.pepper.edu.springvendas.repository.ClienteRepository;
import com.pepper.edu.springvendas.repository.EnderecoRepository;
import com.pepper.edu.springvendas.repository.EstadoRepository;
import com.pepper.edu.springvendas.repository.ItemPedidoRepository;
import com.pepper.edu.springvendas.repository.PagamentoRepository;
import com.pepper.edu.springvendas.repository.PedidoRepository;
import com.pepper.edu.springvendas.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
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

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringVendasApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        CategoriaEntity cat1 = new CategoriaEntity(null, "Inform??tica");
        CategoriaEntity cat2 = new CategoriaEntity(null, "Escrit??rio");
        CategoriaEntity cat3 = new CategoriaEntity(null, "Cama mesa e banho");
        CategoriaEntity cat4 = new CategoriaEntity(null, "Eletr??nicos");
        CategoriaEntity cat5 = new CategoriaEntity(null, "Jardinagem");
        CategoriaEntity cat6 = new CategoriaEntity(null, "Decora????o");
        CategoriaEntity cat7 = new CategoriaEntity(null, "Perfumaria");


        ProdutoEntity p1 = new ProdutoEntity(null, "Computador", 2000.0);
        ProdutoEntity p2 = new ProdutoEntity(null, "Impressora", 800.0);
        ProdutoEntity p3 = new ProdutoEntity(null, "Mouse", 80.0);
        ProdutoEntity p4 = new ProdutoEntity(null, "Mesa de escrit??rio", 300.00);
        ProdutoEntity p5 = new ProdutoEntity(null, "Toalha", 50.00);
        ProdutoEntity p6 = new ProdutoEntity(null, "Colcha", 200.00);
        ProdutoEntity p7 = new ProdutoEntity(null, "TV true color", 1200.00);
        ProdutoEntity p8 = new ProdutoEntity(null, "Ro??adeira", 800.00);
        ProdutoEntity p9 = new ProdutoEntity(null, "Abajour", 100.00);
        ProdutoEntity p10 = new ProdutoEntity(null, "Pendente", 180.00);
        ProdutoEntity p11 = new ProdutoEntity(null, "Shampoo", 90.00);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));
        cat2.getProdutos().addAll(Arrays.asList(p2, p4));
        cat3.getProdutos().addAll(Arrays.asList(p5, p6));
        cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
        cat5.getProdutos().addAll(Arrays.asList(p8));
        cat6.getProdutos().addAll(Arrays.asList(p9, p10));
        cat7.getProdutos().addAll(Arrays.asList(p11));

        p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
        p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
        p4.getCategorias().addAll(Arrays.asList(cat2));
        p5.getCategorias().addAll(Arrays.asList(cat3));
        p6.getCategorias().addAll(Arrays.asList(cat3));
        p7.getCategorias().addAll(Arrays.asList(cat4));
        p8.getCategorias().addAll(Arrays.asList(cat5));
        p9.getCategorias().addAll(Arrays.asList(cat6));
        p10.getCategorias().addAll(Arrays.asList(cat6));
        p11.getCategorias().addAll(Arrays.asList(cat7));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

        EstadoEntity est1 = new EstadoEntity(null, "Minas Gerais");
        EstadoEntity est2 = new EstadoEntity(null, "S??o Paulo");

        CidadeEntity c1 = new CidadeEntity(null, "Uberl??ndia", est1);
        CidadeEntity c2 = new CidadeEntity(null, "S??o Paulo", est2);
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

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        PedidoEntity ped1 = new PedidoEntity(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
        PedidoEntity ped2 = new PedidoEntity(null, sdf.parse("10/10/2017 19:35"), cli1, e2);

        AbstractPagamentoEntity pagto1 = new PagamentoComCartaoEntity(null, EstadoPagamentoEnum.QUITADO, ped1, 6);
        ped1.setPagamento(pagto1);

        AbstractPagamentoEntity pagto2 = new PagamentoComBoletoEntity(null, EstadoPagamentoEnum.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
        ped2.setPagamento(pagto2);

        cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

        pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
        pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

        ItemPedidoEntity ip1 = new ItemPedidoEntity(ped1, p1, 0.00, 1, 2000.00);
        ItemPedidoEntity ip2 = new ItemPedidoEntity(ped1, p3, 0.00, 2, 80.00);
        ItemPedidoEntity ip3 = new ItemPedidoEntity(ped2, p2, 100.00, 1, 800.00);

        ped1.getItens().addAll(Arrays.asList(ip1, ip2));
        ped2.getItens().addAll(Arrays.asList(ip3));

        p1.getItens().addAll(Arrays.asList(ip1));
        p2.getItens().addAll(Arrays.asList(ip3));
        p3.getItens().addAll(Arrays.asList(ip2));

        itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
    }
}
