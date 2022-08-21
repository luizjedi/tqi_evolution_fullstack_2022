import React from 'react';
import { useLinkClickHandler } from 'react-router-dom';
import SearchBar from '../../components/SearchBar';
import * as Css from "./styles";

const ComprasView = () => {
    return (
        <>
        <SearchBar />
            <Css.Container>
                <Css.InputContent>
                    <Css.Button onClick={useLinkClickHandler("/compras/novo")}>Cadastrar Novo Registro de Compra</Css.Button>
                </Css.InputContent>
            </Css.Container>
            <Css.Container>
                <Css.InputContent>
                    <h1 > Compra realizada 1</h1>
                    <h1 > Compra realizada 2</h1>
                    <h1 > Compra realizada 3</h1>
                    <h1 > Compra realizada 4</h1>
                    <h1 > Compra realizada 5</h1>
                    <h1 > Compra realizada 6</h1>
                </Css.InputContent>
            </Css.Container>
        </>
    );
};

export default ComprasView;