import React from "react";
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

import Home from "./components/Home.jsx"
import AdminLogin from "./components/admin/Login.jsx"
import signUp from "./components/admin/SignUp.jsx"
function App() {
  return (
    <>
      <Router>
        <Routes>
          <Route exact path="/" element={<Home/>}/>
          <Route exact path="/admin-login" element={<AdminLogin/>}/>
          <Route exact path="/admin-reg" element={<signUp/>}/>

          
        </Routes>
      </Router>
    
    </>
  );
}

export default App;
