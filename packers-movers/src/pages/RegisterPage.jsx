import React, { useState, useEffect } from "react";

import UserRegisterForm from "../components/UserRegisterForm";
import Footer from "../components/Footer";


import Headerh from "../components/Headerh";


export default function RegisterPage() {
  return (
    <div className="register_page">
      <Headerh />
      <div style={{ flex: 1, display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
        <UserRegisterForm />
      </div>
      <Footer />
    </div>
  );
}
