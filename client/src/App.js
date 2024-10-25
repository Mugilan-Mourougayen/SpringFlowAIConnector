
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Login from './components/Login/Login';
import Signup from './components/Signup/Signup';
import Editor from './components/Editor/Editor';
import PrivateRoute from './components/Auth/PrivateRoute';

function App() {
  return (
    <Router>
      <div>
        <Routes>
          <Route path="/login" element={<Login />} />
          <Route path="/signup" element={<Signup />} />
          <Route element={<PrivateRoute />}>
                    <Route path="/editor" element={<Editor />} />
                </Route>

        </Routes>
      </div>
    </Router>
  );
}

export default App;
