package com.tqi.bookman.service.gestao;

import com.tqi.bookman.controller.cadastro.CadastroClienteController;
import com.tqi.bookman.entity.CompraEntity;
import com.tqi.bookman.entity.LivroEntity;
import com.tqi.bookman.entity.VendaEntity;
import com.tqi.bookman.repository.ICompraRepository;
import com.tqi.bookman.repository.IVendaRepository;
import com.tqi.bookman.service.interface_service.IRestService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VendaLivroService implements IRestService<VendaEntity> {

    // Repositórios
    @Autowired
    private IVendaRepository vendaRepository;
    @Autowired
    private ICompraRepository compraRepository;

    // Listas de controle
    private Iterable<CompraEntity> compraEstoque;
    private List<LivroEntity> livrosEstoque = new ArrayList<>();
    private List<String> titulosLivrosVendidos = new ArrayList<>();

    // Atributo
    private double precoTotalVenda = 0;


    // Get
    @Override
    public Iterable<VendaEntity> buscarTodos() {
        return vendaRepository.findAll();
    }

    @Override
    public VendaEntity buscarPorId(Long id) throws Exception {
        try {
            Optional<VendaEntity> venda = vendaRepository.findById(id);
            return venda.get();
        } catch (Exception e) {
            throw new Exception("Id inexistente!", e.getCause());
        }
    }

    // Post
    @Override
    public void inserir(VendaEntity venda) throws IOException {
        // Buscando livros em estoque
        this.buscarLivrosEstoque();
        // Checando se o livro da venda existe em estoque, adicionando na lista de venda e dando baixa no estoque
        this.controleDeEstoque(venda);
        venda.setQuantidadeItens((long) titulosLivrosVendidos.size());
        venda.setPrecoVenda(precoTotalVenda);
        vendaRepository.save(venda);
        this.imprimirVenda(titulosLivrosVendidos, venda);
        this.limparParametros();
    }

    // Put
    @Override
    public void atualizar(Long id, VendaEntity venda) throws Exception {
        if (!this.buscarPorId(id).equals(null)) {
            venda.setId(id);
            vendaRepository.save(venda);
        }
    }

    // Delete
    @Override
    public void deletar(Long id) {
        vendaRepository.deleteById(id);
    }

    // Métodos
    private void imprimirVenda(@NotNull List<String> livros, @NotNull VendaEntity venda) {
        System.out.println(venda.toString());
        System.out.println(venda.getCliente().toString());
        System.out.println("========== Livros ===========");
        livros.forEach(titulos -> {
            System.out.println(titulos);
        });
        System.out.println("=============================");
    }

    private void limparParametros(){
        livrosEstoque.clear();
        titulosLivrosVendidos.clear();
        precoTotalVenda = 0;
    }
    private void controleDeEstoque(@NotNull VendaEntity venda) {
        venda.getIdLivros().forEach(idLivro -> {
            Optional<CompraEntity> estoque = compraRepository.findById(idLivro);
            Long quantidadeItemEstoque = estoque.get().getQuantidade();
            if (livrosEstoque.contains(estoque.get().getLivro())) {
                --quantidadeItemEstoque;
                estoque.get().setQuantidade(quantidadeItemEstoque);
                titulosLivrosVendidos.add(estoque.get().getLivro().getTitulo());
                precoTotalVenda += estoque.get().getValorUnitário();
            }
        });
    }

    private void buscarLivrosEstoque() {
        compraEstoque = compraRepository.findAll();
        try {
            if (!compraEstoque.equals(null)) {
                compraEstoque.forEach(compra -> {
                    if (compra.getQuantidade() > 0) {
                        livrosEstoque.add(compra.getLivro());
                    }
                });
            }
        } catch (Exception e) {
            throw new RuntimeException("Sem unidades disponíveis em estoque!", e);
        }
    }
}