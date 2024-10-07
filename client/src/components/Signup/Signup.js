import React from 'react';
import { SignupForm } from '../forms/SignupForm';

function Signup() {
  return (
    <div>
      <h1 className='text-4xl flex flex-col text-center p-8'>Signup</h1>
      <SignupForm />
    </div>
  );
}

export default Signup;

