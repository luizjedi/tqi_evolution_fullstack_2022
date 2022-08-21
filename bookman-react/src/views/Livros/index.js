import React from 'react';
import { useLinkClickHandler } from 'react-router-dom';
import SearchBar from '../../components/SearchBar';
import * as Css from "./styles";

const LivrosView = () => {
    return (
        <>
            <SearchBar />
            <Css.Container>
                <Css.InputContent>
                    <Css.Button onClick={useLinkClickHandler("/livros/novo")}>Cadastrar Novo Livro na Base de Dados</Css.Button>
                </Css.InputContent>
            </Css.Container>
            <Css.Container>
                <Css.InputContent>
                    <h1 > livro cadastrado 1</h1>
                    <h1 > livro cadastrado 2</h1>
                    <h1 > livro cadastrado 3</h1>
                    <h1 > livro cadastrado 4</h1>
                    <h1 > livro cadastrado 5</h1>
                    <h1 > livro cadastrado 6</h1>
                </Css.InputContent>
            </Css.Container>
        </>
    );
};

export default LivrosView;