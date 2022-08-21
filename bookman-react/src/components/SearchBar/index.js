import React, { useState } from 'react';
import * as Css from "./styles";
import { ImSearch } from "react-icons/im";

const SearchBar = () => {
  const [pesquisa, setPesquisa] = useState("");


  const validaForm = () => {
    if (!pesquisa) {
      alert("Informe o parâmetro da pesquisa!");
      return;
    }
  };

  return (
    <>
      <Css.Container>
        <Css.Icon>
          <ImSearch />
        </Css.Icon>
        <Css.InputContent>
          <Css.Input value={pesquisa} onChange={(e) => setPesquisa(e.target.value)} />
        </Css.InputContent>
        <Css.Button onClick={validaForm}>Pesquisar</Css.Button>
      </Css.Container>
    </>
  )
}

export default SearchBar;