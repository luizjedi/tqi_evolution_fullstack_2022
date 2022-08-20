package com.tqi.bookman.service.cadastro;

import com.tqi.bookman.entity.ClienteEntity;
import com.tqi.bookman.entity.EnderecoEntity;
import com.tqi.bookman.repository.IClienteRepository;
import com.tqi.bookman.repository.IEnderecoRepository;
import com.tqi.bookman.service.interface_service.IRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadastroClienteService implements IRestService<ClienteEntity> {

    // Repositórios
    @Autowired
    private IClienteRepository clienteRepository;
    @Autowired
    private IEnderecoRepository enderecoRepository;

    // Get
    @Override
    public Iterable<ClienteEntity> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public ClienteEntity buscarPorId(Long id) throws Exception {
        try {
            Optional<ClienteEntity> cliente = clienteRepository.findById(id);
            return cliente.get();
        } catch (Exception e) {
            throw new Exception("Id inexistente!", e.getCause());
        }
    }

    // Post
    @Override
    public void inserir(ClienteEntity cliente) {
        enderecoRepository.save(cliente.getCepEndereco());
        clienteRepository.save(cliente);
    }

    // Put
    @Override
    public void atualizar(Long id, ClienteEntity cliente) throws Exception {
        if (!this.buscarPorId(id).equals(null)) {
            cliente.setId(id);
            ClienteEntity clienteSalvo = this.buscarPorId(id);
            EnderecoEntity novoEndereco = clienteSalvo.getCepEndereco();
                novoEndereco.setId(clienteSalvo.getId());
                novoEndereco.setCep(cliente.getCepEndereco().getCep());
                novoEndereco.setLogradouro(cliente.getCepEndereco().getLogradouro());
                novoEndereco.setComplemento(cliente.getCepEndereco().getComplemento());
                novoEndereco.setBairro(cliente.getCepEndereco().getBairro());
                novoEndereco.setLocalidade(cliente.getCepEndereco().getLocalidade());
                novoEndereco.setUf(cliente.getCepEndereco().getUf());
                novoEndereco.setDdd(cliente.getCepEndereco().getDdd());
            enderecoRepository.save(novoEndereco);
            cliente.setCepEndereco(novoEndereco);
            clienteRepository.save(cliente);
        }
    }

    // Delete
    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
}
