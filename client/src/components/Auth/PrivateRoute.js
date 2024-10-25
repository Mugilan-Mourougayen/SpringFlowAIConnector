import React, { useEffect, useState } from 'react';
import { Outlet, Navigate } from 'react-router-dom';

const validateToken = async (token) => {
    try {
        console.log("from pr : " + token)
        const response = await fetch('http://localhost:8080/check', {
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${token}`,
                'Content-Type': 'application/json'
            }
        });
        return response.ok;
    } catch (error) {
        return false;
    }
};

const PrivateRoute = () => {
    const [isAuthenticated, setIsAuthenticated] = useState(null);

    useEffect(() => {
        const token = localStorage.getItem('token');

        const checkToken = async () => {
            if (token) {
                const isValid = await validateToken(token);
                setIsAuthenticated(isValid);
            } else {
                setIsAuthenticated(false);
            }
        };

        checkToken();
    }, []);

    if (isAuthenticated === null) {
        return <div>Loading...</div>;
    }

    return isAuthenticated ? <Outlet /> : <Navigate to="/login" />;
};

export default PrivateRoute;
