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
    }
`;

export const InputContent = styled.div`
    display: flex;
    width: 98%;
    flex-direction: column;
    align-items: center;
    
    h1 {
        color: teal;
    }
`;

export const Button = styled.button`
    padding: 5px 10px;
    width: 98%;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    color: white;
    font-weight: bolder;
    font-size: larger;
    background-color: teal;

    @media (max-width: 750px){
        margin-right: -14px;
        width: 650px;
    }
    
    @media (max-width: 500px){
        margin-right: -11px;
        width: 450px;
    }
`;
