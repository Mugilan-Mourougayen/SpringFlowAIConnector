
import React from 'react';
import { useForm } from 'react-hook-form';
import { Link,useNavigate } from 'react-router-dom';
import Input from './Inputs/Input';

export function LoginForm() {
  const navigate = useNavigate();
  const {
    register,
    handleSubmit,
    control,
    formState: { errors },
  } = useForm();


  const onSubmit = (data) => {
    console.log("from login",data)
    const requestOptions = {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(data)
  };
  fetch('http://localhost:8080/login', requestOptions)
      .then(response => response.text())
      .then(data =>
        {
          //todo : handle properly
          console.log(data)
          localStorage.setItem('token', data);
          navigate("/editor");
        })
      .catch(error => {

        console.error('There was an error with the fetch request:', error);
    })
  };

  return (
    <div className="max-w-md mx-auto mt-10">
      <form onSubmit={handleSubmit(onSubmit)}>
        <Input
          label="Email"
          type="text"
          name="email"
          register={register}
          control={control}
          validation={{ required: 'email is required' }}
          error={errors.email}
        />
        <Input
          label="Password"
          type="password"
          name="password"
          register={register}
          control={control}
          validation={{ required: 'Password is required' }}
          error={errors.password}
        />
        <button
          type="submit"
          className="bg-slate-900 text-white py-2 px-4 rounded mt-4 w-full"
        >
          Submit
        </button>
      </form>

      <div className="text-center mt-4">
        <Link to="/signup" className="text-md hover:underline">
          I don't have an account
        </Link>
      </div>
    </div>
  );
}
