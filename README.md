# McDonalds

Prova final de TABD na fundatec, com conexão no mongoDB Atlas

Exemplo de body:
{
    "numeroPedido":"1",
    "item":"BigMac",
    "qtd":1,
    "valor": 18.50
}

endpoints:

GET http://localhost:8080/mcdonalds/buscar/{id} - listar pedido por numero
POST http://localhost:8080/mcdonalds/salvar - salvar pedido
PUT http://localhost:8080/mcdonalds/editar/{id} - editar pedido
DELETE http://localhost:8080/mcdonalds/deletar/{id} - deletar pedido
