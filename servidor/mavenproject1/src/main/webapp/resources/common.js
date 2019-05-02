const NOME_LIVRARIA = "LIVRARIA SOLID"

const baseURL = "http://localhost:9999/mavenproject1";
const baseURLRest = baseURL + '/rest'

const logado = false
const dadosComum = {}

const $nomeLivraria = document.querySelector(".nome-livraria")
if ($nomeLivraria)
    $nomeLivraria.innerHTML = NOME_LIVRARIA

const GET = async url => {
    const result = await fetch(url)
    return result.json();
}

const POST = async (url, body) => {
    const result = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json',
        },
        body: JSON.stringify(body)
    })
    return result.json();
}