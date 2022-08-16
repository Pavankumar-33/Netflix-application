import React from 'react'
import { Navigate } from 'react-router-dom';

const ProtectedRoute = ({children}) => {
    const user = {email:'sd'}
    if (!user) {
        return <Navigate to='/' />
    } else {
        return children;
    }
}

export default ProtectedRoute