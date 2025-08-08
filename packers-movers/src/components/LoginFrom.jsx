import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { signin } from "../services/userService";
import { vendorSignin } from "../services/vendorService";
import { toast } from "react-toastify";

const LoginForm = () => {
  const [formData, setFormData] = useState({ email: "", password: "" });
  const [errors, setErrors] = useState({});
  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({ ...prev, [name]: value }));
  };

  const validateForm = () => {
    const errs = {};
    if (!formData.email) errs.email = "Email is required";
    else if (!/\S+@\S+\.\S+/.test(formData.email)) errs.email = "Email is invalid";

    if (!formData.password) errs.password = "Password is required";
    else if (formData.password.length < 6)
      errs.password = "Password must be at least 6 characters long";

    return errs;
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const formErrors = validateForm();
    if (Object.keys(formErrors).length) {
      setErrors(formErrors);
      toast.error("Please fix errors.");
      return;
    }

    // Try USER login first
    try {
      const userResponse = await signin(formData.email, formData.password);
      console.log("User Response:", userResponse);

      if (userResponse && userResponse.id) {
        toast.success("Login successful as Customer!");
        sessionStorage.setItem("userName", userResponse.fullName);
        localStorage.setItem("userId", userResponse.id);
        navigate("/getquote");
        return;
      }
    } catch (err) {
      console.error("User login failed, trying vendor...");
    }

    // Then try VENDOR login
    try {
      const vendorResponse = await vendorSignin(formData.email, formData.password);
      console.log("Vendor Response:", vendorResponse);

      if (vendorResponse && vendorResponse.id) {
  toast.success("Login successful as Vendor!");
  sessionStorage.setItem("vendorName", vendorResponse.bussinessName);
  localStorage.setItem("vendorId", vendorResponse.id);
  navigate("/vendor-service-requests"); 
  return;
}
else {
        toast.error("Invalid credentials.");
      }
    } catch (err) {
      toast.error("Vendor login failed or server error.");
    }
  };

  return (
    <div className="form-container">
      <h2>Login</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Email</label>
          <input
            name="email"
            value={formData.email}
            onChange={handleChange}
            placeholder="Enter email"
          />
          {errors.email && <span className="error">{errors.email}</span>}
        </div>
        <div className="form-group">
          <label>Password</label>
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
