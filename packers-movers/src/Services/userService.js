export const signin = async (email, password) => {
  if (email === "user@example.com" && password === "password123") {
    return { id: "1", fullName: "John Doe" };
  }
  throw new Error("Invalid user");
};