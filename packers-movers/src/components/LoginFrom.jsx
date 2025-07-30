// // import React, { useState } from "react";
// // import { useNavigate } from "react-router-dom";
// // import { signin } from "../services/userService";
// // import { vendorSignin } from "../services/vendorService";
// // import { toast } from "react-toastify";

// // const LoginForm = () => {
// //   const [formData, setFormData] = useState({
// //     email: "",
// //     password: "",
// //   });

// //   const [errors, setErrors] = useState({});
// //   const navigate = useNavigate();

// //   const handleChange = (e) => {
// //     const { name, value } = e.target;
// //     setFormData((prevData) => ({
// //       ...prevData,
// //       [name]: value,
// //     }));
// //   };

// //   const validateForm = () => {
// //     let formErrors = {};
// //     if (!formData.email) formErrors.email = "Email is required";
// //     else if (!/\S+@\S+\.\S+/.test(formData.email))
// //       formErrors.email = "Email is invalid";

// //     if (!formData.password) formErrors.password = "Password is required";
// //     else if (formData.password.length < 6)
// //       formErrors.password = "Password must be at least 6 characters long";

// //     return formErrors;
// //   };

// //   const handleSubmit = async (e) => {
// //     e.preventDefault();
// //     const formErrors = validateForm();

// //     if (Object.keys(formErrors).length !== 0) {
// //       setErrors(formErrors);
// //       toast.error("Please fix the errors before submitting.");
// //       return;
// //     }

// //     try {
// //       // Attempt User Login
// //       const userResponse = await signin(formData.email, formData.password);
// //       console.log("User Response:", userResponse);

// //       if (userResponse && userResponse.id) {
// //         // ✅ Successful User Login
// //         toast.success("Login successful as Customer!");
// //         sessionStorage.setItem("userName", userResponse.fullName);
// //         localStorage.setItem("userId", userResponse.id);
// //         navigate("/getquote");
// //         return; // Exit function if user login is successful
// //       }
// //     } catch (error) {
// //       console.log("User login failed, trying vendor login...");
// //     }

// //     // If User login fails, try Vendor login
// //     try {
// //       const vendorResponse = await vendorSignin(
// //         formData.email,
// //         formData.password
// //       );
// //       console.log("Vendor Response:", vendorResponse);

// //       if (vendorResponse && vendorResponse.id) {
// //         // ✅ Successful Vendor Login
// //         toast.success("Login successful as Vendor!");
// //         sessionStorage.setItem("vendorName", vendorResponse.bussinessName);
// //         localStorage.setItem("vendorId", vendorResponse.id);
// //         navigate("/vendor-Service-request");
// //         return; // Exit function if vendor login is successful
// //       } else {
// //         toast.error("Invalid credentials.");
// //       }
// //     } catch (error) {
// //       console.error("Vendor Login Error:", error);
// //       toast.error("Invalid credentials or server error.");
// //     }
// //   };

// //   return (
// //     <div className="form-container">
// //       <h2>Login</h2>
// //       <form onSubmit={handleSubmit}>
// //         <div className="form-group">
// //           <label htmlFor="email">Email</label>
// //           <input
// //             type="email"
// //             id="email"
// //             name="email"
// //             value={formData.email}
// //             onChange={handleChange}
// //             placeholder="Enter your email"
// //           />
// //           {errors.email && <span className="error">{errors.email}</span>}
// //         </div>

// //         <div className="form-group">
// //           <label htmlFor="password">Password</label>
// //           <input
// //             type="password"
// //             id="password"
// //             name="password"
// //             value={formData.password}
// //             onChange={handleChange}
// //             placeholder="Enter your password"
// //           />
// //           {errors.password && <span className="error">{errors.password}</span>}
// //         </div>

// //         <button type="submit">Login</button>
// //       </form>
// //     </div>
// //   );
// // };

// // export default LoginForm;
// import React, { useState } from "react";
// import { useNavigate } from "react-router-dom";
// import { signin } from "../services/userService";
// import { vendorSignin } from "../services/vendorService";
// import { toast } from "react-toastify";

// const LoginForm = () => {
//   const [formData, setFormData] = useState({
//     email: "",
//     password: "",
//   });

//   const [errors, setErrors] = useState({});
//   const navigate = useNavigate();

//   const handleChange = (e) => {
//     const { name, value } = e.target;
//     setFormData((prevData) => ({
//       ...prevData,
//       [name]: value,
//     }));
//   };

//   const validateForm = () => {
//     let formErrors = {};
//     if (!formData.email) formErrors.email = "Email is required";
//     else if (!/\S+@\S+\.\S+/.test(formData.email))
//       formErrors.email = "Email is invalid";

//     if (!formData.password) formErrors.password = "Password is required";
//     else if (formData.password.length < 6)
//       formErrors.password = "Password must be at least 6 characters long";

//     return formErrors;
//   };

//   const handleSubmit = async (e) => {
//     e.preventDefault();
//     const formErrors = validateForm();

//     if (Object.keys(formErrors).length !== 0) {
//       setErrors(formErrors);
//       toast.error("Please fix the errors before submitting.");
//       return;
//     }

//     let loginSuccess = false;

//     try {
//       // Attempt User Login
//       const userResponse = await signin(formData.email, formData.password);
//       console.log("User Response:", userResponse);

//       if (userResponse && userResponse.id) {
//         // ✅ Successful User Login
//         toast.success("Login successful as Customer!");
//         sessionStorage.setItem("userName", userResponse.fullName);
//         localStorage.setItem("userId", userResponse.id);
//         navigate("/getquote");
//         loginSuccess = true;
//       } else if (userResponse && userResponse.message) {
//         // Backend returned an error message for user login
//         toast.error(User Login Failed: ${userResponse.message});
//       } else {
//         // Generic error for user login
//         toast.error("User Login Failed: Unknown error.");
//       }
//     } catch (error) {
//       console.error("User Login Error:", error);
//       // Only try vendor login if user login explicitly failed due to credentials
//       // or if it's a network error that might affect both
//       if (error.response && error.response.status === 400) {
//         // Bad request, likely invalid credentials from backend
//         toast.error("User Login Failed: Invalid credentials.");
//       } else {
//         toast.error("User Login Failed: Server error or network issue.");
//       }
//     }

//     if (loginSuccess) return;

//     // If User login fails, try Vendor login
//     try {
//       const vendorResponse = await vendorSignin(
//         formData.email,
//         formData.password
//       );
//       console.log("Vendor Response:", vendorResponse);

//       if (vendorResponse && vendorResponse.id) {
//         // ✅ Successful Vendor Login
//         toast.success("Login successful as Vendor!");
//         sessionStorage.setItem("vendorName", vendorResponse.bussinessName);
//         localStorage.setItem("vendorId", vendorResponse.id);
//         navigate("/vendor-Service-request");
//         loginSuccess = true;
//       } else if (vendorResponse && vendorResponse.message) {
//         // Backend returned an error message for vendor login
//         toast.error(Vendor Login Failed: ${vendorResponse.message});
//       } else {
//         // Generic error for vendor login
//         toast.error("Vendor Login Failed: Unknown error.");
//       }
//     } catch (error) {
//       console.error("Vendor Login Error:", error);
//       if (error.response && error.response.status === 400) {
//         // Bad request, likely invalid credentials from backend
//         toast.error("Vendor Login Failed: Invalid credentials.");
//       } else {
//         toast.error("Vendor Login Failed: Server error or network issue.");
//       }
//     }

//     if (!loginSuccess) {
//       toast.error("Login failed for both user and vendor. Please check your credentials.");
//     }
//   };

//   return (
//     <div className="form-container">
//       <h2>Login</h2>
//       <form onSubmit={handleSubmit}>
//         <div className="form-group">
//           <label htmlFor="email">Email</label>
//           <input
//             type="email"
//             id="email"
//             name="email"
//             value={formData.email}
//             onChange={handleChange}
//             placeholder="Enter your email"
//           />
//           {errors.email && <span className="error">{errors.email}</span>}
//         </div>

//         <div className="form-group">
//           <label htmlFor="password">Password</label>
//           <input
//             type="password"
//             id="password"
//             name="password"
//             value={formData.password}
//             onChange={handleChange}
//             placeholder="Enter your password"
//           />
//           {errors.password && <span className="error">{errors.password}</span>}
//         </div>

//         <button type="submit">Login</button>
//       </form>
//     </div>
//   );
// };

// export default LoginForm;

import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";

const LoginForm = () => {
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    email: "",
    password: "",
  });

  const [errors, setErrors] = useState({});

  // Dummy static users
  const dummyUsers = [
    {
      email: "customer@example.com",
      password: "customer123",
      role: "CUSTOMER",
      name: " Customer",
    },
    {
      email: "vendor@example.com",
      password: "vendor123",
      role: "VENDOR",
      name: " Vendor",
    },
  ];

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const validateForm = () => {
    let formErrors = {};
    if (!formData.email) formErrors.email = "Email is required";
    if (!formData.password) formErrors.password = "Password is required";
    return formErrors;
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const formErrors = validateForm();
    if (Object.keys(formErrors).length !== 0) {
      setErrors(formErrors);
      toast.error("Please fill in all fields.");
      return;
    }

    // Match against dummy users
    const matchedUser = dummyUsers.find(
      (user) =>
        user.email === formData.email && user.password === formData.password
    );

    if (matchedUser) {
     toast.success(`Welcome ${matchedUser.name}`);

      localStorage.setItem("currentUser", JSON.stringify(matchedUser));

      if (matchedUser.role === "CUSTOMER") {
        navigate("/customer-dashboard");
      } else if (matchedUser.role === "VENDOR") {
        navigate("/vendor-dashboard");
      }
    } else {
      toast.error("Invalid credentials. Try again.");
    }
  };

  return (
    <div className="form-container">
      <h2>Login</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Email:</label>
          <input
            name="email"
            value={formData.email}
            onChange={handleChange}
            placeholder="Enter email"
          />
          {errors.email && <span className="error">{errors.email}</span>}
        </div>

        <div className="form-group">
          <label>Password:</label>
          <input
            name="password"
            type="password"
            value={formData.password}
            onChange={handleChange}
            placeholder="Enter password"
          />
          {errors.password && <span className="error">{errors.password}</span>}
        </div>

        <button type="submit">Login</button>
      </form>
    </div>
  );
};

export default LoginForm;