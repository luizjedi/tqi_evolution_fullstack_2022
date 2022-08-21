import React, { useState } from 'react';
import * as Css from "./styles";

const CompraForm = () => {
    const [titulo, setTitulo] = useState("");
    const [autor, setAutor] = useState("");
    const [editora, setEditora] = useState("");
    const [caminhoImagemLivro, setCaminhoImagemLivro] = useState("");
    const [anoPublicacao, setAnoPublicacao] = useState(null);
    const [quantidade, setQuantidade] = useState("");
    const [valorUnitário, setValorUnitário] = useState("");

    const validaForm = () => {
        if (!titulo || !autor || !editora || !caminhoImagemLivro || !anoPublicacao || !quantidade || !valorUnitário) {
            alert("Preencha todos os campos!");
            return;
        } else if (quantidade < 1 || valorUnitário < 1) {
            alert("O valor precisa ser positivo!");
            return;
        }
    };

    return (
        <>
            <Css.ContainerPage>
                <h1>Nova Compra</h1>
                <Css.Container>
                    <Css.InputLivro>
                        <h3>Livro</h3>
                        <br></br>
                        <Css.Label>Título</Css.Label>
                        <Css.Input value={titulo} onChange={(e) => setTitulo(e.target.value)} />
                        <Css.Label>Imagem do Livro</Css.Label>
                        <Css.Input value={caminhoImagemLivro} onChange={(e) => setCaminhoImagemLivro(e.target.value)} />
                        <Css.Label>Ano de Publicação</Css.Label>
                        <Css.Input value={anoPublicacao} onChange={(e) => setAnoPublicacao(e.target.value)} />
                        <Css.Label>Editora</Css.Label>
                        <Css.Input value={editora} onChange={(e) => setEditora(e.target.value)} />
                        <Css.Label>Autor</Css.Label>
                        <Css.Input value={autor} onChange={(e) => setAutor(e.target.value)} />
                    </Css.InputLivro>
                </Css.Container>
                <Css.Container>
                    <Css.InputContent>
                        <Css.Label>Quantidade</Css.Label>
                        <Css.Input value={quantidade} onChange={(e) => setQuantidade(e.target.value)} />
                    </Css.InputContent>
                </Css.Container>
                <Css.Container>
                    <Css.InputContent>
                        <Css.Label>Valor Unitário</Css.Label>
                        <Css.Input value={valorUnitário} onChange={(e) => setValorUnitário(e.target.value)} />
                    </Css.InputContent>
                </Css.Container>
                <Css.Button onClick={validaForm}>Adicionar</Css.Button>
            </Css.ContainerPage>
        </>
    );
};

export default CompraForm;
