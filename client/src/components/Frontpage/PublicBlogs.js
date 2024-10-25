import React,{useEffect, useState} from 'react'
import BasicCardview from './BasicCardview';

const PublicBlogs = () => {
    const [blogs,setBlogs]=useState();
    useEffect(()=>{
        fetchArticle()
    },[])
    const fetchArticle = async () => {
        const token = localStorage.getItem('token');
        try {
          const response = await fetch(`http://localhost:8080/getallpublished`, {
            method: 'GET',
            headers: {
              'Authorization': `Bearer ${token}`,
              'Content-Type': 'application/json',
            },
          });

          const articleData = await response.json();
          console.log(articleData)
          setBlogs(articleData);
        } catch (error) {
          console.error('Error fetching article:', error);
        }
      };
  return (
    <div>
        {
            blogs ?
            <>
                  {blogs.map(blog =>
        <div>
           <BasicCardview data={blog}/>
        </div>
        )}
            </> : <>no blogs yet</>
        }
    </div>
  )
}

export default PublicBlogs