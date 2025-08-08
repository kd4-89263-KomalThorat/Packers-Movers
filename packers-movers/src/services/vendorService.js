import axios from "axios";
import { createUrl } from "../utils";
// import {config} from "../services/config"

export async function registerVendor(vendorData) {
  try {
    const url = createUrl("vendor/register");
    const response = await axios.post(url, vendorData, {
      headers: { "Content-Type": "application/json" },
    });

    console.log("API Response:", response);

    if (response.status === 200 || response.status === 201) {
      return {
        status: "success",
        data: response.data,
        message: "Vendor registered successfully!",
      };
    } else {
      return {
        status: "error",
        error: response.data.message || "Registration failed unexpectedly.",
      };
    }
  } catch (error) {
    console.error("API Error:", error.response);
    return {
      status: "error",
      error: error.response?.data?.message || "Server error occurred.",
    };
  }
}

export async function vendorSignin(email, password) {
  try {
    const url = createUrl("vendor/signin");
    console.log("API URL: ",url);
    const response = await axios.post(url, { email, password });
    return response.data;
  } catch (ex) {
    return {
      status: "error",
      error: ex.response?.data?.message || ex.message,
    };
  }
}