import styled from "styled-components";

export const Container = styled.div`
    display: flex;
    flex-direction: column;
    text-align: center;
    align-items: center;
    background-color: #fff;
    border-radius: 5px;
    padding: 5px 15px;
    width: 30%;

    @media (max-width:950px){
        width: 20%;

        p {
            font-size: 18px;
            width: 80px;
        }

        span {
            font-size: 20px;
        }

        svg {
            
        }

        button{
            height: 30px;
        }
    }

    @media (max-width: 500px){
        font-size: 17px !important;
        margin-bottom: -10px;
    }  
`;

export const Header = styled.header`
    display: flex;
    align-items: center;
    justify-content: space-around;
    width: 100%;
    gap: 10px;

    svg {
        width: 25px;
        height: 25px;
    }
`;

export const HeaderTitle = styled.p`
    color: teal;
    font-size: 20px;
`;

export const Button = styled.button`
    padding: 5px 10px;
    margin-bottom: 5px;
    width: 70%;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    color: white;
    font-weight: bolder;
    font-size: larger;
    background-color: teal;

    @media (max-width: 1000px){
        margin-top: 15px;
    }

    @media (max-width: 500px){
        
    }
`;