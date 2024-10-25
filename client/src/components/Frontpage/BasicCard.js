import  React from 'react';
import Box from '@mui/material/Box';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import CardHeader from '@mui/material/CardHeader';
import { useNavigate } from 'react-router-dom';
import Stack from '@mui/material/Stack';


export default function BasicCard(prop) {
  const navigate = useNavigate();

  let data = prop.data;

  function formatToDateOnly(dateString) {
    // Convert the string to a Date object
    const date = new Date(dateString);

    // Check if date is valid
    if (isNaN(date)) {
        console.error("Invalid date format");
        return null;
    }

    // Format to "YYYY-MM-DD"
    const year = date.getUTCFullYear();
    const month = String(date.getUTCMonth() + 1).padStart(2, '0'); // Months are zero-based
    const day = String(date.getUTCDate()).padStart(2, '0');

    return `${year}-${month}-${day}`;
}


const goToEditor = (uuid) => {

  navigate(`/editor/?articleId=${uuid}`);

};

const deleteblog = (id) => {
  const token = localStorage.getItem('token');
  const requestOptions = {
    method: 'DELETE',
    headers: {
        'Authorization': `Bearer ${token}`,
        'My-Custom-Header': 'foobar'
    }
};
fetch(`http://localhost:8080/delete/?blogid=${id}`, requestOptions)
    .then(res => res.text())
    .then(data => alert(data))
};


  console.log(typeof data.publishedAt)
  return (
    <Card sx={{ minWidth: 275,maxWidth: 500,margin:2,padding: 2  }}>

  <Typography variant="body1">
  Title : { data.title.toUpperCase() }
  </Typography>


      <CardContent>
        <Typography variant="body2">
        Description : {data.description}
        </Typography>
{

data.published ?


        <Typography variant="body2" component="div">
        Published at  : {formatToDateOnly(data.lastUpdateAt)}
        </Typography>

        :
        <Typography variant="body2" component="div">
        Last Updated at  : {formatToDateOnly(data.lastUpdateAt)}
        </Typography>

}

      </CardContent>

      <Stack spacing={2} direction="row">
      <CardActions>
        <Button size="small" variant='contained' onClick={()=>goToEditor(data.uuid)}>View</Button>
      </CardActions>
      <CardActions>
        <Button onClick={()=>deleteblog(data.uuid)} size="small" variant='contained' color='secondary'>delete</Button>
      </CardActions>
      </Stack>
    </Card>
  );
}
