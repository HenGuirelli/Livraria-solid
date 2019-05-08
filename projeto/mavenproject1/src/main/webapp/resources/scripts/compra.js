const getFornecedores = async () => {
    return await GET(baseURLRest + '/compra/fornecedores')
}

const comprar = async (nomeProduto, quantidade) => {
    return await POST(baseURLRest + '/compra', { nomeProduto, quantidade })
}