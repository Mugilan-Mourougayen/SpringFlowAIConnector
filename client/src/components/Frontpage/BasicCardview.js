import  React from 'react';
import Box from '@mui/material/Box';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import CardHeader from '@mui/material/CardHeader';
import { useNavigate } from 'react-router-dom';

import Avatar from '@mui/material/Avatar';

const bull = (
  <Box
    component="span"
    sx={{ display: 'inline-block', mx: '2px', transform: 'scale(0.8)' }}
  >
    •
  </Box>
);

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


const goToViewer = (uuid) => {

  navigate(`/viewer/?articleId=${uuid}`);

};


  console.log(typeof data.publishedAt)
  return (
    <Card sx={{ minWidth: 275,maxWidth: 500,margin:2,padding: 2 }}>
        <CardHeader
        avatar={
          <Avatar  >
            {data.userName.charAt(0)}
          </Avatar>
        }


        title={`Title : `+ data.title}
      />
      <CardContent>

        <Typography variant="body2" component="div">
        published at :{ formatToDateOnly(data.publishedAt)}
        </Typography>
        <Typography variant="body2" component="div">
        Published By : {data.userName}
        </Typography>

        <Typography variant="body2">
       Description : {data.description}
        </Typography>
      </CardContent>
      <CardActions>
        <Button variant='contained' size="small" onClick={()=>goToViewer(data.uuid)}>View</Button>
      </CardActions>

    </Card>
  );
}
