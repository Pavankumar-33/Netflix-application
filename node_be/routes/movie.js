const express = require('express')
const fetch = require('node-fetch')
const axios = require('axios')

let javurl = "http://localhost:8061/api/"


const movieModel = require('../models/movieModel')

const Router = express.Router()


Router.post('/add-movie', async (req, res) => {
    const url = javurl.concat('movies')
    const formResponse = req.body

    const header = {
        'Content-Type': 'application/json',
    }
    await axios.post(url, formResponse, {header}).then(function (response) {
        const movieObj = new movieModel(formResponse)
        movieObj.save()
        return res.status(200).json(movieObj)
    }).catch(function (error) {
        console.log(error)
        return res.status(400).json({"msg":"Cannot Insert movie"})
    });;
})


module.exports = Router
