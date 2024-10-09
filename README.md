# San Giorgio Challenge

### Abaixo estão os passos para utlizar a aplicação

#### Para iniciar o projeto foi disponibilizado um docker compose

### Iniciando a aplicação

```sh 
    docker compose up
```

a aplicação estara disponivel na porta 8080

### Realizando Requisição

Importante já existem alguns dados salvos na base dados para vendedor e alguns pagamentos
Os ids e seus valores de pagamento (total) são respectivamente:

```
a1b2c3d4-e5f6-7890-abcd-1234567890ab -  100.00
b2c3d4e5-f6a7-8901-bcde-2345678901bc -  250.50
c3d4e5f6-a7b8-9012-cdef-3456789012cd -  500.75
```

```sh 
curl --location --request PUT 'http://localhost:8080/v1/seller/payment' \
--header 'Content-Type: application/json' \
--data '{
    "sellerCode": "5f9e46e5-da80-4a7a-875e-d89a7898bc9d",
    "payments": [
        {
            "chargeCode": "a1b2c3d4-e5f6-7890-abcd-1234567890ab",
            "amountPaid": 100.00
        },
        {
            "chargeCode": "b2c3d4e5-f6a7-8901-bcde-2345678901bc",
            "amountPaid": 200
        },
        {
            "chargeCode": "c3d4e5f6-a7b8-9012-cdef-3456789012cd",
            "amountPaid": 500.80
        }
    ]
}'
```

### As mensagens poderão ser acompanhadas no painel do [Elastic MQ](http://localhost:9325)
