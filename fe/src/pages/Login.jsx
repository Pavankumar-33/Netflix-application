import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import {postLoginData} from '../service/login.service'

const Login = () => {
    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')
    const [getUsername, setSessionUsername] = useState();

    const navigate = useNavigate()
    var usernameStore = sessionStorage.getItem("username");

    const handleSubmit = async(e) => {
        e.preventDefault()
        try {
            const value = {password, username}
            const response = await postLoginData(value)
            if (response != 500) {
                sessionStorage.setItem("username", response);
                setSessionUsername(response)
                window.location.href="/"
            } else {
                alert("Credentials are wrong")
            }
            
        } catch (error) {
            console.log(error);
            alert("Something went wrong")
        }
    }
  return (
    <>
        <div className='w-full h-screen'>
            <img className='hidden sm:block absolute w-full h-full object-cover' src='https://assets.nflxext.com/ffe/siteui/vlv3/5fd505fa-f425-4a18-b3cc-00dd2638f541/fa1a180d-daff-47ff-8287-4b0b67981778/FR-en-20220704-popsignuptwoweeks-perspective_alpha_website_small.jpg' alt='/'/>
            <div className='bg-black/60 fixed top-0 left-0 w-full h-screen'></div>
            <div className='fixed w-full px-4 py-24 z-50'>
                <div className='max-w-[450px] h-[600px] mx-auto bg-black/75 text-white'>
                    <div className='max-w-[320px] mx-auto py-16'>
                        <h1 className='text-3xl font-bold'>Sign In</h1>
                        <form onSubmit={handleSubmit} className='w-full flex flex-col py-4'>
                            <input onChange={(e) => setUsername(e.target.value)} className='p-3 my-2 bg-gray-700 rounded' type="text" placeholder='Username'/>
                            <input onChange={(e) => setPassword(e.target.value)} className='p-3 my-2 bg-gray-700 rounded' type='password' placeholder='Password' />
                            <button className='bg-red-600 py-3 my-6 rounded font-bold'>Sign In</button>
                            <div className='flex justify-between items-center text-sm text-grey-600'>
                                <p><input className='mr-2' type="checkbox" />Remember me</p>
                                <p>Need Help?</p>
                            </div>
                            <p className='py-8'>
                                <span className='text-grey-600'>
                                    New to Netflix?
                                </span> {' '}
                                <Link to='/signup'>
                                    Sign Up
                                </Link>
                            </p>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </>
  )
}

export default Login