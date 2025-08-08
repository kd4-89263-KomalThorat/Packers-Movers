
import { config } from "./services/config"
export const formatCurrency = (amount) => {
  return new Intl.NumberFormat('en-IN', {
    style: 'currency',
    currency: 'INR'
  }).format(amount);
};


export const createUrl = (endpoint) => 
   `${config.serverUrl}/${endpoint}`;
;
