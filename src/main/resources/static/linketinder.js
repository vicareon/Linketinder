//Formulário de cadastro de candidato
var nomeCandidato = document.querySelector("#nomeCandidato");
var emailCandidato = document.querySelector("#emailCandidato");
var cepCandidato = document.querySelector("#cpfCandidato");
var estadoCandidato = document.querySelector("#estadoCandidato");
var paisCandidato = document.querySelector("#paisCandidato");
var descricaoCandidato = document.querySelector("#descricaoCandidato");
var formacaoAcademica = document.querySelector("#formacaoAcademica");
var cpfCandidato = document.querySelector("#cpfCandidato");
var idadeCandidato = document.querySelector("#idadeCandidato");
var senhaCandidato = document.querySelector("#senhaCandidato");
var botaoSalvarCadastroCandidato = document.getElementById("botaoSalvarCadastroCandidato");
botaoSalvarCadastroCandidato.addEventListener('click', function () {
    var candidato = {
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
    };
    validaNome(nomeCandidato.value);
    validaCEP(cepCandidato.value);
    validaEmail(emailCandidato.value);
    validaCPFouCNPJ(cpfCandidato.value);
    fetch('localhost:5151/cadastroCandidato', {
        method: 'POST',
        mode: 'no-cors',
        body: Object.keys(candidato)
            .map(function (k) { return "".concat(encodeURIComponent(k), "=").concat(encodeURIComponent(candidato[k])); })
            .join('&')
    }).then(function (T) { return T.json(); });
});
//Formulário de cadastro de empresa
var nomeEmpresa = document.querySelector("#nomeEmpresa");
var emailEmpresa = document.querySelector("#emailEmpresa");
var cepEmpresa = document.querySelector("#cepEmpresa");
var estadoEmpresa = document.querySelector("#estadoEmpresa");
var paisEmpresa = document.querySelector("#paisEmpresa");
var descricaoEmpresa = document.querySelector("#descricaoEmpresa");
var senhaEmpresa = document.querySelector("#senhaEmpresa");
var cnpjEmpresa = document.querySelector("#cnpjEmpresa");
var botaoSalvarCadastroEmpresa = document.getElementById("botaoSalvarCadastroEmpresa");
botaoSalvarCadastroEmpresa.addEventListener('click', function () {
    var empresa = {
        _nome: nomeEmpresa.value,
        _email: emailEmpresa.value,
        _cep: cepEmpresa.value,
        _estado: estadoEmpresa.value,
        _pais: paisEmpresa.value,
        _descricao: descricaoEmpresa.value,
        _cnpj: cnpjEmpresa.value,
        _senha: senhaEmpresa.value
    };
    validaNome(nomeEmpresa.value);
    validaCEP(cepEmpresa.value);
    validaEmail(emailEmpresa.value);
    validaCPFouCNPJ(cnpjEmpresa.value);
    fetch('http://localhost:5151/cadastroEmpresa', {
        method: 'POST',
        mode: 'no-cors',
        body: Object.keys(empresa)
            .map(function (k) { return "".concat(encodeURIComponent(k), "=").concat(encodeURIComponent(empresa[k])); })
            .join('&')
    }).then(function (T) { return T.json(); });
});
//funções de validação com regex
var regexCPFouCNPJ = /([0-9]{2}[\.]?[0-9]{3}[\.]?[0-9]{3}[\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\.]?[0-9]{3}[\.]?[0-9]{3}[-]?[0-9]{2})/;
var regexCEP = /([0-9]{5}[-\. ]?[0-9]{3})/;
var regexNome = /^[a-zA-Z]+(([ ][a-zA-Z ])?[a-zA-Z]*)*$/gi;
var regexEmail = /^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
function validaNome(nome) {
    if (!(nome.match(regexNome))) {
        alert("Nome inválido!");
    }
    else {
        return true;
    }
}
function validaCPFouCNPJ(cpfOuCnpj) {
    if (!(cpfOuCnpj.match(regexCPFouCNPJ))) {
        alert("CPF/CNPJ inválido!");
    }
    else {
        return true;
    }
}
function validaEmail(email) {
    if (!(email.match(regexEmail))) {
        alert("Email inválido!");
    }
    else {
        return true;
    }
}
function validaCEP(cep) {
    if (!(cep.match(regexCEP))) {
        alert("CEP inválido!");
    }
    else {
        return true;
    }
}
