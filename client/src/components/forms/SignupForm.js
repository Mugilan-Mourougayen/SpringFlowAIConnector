
import React from 'react';
import { useForm } from 'react-hook-form';
import { Link,redirect } from 'react-router-dom';
import Input from './Inputs/Input';

export function SignupForm() {
  const {
    register,
    handleSubmit,
    control,
    formState: { errors },
  } = useForm();

  const onSubmit = (data) => {

    const requestOptions = {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(data)
  };
  fetch('http://localhost:8080/register', requestOptions)
      .then(response => response.json())
      .then(data =>
        {
          //todo : handle properly
          console.log(data)
          return redirect("/login");
        })
      .catch(error => {

        console.error('There was an error with the fetch request:', error);
    })
  };

  return (
    <div className="max-w-md mx-auto mt-10">
      <form onSubmit={handleSubmit(onSubmit)}>
          <Input
            label="Username"
            type="text"
            name="username"
            register={register}
            control={control}
            validation={{ required: "Username is required" }}
            error={errors.userName}
          />
        <Input
          label="Email"
          type="text"
          name="email"
          register={register}
          control={control}
          validation={{ required: "Email is required" }}
          error={errors.email}
        />
        <Input
          label="Password"
          type="password"
          name="password"
          register={register}
          control={control}
          validation={{ required: "Password is required" }}
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
        <Link to="/login" className="text-md hover:underline">
          I have an account
        </Link>
      </div>
    </div>
  );
}
