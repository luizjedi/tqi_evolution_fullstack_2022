import React, { useState } from 'react';
import * as Css from "./styles";

const LivroForm = () => {
    const [titulo, setTitulo] = useState("");
    const [autor, setAutor] = useState("");
    const [editora, setEditora] = useState("");
    const [caminhoImagemLivro, setCaminhoImagemLivro] = useState("");
    const [anoPublicacao, setAnoPublicacao] = useState(null);

    const validaForm = () => {
        if (!titulo || !autor || !editora || !caminhoImagemLivro || !anoPublicacao) {
            alert("Preencha todos os campos!");
            return;
        } else if (anoPublicacao < 1) {
            alert("O ano precisa ser positivo!");
            return;
        }
    };

    return (
        <>
            <Css.ContainerPage>
            <h1>Novo Livro</h1>
                <Css.Container>
                    <Css.InputContent>
                        <Css.Label>Título</Css.Label>
                        <Css.Input value={titulo} onChange={(e) => setTitulo(e.target.value)} />
                    </Css.InputContent>
                </Css.Container>
                <Css.Container>
                    <Css.InputContent>
                        <Css.Label>Autor</Css.Label>
                        <Css.Input value={autor} onChange={(e) => setAutor(e.target.value)} />
                    </Css.InputContent>
                </Css.Container>
                <Css.Container>
                    <Css.InputContent>
                        <Css.Label>Editora</Css.Label>
                        <Css.Input value={editora} onChange={(e) => setEditora(e.target.value)} />
                    </Css.InputContent>
                </Css.Container>
                <Css.Container>
                    <Css.InputContent>
                        <Css.Label>Imagem do Livro</Css.Label>
                        <Css.Input value={caminhoImagemLivro} onChange={(e) => setCaminhoImagemLivro(e.target.value)} />
                    </Css.InputContent>
                </Css.Container>
                <Css.Container>
                    <Css.InputContent>
                        <Css.Label>Ano de Publicação</Css.Label>
                        <Css.Input value={anoPublicacao} onChange={(e) => setAnoPublicacao(e.target.value)} />
                    </Css.InputContent>
                </Css.Container>
                <Css.Button onClick={validaForm}>Adicionar</Css.Button>
            </Css.ContainerPage>
        </>
    );
};

export default LivroForm;
