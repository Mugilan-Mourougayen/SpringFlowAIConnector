import React from 'react';
import { useForm, Controller } from 'react-hook-form';
import Editor from '../forms/Inputs/Editor';
import Input from '../forms/Inputs/Input';

const EditorPage = () => {
  const {
    register,
    handleSubmit,
    control,
    formState: { errors },
  } = useForm();

  const check=async()=>{
    try {
      const token = localStorage.getItem('token');

      console.log("from editor check : " + token)
      const response = await fetch('http://localhost:8080/checkblog', {
          method: 'GET',
          headers: {
              'Authorization': `Bearer ${token}`,
              'Content-Type': 'application/json'
          }
      });
      if(response.ok){
        let data =await response.text();
        console.log(data)
      }
      return response.ok;

  } catch (error) {
      return false;
  }
  }

  const onSubmit = async (data) => {
    console.log("from editor", data);
    const token = localStorage.getItem('token');
    console.log("from editor", token);
    const requestOptions = {
        method: 'POST',
        headers: {
            'Authorization': `Bearer ${token}`,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    };

    try {
        const response = await fetch('http://localhost:8080/create', requestOptions);
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const responseData = await response.json();
        console.log(responseData);
    } catch (error) {
        console.error('There was an error with the fetch request:', error);
    }
};


  return (
    <div className="max-w-[900px] mx-auto mt-10">
      <form onSubmit={handleSubmit(onSubmit)}>
        <h3>Article Editor</h3>
        <Input
          label="Title"
          type="text"
          name="title"
          register={register}
          control={control}
          validation={{ required: 'email is required' }}
          error={errors.email}
        />
        <Input
          label="Description"
          type="text"
          name="description"
          register={register}
          control={control}
          validation={{ required: 'email is required' }}
          error={errors.email}
        />
        <Controller
          name="content"
          control={control}
          defaultValue=""
          render={({ field }) => (
            <Editor
              value={field.value}
              onChange={field.onChange}
              error={errors.content}
            />
          )}
          rules={{ required: "Content is required" }}
        />
        <button type="submit" className="bg-slate-900 text-white py-2 px-4 mt-8">
          Submit
        </button>


      </form>
      <button onClick={()=>check()} className="bg-slate-900 text-white py-2 px-4 mt-8">
          check
        </button>
    </div>
  );
};

export default EditorPage;