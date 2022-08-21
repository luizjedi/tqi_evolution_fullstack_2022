import React, { useState } from 'react';
import * as Css from "./styles";

const VendaForm = () => {
    const [cepCliente, setCepCliente] = useState("");
    const [email, setEmail] = useState("");
    const [cpfCliente, setCpfCliente] = useState("");
    const [dataNascimento, setDataNascimento] = useState("");
    const [nome, setNome] = useState("");
    const [telefone, setTelefone] = useState(null);
    const [idLivros, setIdLivros] = useState("");
    const [quantidade, setQuantidade] = useState("");
    const [precoVenda, setPrecoVenda] = useState("");

    const validaForm = () => {
        if (!cepCliente || !email || !cpfCliente || !dataNascimento || !nome || !telefone || quantidade || !precoVenda) {
            alert("Preencha todos os campos!");
            return;
        } else if (quantidade < 1 || precoVenda < 1) {
            alert("O valor precisa ser positivo!");
            return;
        }
    };

    return (
        <>
            <Css.ContainerPage>
                <h1>Nova Venda</h1>
                <Css.Container>
                    <Css.InputCliente>
                        <h3>Cliente</h3>
                        <br></br>
                        <Css.Label>Nome</Css.Label>
                        <Css.Input value={nome} onChange={(e) => setNome(e.target.value)} />
                        <Css.Label>Email</Css.Label>
                        <Css.Input value={email} onChange={(e) => setEmail(e.target.value)} />
                        <Css.Label>Cpf</Css.Label>
                        <Css.Input value={cpfCliente} onChange={(e) => setCpfCliente(e.target.value)} />
                        <Css.Label>Data de Nascimento</Css.Label>
                        <Css.Input value={dataNascimento} onChange={(e) => setDataNascimento(e.target.value)} />
                        <Css.Label>Telefone</Css.Label>
                        <Css.Input value={telefone} onChange={(e) => setTelefone(e.target.value)} />
                        <Css.Label>Cep</Css.Label>
                        <Css.Input value={cepCliente} onChange={(e) => setCepCliente(e.target.value)} />
                    </Css.InputCliente>
                </Css.Container>
                <Css.Container>
                    <Css.InputContent>
                        <Css.Label>Livros</Css.Label>
                        <Css.Input value={quantidade} onChange={(e) => setIdLivros(e.target.value)} />
                    </Css.InputContent>
                </Css.Container>
                <Css.Container>
                    <Css.InputContent>
                        <Css.Label>Quantidade</Css.Label>
                        <Css.Input value={idLivros} onChange={(e) => setQuantidade(e.target.value)} />
                    </Css.InputContent>
                </Css.Container>
                <Css.Container>
                    <Css.InputContent>
                        <Css.Label>Valor da Venda</Css.Label>
                        <Css.Input value={precoVenda} onChange={(e) => setPrecoVenda(e.target.value)} />
                    </Css.InputContent>
                </Css.Container>
                <Css.Button onClick={validaForm}>Adicionar</Css.Button>
            </Css.ContainerPage>
        </>
    );
};

export default VendaForm;

