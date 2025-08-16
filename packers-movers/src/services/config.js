
// export const config = {
//   serverUrl: "http://localhost:8080" 
// };

import axios from "axios";

const serverUrl = "http://localhost:8080";

// ✅ create axios instance
const api = axios.create({
  baseURL: serverUrl,
});

// ✅ attach JWT token automatically
api.interceptors.request.use((req) => {
  const token = localStorage.getItem("token");
  if (token) {
    req.headers.Authorization = `Bearer ${token}`;
  }
  return req;
});

export const config = {
  serverUrl,
  api,
};
