import { Routes, Route } from "react-router-dom";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import './App.css';

// General Pages
import HomePage from "./Pages/HomePage";
import ContactPage from "./Pages/RegisterPage";
import RegisterPage from "./Pages/Register";
import LoginPage from "./Pages/Login";
import VendorRegister from "./Pages/Vregister";

// Service Management Pages
// import ServicePage from "./pages/ServiceSum";
// import VendorCompares from "./pages/VendorComp";
// import GetQuot from "./pages/GetQuatation";
// import SelectService from "./pages/SelectService";
// import ServiceRequest from "./pages/ServiceRequestsTable ";

// Vendor Routes
// import AddService from "./pages/AddService";
// import AddServiceWithPrice from "./pages/AddServicewithPrice";
// import EditVS from "./pages/EditVendorService";
// import MainVendorService from "./pages/MainVendorService";
// import DetailServices from "./pages/VendorServiceDetailsPage";
// import VendorSpecialService from "./pages/VendorSpecialServicesPage";
// import AddSpecialService from "./pages/AddSpecialService";
// import EditSpecialService from "./pages/EditSpecialServicePage";
// import VendorServiceReq from "./pages/VendorServiceRequ";
// import InvoicePage from "./pages/Invoice";
// import Payment from "./pages/Payment";
// import Verify from "./pages/VerifyPayment";
// import PaymentSucess from "./pages/PaymentSucess";

function App() {
  return (
    <div className="App">
      <Routes>
        {/* General Routes */}
        <Route path="/" element={<HomePage />} />
        <Route path="/home" element={<HomePage />} />
        <Route path="/contact" element={<ContactPage />} />
        <Route path="/register" element={<RegisterPage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/vendorregister" element={<VendorRegister />} />
        
        {/* Service Routes */}
        {/* <Route path="/servicesum" element={<ServicePage />} />
        <Route path="/vendor-comparison" element={<VendorCompares />} />
        <Route path="/getquote" element={<GetQuot />} />
        <Route path="/select-services" element={<SelectService />} />
        <Route path="/ServiceRequest" element={<ServiceRequest />} /> */}
        
        {/* Vendor Routes */}
        {/* <Route path="/add-service" element={<AddService />} />
        <Route path="/add-service-with-price" element={<AddServiceWithPrice />} />
        <Route path="/edit-vendor-service/:id" element={<EditVS />} />
        <Route path="/main-vendor-service" element={<MainVendorService />} />
        <Route path="/vendor-service-details/:id" element={<DetailServices />} />
        <Route path="/vendor-special-services" element={<VendorSpecialService />} />
        <Route path="/add-special-service" element={<AddSpecialService />} />
        <Route path="/edit-special-service/:id" element={<EditSpecialService />} />
        <Route path="/vendor-service-requests" element={<VendorServiceReq />} /> */}
        
        {/* Payment Routes */}
        {/* <Route path="/invoice/:id" element={<InvoicePage />} />
        <Route path="/payment" element={<Payment />} />
        <Route path="/verify-payment" element={<Verify />} />
        <Route path="/payment-success" element={<PaymentSucess />} /> */}
      </Routes>
      
      <ToastContainer
        position="top-right"
        autoClose={3000}
        hideProgressBar={false}
        newestOnTop={false}
        closeOnClick
        rtl={false}
        pauseOnFocusLoss
        draggable
        pauseOnHover
        theme="light"
      />
    </div>
  );
}

export default App;

