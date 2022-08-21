import React from 'react';
import GlobalStyle from './styles/global';

import Home from './views/Home';

const bookmanApp = () => {
    return (
        <>
            <Home />
            <GlobalStyle />
        </>
    )
};

export default bookmanApp;