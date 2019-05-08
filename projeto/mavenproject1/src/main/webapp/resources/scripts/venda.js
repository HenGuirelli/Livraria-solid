const venderLivro = async (cliente, quantidade, livro, formaPagamento, dadosPagamento) => {
     return await POST(baseURLRest + '/venda/vender/produto', { cliente, quantidade, livro, dadosPagamento, formaPagamento })
 }