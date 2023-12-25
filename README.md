# Simplified PicPay
Backend challenge that I'm aiming to make a simplified banking structure. In this challenge we must have a structure composed of two types of users (Merchant and Commom), that can make bank transfer.

The follows requisites was proposed to this challenge:

- For both kind of users we must have Full Name, Document(CPF/CNPJ), Email and Password. CPF/CNPJ and emails must be unique in the system. 
- Commom users can transfer money to merchant users and commom users.
- Merchant users can only receive money.
- It's necessary to validate whether users has enought money to make the transfer.
- Before finish the transfer you must consult an external authorization service. For this authorization service this mock was used: https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc
- The transfer must be a transaction, so that could be reverted any time and the money went back to sender user wallet.
- After the transfer be completed, the recipient user must receive a notification sended by a notification service. For this service I used this mock: https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6.


APIs:

Create User: /sign-in/create-user
curl: 
```
curl --location 'http://localhost:8080/sign-in/create-user' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name":"Paulo",
    "document":"01234567891",
    "email":"paulo@gmail.com",
    "password": "001122"
}'
```

Get Balance: /picpay/balance
curl: 
```
curl --location 'http://localhost:8080/picpay/balance' \
--header 'document: 00011122244' \
--header 'password: 1234'
```

Make Transaction: /picpay/transaction
curl:

```
curl --location 'http://localhost:8080/picpay/transaction?senderDocument=00011122233&password=abc1234&receiverDocument=01234567891' \
--header 'Content-Type: application/json' \
--data '{
    "amount": 200.00
}'
```
