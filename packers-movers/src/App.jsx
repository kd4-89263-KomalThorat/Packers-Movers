import { Routes, Route } from "react-router-dom";
import { ToastContainer } from "react-toastify";
import LoginPage from "./Pages/Login";


function App() {
  return (
    <div className="App">
      <Routes>
         {/* <Route path="/" element={<HomePage />} /> */}
         <Route path="/" element={<LoginPage />} />
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