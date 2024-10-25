


import React, { useState, useEffect } from 'react';
import Editor from '../forms/Inputs/Editor';
import { Button } from '@mui/material';

const View = ( ) => {

  const [article, setArticle] = useState({
    uuid: '',
    title: '',
    description: '',
    userName:'',
    content: '',
    lastUpdateAt: null,
    publishedAt: null,
    published:false
  });




  const checkToken = async () => {
    try {
      const token = localStorage.getItem('token');
      const response = await fetch('http://localhost:8080/checkblog', {
        method: 'GET',
        headers: {
          Authorization: `Bearer ${token}`,
          'Content-Type': 'application/json',
        }
      });
      if(response.ok){
        const data = await response.text();
        console.log(data);
        return response.ok;
      }

    } catch (error) {
      return false;
    }
  };

  const fetchArticle = async (id) => {
    const token = localStorage.getItem('token');
    try {
      const response = await fetch(`http://localhost:8080/get/?blogid=${id}`, {
        method: 'GET',
        headers: {
          'Authorization': `Bearer ${token}`,
          'Content-Type': 'application/json',
        },
      });

      const articleData = await response.json();
      setArticle(articleData);
      console.log("count")
    } catch (error) {
      console.error('Error fetching article:', error);
    }
  };

  useEffect(() => {
    const queryParameters = new URLSearchParams(window.location.search)
    const articleId = queryParameters.get("articleId")

    if (articleId) {
      fetchArticle(articleId);
    }
  }, []);


  const handleChange = (e) => {
    const { name, value } = e.target;
    setArticle((prevArticle) => ({
      ...prevArticle,
      [name]: value,
    }));
  };


  const handleEditorChange = (content) => {
    setArticle((prevArticle) => ({
      ...prevArticle,
      content,
    }));
  };


  const onPublish = async () => {
    const updatedArticle = {
      ...article,
      published: true,
      publishedAt: new Date(),
      lastUpdateAt: new Date(),
    };

    setArticle(updatedArticle);
    await onSubmit(updatedArticle);

  };



  const onSubmit = async (updatedArticle = article) => {

    const isTokenValid = await checkToken();
    console.log(isTokenValid)
    if (!isTokenValid) {
      alert('Invalid token. Please log in again.');
      return;
    }
    console.log("from editor", updatedArticle);
    const token = localStorage.getItem('token');
    console.log("from editor", token);
    const requestOptions = {
        method: 'POST',
        headers: {
            'Authorization': `Bearer ${token}`,
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(updatedArticle)
    };

    try {
        const response = await fetch('http://localhost:8080/create', requestOptions);
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const responseData = await response.json();
        setArticle(responseData);
    } catch (error) {
        console.error('There was an error with the fetch request:', error);
    }


  };

  return (
    <div className="max-w-[900px] mx-auto mt-10">

      <div>
        <label>Title</label>
        <input
          type="text"
          name="title"
          value={article.title}
          onChange={handleChange}
          placeholder="Enter title"
          className="border border-gray-300 p-2 w-full"
        />
      </div>
      <div>
        <label>Description</label>
        <input
          type="text"
          name="description"
          value={article.description}
          onChange={handleChange}
          placeholder="Enter description"
          className="border border-gray-300 p-2 w-full"
        />
      </div>
      <div>
        <label>Content</label>
        <Editor
          value={article.content}
          // onChange={handleEditorChange}
        />
      </div>

<br/>
      <Button onClick={()=>onSubmit(article)} variant='contained'>
       Summarize
      </Button>



    </div>
  );
};

export default View;
