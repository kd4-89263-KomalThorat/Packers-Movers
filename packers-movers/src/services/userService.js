import axios from "axios";
import { createUrl } from "../utils";
// import { config } from '../services/config';

export async function createUser(userData) {
  try {
    const url = createUrl("users/signup");
    const response = await axios.post(url, userData, {
      headers: { "Content-Type": "application/json" },
    });

    return response.data?.status === "success"
      ? { status: "success", data: response.data }
      : { status: "error", error: response.data.message || "Unknown error" };
  } catch (error) {
    return {
      status: "error",
      error: error.response?.data?.message || error.message,
    };
  }
}

export async function signin(email, password) {
  try {
    const url = createUrl("users/signin");
    const response = await axios.post(url, { email, password });
    return response.data;
  } catch (ex) {
    return {
      status: "error",
      error: ex.response?.data?.message || ex.message,
    };
  }
}
