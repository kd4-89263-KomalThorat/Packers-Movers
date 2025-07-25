import React from "react";
import Headerh from "../components/Headerh";
import Footer from "../components/Footer";

import VendorRegister from "../components/VendorRegister";
export default function VendorPage(){
    return(
        <div className="register_page">
            <div className="form-container">
       <Headerh/>
       <div style={{ flex: 1, display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
            <VendorRegister/>
        </div>
       <Footer/>
        </div>
        </div>
    )
}