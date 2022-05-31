//Formulário de cadastro de candidato
const nomeCandidato = (<HTMLInputElement>document.querySelector("#nomeCandidato"));
const emailCandidato = (<HTMLInputElement>document.querySelector("#emailCandidato"));
const cepCandidato = (<HTMLInputElement>document.querySelector("#cpfCandidato"));
const estadoCandidato = (<HTMLInputElement>document.querySelector("#estadoCandidato"));
const paisCandidato = (<HTMLInputElement>document.querySelector("#paisCandidato"));
const descricaoCandidato = (<HTMLInputElement>document.querySelector("#descricaoCandidato"));
const formacaoAcademica = (<HTMLInputElement>document.querySelector("#formacaoAcademica"));
const cpfCandidato = (<HTMLInputElement>document.querySelector("#cpfCandidato"));
const idadeCandidato = (<HTMLInputElement>document.querySelector("#idadeCandidato"));
const senhaCandidato = (<HTMLInputElement>document.querySelector("#senhaCandidato"));

const botaoSalvarCadastroCandidato = document.getElementById("botaoSalvarCadastroCandidato");

botaoSalvarCadastroCandidato.addEventListener('click', () => {
    const candidato: { _nome: string, _email: string, _cep: string, _estado: string, _pais: string, _descricao: string, _cpf: string, _formacaoAcademica: string, _idade: string, _senha: string } = {
        _nome: nomeCandidato.value,
        _email: emailCandidato.value,
        _cep: cepCandidato.value,
        _estado: estadoCandidato.value,
        _pais: paisCandidato.value,
        _descricao: descricaoCandidato.value,
        _cpf: cpfCandidato.value,
        _formacaoAcademica: formacaoAcademica.value,
        _idade: idadeCandidato.value,
        _senha: senhaCandidato.value
    }

    validaNome(nomeCandidato.value)
    validaCEP(cepCandidato.value)
    validaEmail(emailCandidato.value)
    validaCPFouCNPJ(cpfCandidato.value)

    fetch('localhost:5151/cadastroCandidato', {
        method: 'POST',
        mode: 'no-cors',
        body: Object.keys(candidato)
            .map(k => `${encodeURIComponent(k)}=${encodeURIComponent(candidato[k])}`)
            .join('&')
    }).then(T => T.json())
});

//Formulário de cadastro de empresa
const nomeEmpresa = (<HTMLInputElement>document.querySelector("#nomeEmpresa"));
const emailEmpresa = (<HTMLInputElement>document.querySelector("#emailEmpresa"));
const cepEmpresa = (<HTMLInputElement>document.querySelector("#cepEmpresa"));
const estadoEmpresa = (<HTMLInputElement>document.querySelector("#estadoEmpresa"));
const paisEmpresa = (<HTMLInputElement>document.querySelector("#paisEmpresa"));
const descricaoEmpresa = (<HTMLInputElement>document.querySelector("#descricaoEmpresa"));
const senhaEmpresa = (<HTMLInputElement>document.querySelector("#senhaEmpresa"));
const cnpjEmpresa = (<HTMLInputElement>document.querySelector("#cnpjEmpresa"));

const botaoSalvarCadastroEmpresa = document.getElementById("botaoSalvarCadastroEmpresa");

botaoSalvarCadastroEmpresa.addEventListener('click', () => {
    const empresa: { _nome: string, _email: string, _cep: string, _estado: string, _pais: string, _descricao: string, _cnpj: string, _senha: string } = {
        _nome: nomeEmpresa.value,
        _email: emailEmpresa.value,
        _cep: cepEmpresa.value,
        _estado: estadoEmpresa.value,
        _pais: paisEmpresa.value,
        _descricao: descricaoEmpresa.value,
        _cnpj: cnpjEmpresa.value,
        _senha: senhaEmpresa.value
    }

    validaNome(nomeEmpresa.value)
    validaCEP(cepEmpresa.value)
    validaEmail(emailEmpresa.value)
    validaCPFouCNPJ(cnpjEmpresa.value)

    fetch('http://localhost:5151/cadastroEmpresa', {
        method: 'POST',
        mode: 'no-cors',
        body: Object.keys(empresa)
            .map(k => `${encodeURIComponent(k)}=${encodeURIComponent(empresa[k])}`)
            .join('&')
    }).then(T => T.json())
});

//funções de validação com regex
const regexCPFouCNPJ = /([0-9]{2}[\.]?[0-9]{3}[\.]?[0-9]{3}[\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\.]?[0-9]{3}[\.]?[0-9]{3}[-]?[0-9]{2})/;
const regexCEP = /([0-9]{5}[-\. ]?[0-9]{3})/;
const regexNome = /^[a-zA-Z]+(([ ][a-zA-Z ])?[a-zA-Z]*)*$/gi;
const regexEmail = /^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;

function validaNome(nome:string): boolean{
    if(!(nome.match(regexNome))){
        alert("Nome inválido!");
    }
    else{
        return true
    }
}

function validaCPFouCNPJ(cpfOuCnpj:string): boolean{
    if(!(cpfOuCnpj.match(regexCPFouCNPJ))){
        alert("CPF/CNPJ inválido!");
    }
    else{
        return true
    }
}

function validaEmail(email:string): boolean{
    if(!(email.match(regexEmail))){
        alert("Email inválido!");
    }
    else{
        return true
    }
}

function validaCEP(cep:string): boolean{
    if(!(cep.match(regexCEP))){
        alert("CEP inválido!");
    }
    else{
        return true
    }
}