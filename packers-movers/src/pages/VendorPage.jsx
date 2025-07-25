import React from "react";
import Headerh from "../components/Headerh";
import Footer from "../components/Footer";

import VendorRegister from "../components/VendorRegister";
export default function VendorPage(){
    return(
        <div className="register_page">
       <Headerh/>
       <VendorRegister/>
       <Footer/>
        </div>
    )
}