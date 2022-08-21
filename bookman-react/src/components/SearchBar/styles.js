import styled from "styled-components";

export const Container = styled.div`
    max-width: 1120px;
    margin: 20px auto;
    width: 100%;
    background-color: #fff;
    box-shadow: 0px 0px 5px #ccc;
    border-radius: 5px;
    display: flex;
    justify-content: space-around;
    padding: 15px 0px;
    gap: 10px;

    @media (max-width: 750px){
        display: grid;

        svg{
            display: none;
        }

        input{
            margin-left: 2px;
            width: 450px;
        }

        button{
            width: 450px;
            font-size: medium;
            margin-left: 3px;
        }
    }
`;

export const InputContent = styled.div`
    display: flex;
    width: 75%;
    flex-direction: column;
`;

export const Icon = styled.div`
    margin-top: 3px;
`;

export const Input = styled.input`
    color: teal;
    margin-left: -40px;
    outline: none;
    border-radius: 5px;
    padding: 5px 0px;
    font-size: 15px;
    border: 1px solid #ccc;
`;

export const Button = styled.button`
    padding: 5px 10px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    color: white;
    font-weight: bolder;
    font-size: larger;
    background-color: teal;
`;
