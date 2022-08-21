import { createGlobalStyle } from "styled-components";

const Global = createGlobalStyle`

    *{
        margin: 0;
        padding: 0;
    }

    body{
        font-family: 'Poppins', sans-serif;
        background-color: #bdbdcd;
    }

    button:hover{
        background-color: teal;
        opacity: 0.7;
    }
`;

export default Global;