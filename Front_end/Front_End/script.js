let id=document.querySelector("#id")
let nome=document.querySelector("#name")
let email=document.querySelector("#email")
let senha=document.querySelector("#password")



function enviarDados(){

let usuario= {
    id:id.value,
    nome:nome.value,
    email:email.value,
    senha:senha.value
}


fetch("http://localhost:8080/usuarios", {
  method: "POST",
  headers: {
    "Content-Type": "application/json"
  },
  body: JSON.stringify(usuario)
})
.then(response => {
  if (!response.ok) {
    throw new Error(`Erro na requisição: ${response.status}`);
  }
  return response.json();
})
.then(data => console.log("Usuário cadastrado:", data))
.catch(error => console.error("Erro:", error));

}







