const express = require('express')
const app = express()

app.get('/', (req, res) => res.send('Hello World!'))

//app.get('/clientes', )

app.listen(7000, () => console.log('Example app listening on port 7000!'))