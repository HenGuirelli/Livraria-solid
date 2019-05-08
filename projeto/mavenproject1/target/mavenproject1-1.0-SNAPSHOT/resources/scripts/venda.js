const venderLivro = async (cliente, quantidade, livro, formaPagamento, dadosPagamento) => {
     return await POST(baseURLRest + '/venda/vender/livro', { cliente, quantidade, livro, dadosPagamento, formaPagamento })
 }