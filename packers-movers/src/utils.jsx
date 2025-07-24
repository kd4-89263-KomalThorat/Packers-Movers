
export const formatCurrency = (amount) => {
  return new Intl.NumberFormat('en-IN', {
    style: 'currency',
    currency: 'INR'
  }).format(amount);
};

export const createUrl = (endpoint) => {
  const baseUrl = "https://localhost:5173"; // replace with your actual base URL
  return `${baseUrl}/${endpoint}`;
};
