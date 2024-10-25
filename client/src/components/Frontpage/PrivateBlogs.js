import React,{useEffect,useState} from 'react'
import Fab from '@mui/material/Fab';
import AddIcon from '@mui/icons-material/Add';
import { useNavigate } from 'react-router-dom';
import BasicCard from './BasicCard';
const PrivateBlogs = () => {
    const [blogs,setBlogs]=useState();
    const navigate = useNavigate();
    const goToEditor = () => {
    navigate(`/editor`);
    };

    useEffect(()=>{
        fetchArticle()
    },[])
    const fetchArticle = async () => {
        const token = localStorage.getItem('token');
        try {
          const response = await fetch(`http://localhost:8080/getallbyuser`, {
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
           <Fab color="primary" aria-label="add">
        <AddIcon  onClick={()=>goToEditor()} />
      </Fab>
      <br/>
      <br/>
      {
            blogs ?
            <>
                  {blogs.map(blog =>
        <div>
           <BasicCard data={blog}/>
        </div>
        )}
            </> : <>no blogs yet</>
        }
    </div>
  )
}

export default PrivateBlogs