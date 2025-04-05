import { myAxios } from "./helper";
export const SignIn=async(admin)=>{
    try {
        const response=await  myAxios.post("/admin/login",admin,{
        headers:{
            'Content-Type':'application/json',
        },
        withCredentials: true
    });
    return response;
  } catch (error) {
      console.error("Error during sign-in:", error);
      throw error;  // You can handle or rethrow the error as needed
}
}