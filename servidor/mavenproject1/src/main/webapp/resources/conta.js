const criarConta = (login, senha, nome) => {
    return POST(baseURLRest + '/conta/cadastro', { login, senha, nome })
}

const logar = (login, senha) => {
    return POST(baseURLRest + '/conta/login', { login, senha })
}