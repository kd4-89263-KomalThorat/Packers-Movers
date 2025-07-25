import { useState } from 'react'

import './App.css'
import {Routes,Route} from 'react-router-dom';
import RegisterPage from './pages/Registerpage';
import { ToastContainer } from 'react-toastify';

import VendorPage from './pages/VendorPage';

function App() {
  const [count, setCount] = useState(0)

  return (
   < div className="App">
    <Routes>
      {/* { <Route path="/register" element={<RegisterPage/>}/> } */}
      <Route path='/' element={<VendorPage/>}/>
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

export default App
