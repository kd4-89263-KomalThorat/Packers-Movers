
import { config } from "./Services/config"
export const formatCurrency = (amount) => {
  return new Intl.NumberFormat('en-IN', {
    style: 'currency',
    currency: 'INR'
  }).format(amount);
};

// export const createUrl = (endpoint) => {
//   const baseUrl = "http://localhost:8080"; // replace with your actual base URL
//   return `${baseUrl}/${endpoint}`;
// };

export const createUrl = (endpoint) => {
  // const baseUrl = "http://localhost:8080"; // replace with your actual base URL
  return `${config.serverUrl}/${endpoint}`;
};
