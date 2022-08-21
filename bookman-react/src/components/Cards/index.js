import React from 'react';
import * as Css from "./styles";
import CardItem from '../CardItem';

import {
        GiWhiteBook,
        GiPayMoney,
        GiReceiveMoney
} from "react-icons/gi";

const Cards = () => {
        return (
                <Css.Container>
                        <CardItem title="Gerencie seus Livros"
                                route="/livros"
                                Icon={GiWhiteBook} />
                        <CardItem title="Gerencie suas Compras"
                                route="/compras"
                                Icon={GiPayMoney} />
                        <CardItem title="Gerencie suas Vendas"
                                route="/vendas"
                                Icon={GiReceiveMoney} />
                </Css.Container>
        )
}

export default Cards;