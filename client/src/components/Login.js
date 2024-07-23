import React, { useState } from 'react'

const Login = () => {
    const [email,setEmail]=useState()
    const [password,setPassword]=useState()
    const login=()=>{
      let  responcebody = {
            email:email,
            password:password
        }
        fetch()

    }

  return (
    <>

     <div>Login</div>
     <p>email :</p>  <input onChange={(e)=>setEmail(e.target.value)}/>
     <p>password :</p>  <input onChange={(e)=>setPassword(e.target.value)}/>
<button>sign in</button>
    </>


  )
}

export default Login