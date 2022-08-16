import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import { postUserData } from '../service/register.service'

const Signup = () => {
    const [firstname, setFirstname] = useState('');
    const [lastname, setLastname] = useState('');
    const [email, setEmail] = useState('');
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate()

    const handleSubmit = async(e) => {
        e.preventDefault()
        try {
            const value = {email, password, username, firstname, lastname}
            await postUserData(value)
            navigate('/login')
        } catch (error) {
            console.log(error)
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
                        <h1 className='text-3xl font-bold'>Sign Up</h1>
                        <form onSubmit={handleSubmit} className='w-full flex flex-col py-4'>
                            <input onChange={(e) => setFirstname(e.target.value)} className='p-3 my-2 bg-gray-700 rounded' type="text" placeholder='First Name'/>
                            <input onChange={(e) => setLastname(e.target.value)} className='p-3 my-2 bg-gray-700 rounded' type="text" placeholder='Last Name'/>
                            <input onChange={(e) => setEmail(e.target.value)} className='p-3 my-2 bg-gray-700 rounded' type="email" placeholder='Email' />
                            <input onChange={(e) => setUsername(e.target.value)} className='p-3 my-2 bg-gray-700 rounded' type="text" placeholder='Username'/>
                            <input onChange={(e) => setPassword(e.target.value)} className='p-3 my-2 bg-gray-700 rounded' type='password' placeholder='Password' />
                            <button className='bg-red-600 py-3 my-6 rounded font-bold'>Sign Up</button>
                            <div className='flex justify-between items-center text-sm text-grey-600'>
                                <p><input className='mr-2' type="checkbox" />Remember me</p>
                                <p>Need Help?</p>
                            </div>
                            <p className='py-8'>
                                <span className='text-grey-600'>
                                    Already subscribed to Netflix?
                                </span> {' '}
                                <Link to='/login'>
                                    Sign In
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

export default Signup