let path_selected
let id_selected

const showModalDeletar = function(path, id){
    path_selected = path
    id_selected = id
    $('#modalDeletar').modal('show')
}

const deletar = function(){
    if (path_selected != "" && id_selected != ""){
        window.location.href='/' + path_selected + '/delete/' + id_selected
    }
}

// const verificarCep = function(){
//     let cep = $('#floatingInputCep').val().replace(/[^0-9]/,'')
//     if (cep){
//         let url = 'http://opencep.com/v1/' +  cep
//         alert(url)
//         $.ajax({
//             url: url,
//             method:'GET',
//             dataType: 'json',
//             contentType: "application/json",
//             success: function(json){
//                 console.log("voltou");
//                 if(json.logradouro){
//                     $('#floatingInputRua').val(json.logradouro)
//                     $('#floatingInputBairro').val(json.bairro)
//                     $('#floatingInputCidade').val(json.localidade)
//                     $('#floatingInputUF').val(json.estado)
//                 }
//             }
//         })

//     }
// }

const verificarCep = function(){
        let cep = $('#floatingInputCep').val().replace(/[^0-9]/,'')
        if (cep){
            let url = '/endereco/' +  cep
            $.ajax({
                url: url,
                method:'GET',
                dataType: 'json',
                contentType: "application/json",
                success: function(json){
                    if(json.logradouro){
                        $('#floatingInputLogradouro').val(json.logradouro)
                        $('#floatingInputComplemento').val(json.complemento)
                        $('#floatingInputBairro').val(json.bairro)
                        $('#floatingInputLocalidade').val(json.localidade)
                        $('#floatingInputUF').val(json.uf)
                    }
                }
            })
    
        }
    }