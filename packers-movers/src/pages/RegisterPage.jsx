import React, { useState, useEffect } from "react";

import UserRegisterForm from "../components/UserRegisterForm";
import Footer from "../components/Footer";


import Headerh from "../components/Headerh";
import ContactInfo from "../components/ContactInfo";


export default function RegisterPage() {
  return (
    <div className="register_page">
      <Headerh />
      <ContactInfo/>
      <Footer />
    </div>
  );
}
