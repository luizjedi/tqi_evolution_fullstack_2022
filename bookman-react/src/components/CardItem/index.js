import React from 'react';
import * as Css from "./styles";
import { useLinkClickHandler } from 'react-router-dom';

const CardItem = ({ route, title, Icon }) => {

  return (
    <Css.Container>
      <Css.Header>
        <Css.HeaderTitle>{title}</Css.HeaderTitle>
      </Css.Header>
      <Css.Button onClick={useLinkClickHandler(route)}><Icon /></Css.Button>
    </Css.Container>
  );
};

export default CardItem;