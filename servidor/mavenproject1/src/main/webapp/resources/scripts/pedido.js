const getPedidos = async cliente => {
    if (cliente)
        return await GET(baseURLRest + '/pedidos/cliente/' + cliente)
    return await GET(baseURLRest + '/pedidos')
}