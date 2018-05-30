var express = require('express');
var router = express.Router();
const MongoClient = require('mongodb').MongoClient;
const url = 'mongodb://localhost:27017';
const dblocal = 'lavadero';

/* GET home page. */
router.get('/', function(req, res, next) {

    console.log("conectando a mongo");

    MongoClient.connect(url, function(err,client){
        const db = client.db(dblocal);
        const collections = db.collection('clientes');
        collections.find({}).toArray(function(err,result){
        console.log(result);



        res.render('clientes', { title: 'lista de clientes', 
        clientesmongo: JSON.stringify(result) });
        

        });
    });

    
  
});

module.exports = router;