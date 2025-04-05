// import React from 'react'
// import './LoginSignUp.css'
// import yellowSide from '../../assets/yellow-side1.jpg';
// //import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
// import { useNavigate } from 'react-router-dom';


// const LoginSignUp = () => {
//   return (
//     <div class="container">
//     <div class="login-box">
//         <div class="left">
//             <h2><span class="logo">Log In</span> Company</h2>
//             {/* <p class="welcome-text">Welcome back</p>
//             <p class="desc">This site is for admin members to report every progress of information that has been obtained.</p> */}
//             <form>
//                 <div class="input-group">
//                     <input type="email" placeholder="Email" required/>
//                 </div>
//                 <div class="input-group">
//                     <input type="password" placeholder="Password" required/>
//                 </div>
//                 <div class="options">
//                     <label><input type="checkbox"/> Remember Me</label>
//                     <a href="#">Forgot Password?</a>
//                 </div>
//                 <button class="btn">Sign In</button>
//             </form>
//         </div>
//         <div class="right">
//             <div class="info-box">
//                 <img src={yellowSide} alt="Illustration"/>
//                  </div>
//         </div>
//     </div>
// </div>
//   )
// }

// export default LoginSignUp

import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './LoginSignUp.css';
import yellowSide from '../../assets/yellow-side1.jpg';
import { SignIn } from '../../services/admin-service'; 
import axios from "axios";

const LoginSignUp = () => {
    const [contactNo, setContactNo] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const navigate = useNavigate();

    const setAdminSession = (adminData) => {
        sessionStorage.setItem("adminId", adminData.adminId);
        sessionStorage.setItem("adminName", adminData.name);
    };

    const handleLogin = async (e) => {
        e.preventDefault();

        if (!contactNo || !/^\d{10}$/.test(contactNo)) {
            setError("Please enter a valid 10-digit contact number.");
            return;
        }
        if (!password) {
            setError("Please enter your password.");
            return;
        }
        const data = { adminContact: contactNo, password: password };

        // Log the data format before making the request
        console.log("Sending Data Format:", JSON.stringify(data, null, 2));
    
        try {
            const data = { adminContact: contactNo, password: password };

            const response = await SignIn(data);
            console.log("Login :", response.data);

            console.log("Login successful:", response.data);

            setAdminSession(response.data);
            navigate('/dashboard');
        } catch (error) {
            console.error("Login failed:",error);
            setError(error.response?.data?.error || "Invalid credentials. Please try again.");
        }
    };

    return (
        <div className="container">
            <div className="login-box">
                <div className="left">
                    <h2><span className="logo">Log In</span> Company</h2>

                    {error && <p className="error-message">{error}</p>}

                    <form onSubmit={handleLogin}>
                        <div className="input-group">
                            <input 
                                type="text" 
                                placeholder="Contact Number" 
                                value={contactNo} 
                                onChange={(e) => setContactNo(e.target.value)}
                                required 
                            />
                        </div>
                        <div className="input-group">
                            <input 
                                type="password" 
                                placeholder="Password" 
                                value={password} 
                                onChange={(e) => setPassword(e.target.value)}
                                required 
                            />
                        </div>
                        <div className="options">
                            <label>
                                <input type="checkbox"/> Remember Me
                            </label>
                            <a href="#">Forgot Password?</a>
                        </div>
                        <button type="submit" className="btn">Sign In</button>
                    </form>
                </div>
                <div className="right">
                    <div className="info-box">
                        <img src={yellowSide} alt="Illustration" />
                    </div>
                </div>
            </div>
        </div>
    );
};

export default LoginSignUp;
