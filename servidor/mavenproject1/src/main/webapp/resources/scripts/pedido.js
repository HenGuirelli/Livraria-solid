const getPedidos = async cliente => {
    if (cliente)
        return await GET(baseURLRest + '/pedidos/cliente/' + cliente)
    return await GET(baseURLRest + '/pedidos')
}

const alterarEstadoPedido = async (codigo, estado) => {
    return await PUT(baseURLRest + `/pedidos/alterar/${codigo}/${estado}`)
}