import { createRoot } from "react-dom/client";
import App from "./bookmanApp";
import Livros from "./views/Livros/index";
import Compras from "./views/Compras/index";
import Vendas from "./views/Vendas/index";
import LivroForm from "./components/Form/LivroForm/index";
import CompraForm from "./components/Form/CompraForm/index";
import VendaForm from "./components/Form/Venda Form/index";

import {
    BrowserRouter,
    Routes,
    Route
} from 'react-router-dom';

const root = createRoot(document.querySelector("#root"));

root.render(
    <BrowserRouter>
        {/* Rotas de navegação da Home */}
        <Routes>
            <Route path="/" element={<App />} />
            <Route path="/livros"
                element={
                    <>
                        <App />
                        <Livros />
                    </>} />
            <Route path="/compras"
                element={<>
                    <App />
                    <Compras />
                </>} />
            <Route path="/vendas"
                element={
                    <>
                        <App />
                        <Vendas />
                    </>
                } />
        </Routes>
        {/* Rotas dos Formulários de cadastro */}
        <Routes>
            <Route path="/livros/novo"
                element={
                    <>
                        <App />
                        <LivroForm />
                    </>
                } />
            <Route path="/compras/novo"
                element={
                    <>
                        <App />
                        <CompraForm />
                    </>
                } />
            <Route path="/vendas/novo"
                element={
                    <>
                        <App />
                        <VendaForm />
                    </>
                } />
        </Routes>
    </BrowserRouter>
);