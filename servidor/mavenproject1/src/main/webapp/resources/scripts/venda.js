const venderLivro = async (cliente, quantidade, livro, dadosPagamento) => {
     return await POST(baseURLRest + '/venda/vender/livro', { cliente, quantidade, livro, dadosPagamento })
 }