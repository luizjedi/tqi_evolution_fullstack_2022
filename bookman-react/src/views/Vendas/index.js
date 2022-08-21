import React from 'react';
import { useLinkClickHandler } from 'react-router-dom';
import SearchBar from '../../components/SearchBar';
import * as Css from "./styles";

const VendasView = () => {
    return (
        <>
            <SearchBar />
            <Css.Container>
                <Css.InputContent>
                    <Css.Button onClick={useLinkClickHandler("/vendas/novo")}>Cadastrar Novo Registro de Venda</Css.Button>
                </Css.InputContent>
            </Css.Container>
            <Css.Container>
                <Css.InputContent>
                    <h1 > Venda realizada 1</h1>
                    <h1 > Venda realizada 2</h1>
                    <h1 > Venda realizada 3</h1>
                    <h1 > Venda realizada 4</h1>
                    <h1 > Venda realizada 5</h1>
                    <h1 > Venda realizada 6</h1>
                </Css.InputContent>
            </Css.Container>
        </>
    );
};

export default VendasView;