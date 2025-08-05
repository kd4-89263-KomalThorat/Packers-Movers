import axios from "axios";
import { createUrl } from "../utils";
import { config } from '../Services/config';

// const config = "http://localhost:8080";

export async function createUser(userData) {
  try {
    const url = createUrl(`/users/signup`);
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
    const body = { email, password };
    // const url = createUrl(`${config}/users/signin`);
    const response = await axios.post(`${config}/users/signin`, body);
    return response.data;
  } catch (ex) {
    return {
      status: "error",
      error: ex.response ? ex.response.data.message : ex.message,
    };
  }
}


