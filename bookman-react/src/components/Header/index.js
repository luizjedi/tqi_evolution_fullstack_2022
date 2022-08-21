import React from 'react';
import * as Css from "./styles";
import { useLinkClickHandler } from 'react-router-dom';

const Header = () => {
    return (
        <Css.Container>
            <Css.Header>
                <Css.Title onClick={useLinkClickHandler("/")}>BookMan</Css.Title>
                <Css.SubTitle>Gerencie suas compras, vendas e estoque de livros</Css.SubTitle>
            </Css.Header>
        </Css.Container>
    );
};

export default Header;
