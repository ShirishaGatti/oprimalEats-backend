import React from 'react'
import './LoginSignUp.css'
import yellowSide from '../../assets/yellow-side1.jpg';



const LoginSignUp = () => {
  return (
    <div class="container">
    <div class="login-box">
        <div class="left">
            <h2><span class="logo">Log In</span> Company</h2>
            {/* <p class="welcome-text">Welcome back</p>
            <p class="desc">This site is for admin members to report every progress of information that has been obtained.</p> */}
            <form>
                <div class="input-group">
                    <input type="email" placeholder="Email" required/>
                </div>
                <div class="input-group">
                    <input type="password" placeholder="Password" required/>
                </div>
                <div class="options">
                    <label><input type="checkbox"/> Remember Me</label>
                    <a href="#">Forgot Password?</a>
                </div>
                <button class="btn">Sign In</button>
            </form>
        </div>
        <div class="right">
            <div class="info-box">
                <img src={yellowSide} alt="Illustration"/>
                 </div>
        </div>
    </div>
</div>
  )
}

export default LoginSignUp