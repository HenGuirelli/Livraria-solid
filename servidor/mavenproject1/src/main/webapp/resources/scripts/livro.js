const getLivros = async (limite = undefined) => {
    const result = await GET(baseURLRest + "/livro")
    if (limite) {
        return result.slice(0, limite)
    }
    return result
}

const getLivroEspecifico = async nome => {
    return await GET(baseURLRest + '/livro/nome/' + nome + '/exato')
}