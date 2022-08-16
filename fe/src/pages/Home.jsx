import axios from 'axios'
import React, { useState } from 'react'
import { useEffect } from 'react'
import Main from '../components/Main'
import Row from '../components/Row'
import requests from '../Requests'


const Home = ({ type }) => {

  return (
    <>
        <Main />
        <Row rowID = '1' title='Action' category='Action'/>
        <Row rowID = '2' title='Adventure' category='Adventure'/>
        <Row rowID = '3' title='Comedy' category='Comedy'/>
        <Row rowID = '4' title='Horror' category='Horror'/>
        <Row rowID = '5' title='Drama' category='Drama'/>
    </>
  )
}

export default Home