const adicionarAoCarrinho = async (cliente, livro) => {
    return await POST(baseURLRest + '/carrinho/adicionar', { cliente, livro })
}

const getCarrinho = async (user) => {
    return await GET(baseURLRest + '/carrinho/procurar/' + user)
}

const alterarQuantidade = async (cliente, produto, quantidade) => {
    return await PUT(baseURLRest + '/carrinho/alterar/quantidade', { cliente, produto, quantidade })
}

const removerItem = async (cliente, produto) => {
    return await PUT(baseURLRest + '/carrinho/remover', { cliente, produto })
}

const venderCarrinho = async (cliente, formaPagamento, dadosPagamento) => {
    return await POST(baseURLRest + '/venda/vender/carrinho', { cliente, formaPagamento, dadosPagamento })
}