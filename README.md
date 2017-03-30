# bank-transfer

*Bank transfer information extractor*

### Request

- POST
```
{
"text" : "CPF 432.321.231-43 \n Conta 00121-1, ..."
}
```

### Response

```
{
"cpf" : "____" ,
"cnpj" : "____" ,
"agency" : "____" ,
"account" : "____" ,
"bank" : "____" ,
"name" : "____" ,
}
```
