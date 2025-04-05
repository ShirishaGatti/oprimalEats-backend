import React from 'react'
import './LoginSignUp.css'
import yellowSide from '../../assets/yellow-side1.jpg';



const LoginSignUp = () => {
  return (
    <div class="main-container">
    <div class="login-box">
        <div class="left">
            <h2><span class="logo">Log In</span> Company</h2>
            {/* <p class="welcome-text">Welcome back</p>
            <p class="desc">This site is for admin members to report every progress of information that has been obtained.</p> */}
            <form>
            <div class="input-group">
                    
                    <input type="text" placeholder='Email'required/>
                </div>
            <div class="input-group">
                    <input type="text" placeholder='Mess Name' required/>
                </div>

                <div class="input-group">
                    <input type="text" placeholder='Admin Name'required/>
                </div>

                <div class="input-group">
                    <input type="text" required placeholder='contact'/>
                </div>

                <div class="input-group">
                    
                    <input type="text" placeholder='Address'required/>
                </div>

                <div class="input-group">
                    <input type="number" placeholder='Amount Per Plate'required/>
                </div>
                <div class="input-group">
                    <input type="text" placeholder='Timming' required/>
                </div>

                <div class="input-group">
                    <input type="text" placeholder='Rules'required/>
                </div>

                <div class="input-group">
                    <input type="text" required placeholder='Password'/>
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