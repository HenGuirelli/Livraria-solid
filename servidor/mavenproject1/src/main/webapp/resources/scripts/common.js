const NOME_LIVRARIA = "LIVRARIA SOLID"

const baseURL = "http://localhost:9999/mavenproject1";
const baseURLRest = baseURL + '/rest'

const logado = false

const $nomeLivraria = document.querySelector(".nome-livraria")
if ($nomeLivraria)
    $nomeLivraria.innerHTML = NOME_LIVRARIA

const $acesso = document.querySelector('.acesso')
const $meusPedidos = document.querySelector('.meus-pedidos')

if (sessionStorage.getItem('logado')){
    $meusPedidos.classList.remove('nao-visivel')
    $acesso.classList.add('nao-visivel')
}else {
    $acesso.classList.remove('nao-visivel')
    $meusPedidos.classList.add('nao-visivel')
}

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
    console.log('POST: ', body)
    return result.json();
}

const PUT = async (url, body) => {
    const result = await fetch(url, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json',
            "Access-Control-Allow-Origin" : "*", 
            "Access-Control-Allow-Credentials" : true 
        },
        body: JSON.stringify(body)
    })
    console.log('PUT:', body)
    return result.json();
}