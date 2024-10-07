import React from 'react';
import { useForm, Controller } from 'react-hook-form';
import Editor from '../forms/Inputs/Editor';

const EditorPage = () => {
  const { handleSubmit, control, formState: { errors } } = useForm();

  const onSubmit = (data) => {
    console.log(data);
  };

  return (
    <div className="max-w-[900px] mx-auto mt-10">
      <form onSubmit={handleSubmit(onSubmit)}>
        <h3>Article Editor</h3>
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
    </div>
  );
};

export default EditorPage;
