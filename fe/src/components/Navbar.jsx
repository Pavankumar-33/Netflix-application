import React from 'react'
import { Link, useNavigate } from 'react-router-dom'

function Navbar() {
    let { user } = false

    var usernameStore = sessionStorage.getItem("username");
    if (usernameStore != null) 
        user = true
    const navigate = useNavigate();
    // console.log(user)
    const handleLogout = async() => {
        sessionStorage.clear();
        window.location.href = '/login';
    }
    return (
      <div className='flex items-center justify-between p-4 z-[100] w-full absolute'>
        <Link to='/'>
            <h1 className="text-red-600 text-4xl font-bold cursor-pointer">NETFLIX</h1>
        </Link>
        {user ? (
            <div>
            <Link to='/'>
                <button className='text-white pr-4'>Home</button>
            </Link>
            <button onClick={handleLogout} className='bg-red-600 px-6 py-2 rounded cursor-pointer'>Logout</button>
          </div>
        ) : (
            <div>
            <Link to='/login'>
                <button className='text-white pr-4'>Sign In</button>
            </Link>
            <Link to='/signup'>
                <button className='bg-red-600 px-6 py-2 rounded cursor-pointer'>Sign Up</button>
            </Link>
          </div>
        )}
      </div>
    )
}

export default Navbar