import styled from "styled-components";

export const ContainerPage = styled.div`
    max-width: 1120px;
    margin: 20px auto;

    h1{
        color: teal;
    }
`;

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
`;

export const InputCliente = styled.div`
    color: teal;
    display: flex;
    width: 97.7%;
    flex-direction: column;
`;

export const Label = styled.label`
    color: teal;
`;

export const Input = styled.input`
    outline: none;
    border-radius: 5px;
    padding: 5px 10px;
    font-size: 15px;
    border: 1px solid #ccc;

    @media (max-width: 750px){
        margin-right: -14px;
        padding: 5px 250px;
    }

    @media (max-width: 500px){
        padding: 5px 135px;
    }
`;

export const Button = styled.button`
    margin-left: 90.3%;
    padding: 5px 10px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    color: white;
    font-weight: bolder;
    font-size: larger;
    background-color: teal;

    @media (max-width: 1000px){
        margin-left: 88.7%;
    }

    @media (max-width: 750px){
        margin-left: 85.3%;
    }
    
    @media (max-width: 500px){
        margin-left: 77.4%;
    }
`;
