import React from 'react';
import { LoginForm } from '../forms/loginForm';

function Login() {
  return (
    <div>
      <h1 className='text-4xl flex flex-col text-center p-8'>Login</h1>
      <LoginForm />
    </div>
  );
}

export default Login;
