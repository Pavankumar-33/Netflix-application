const express = require('express')

const ratingModel = require('../models/rModel')

const Router = express.Router()


Router.post('/rate', async (req, res) => {
    const formResponse = req.body
    
    const ratingObj = new ratingModel(formResponse)
    await ratingObj.save()
    return res.status(200).json(ratingObj)
})

module.exports = Router