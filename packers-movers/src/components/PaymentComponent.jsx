import React, { useState, useEffect } from "react";
import axios from "axios";
import { config } from "../services/config";
import { useNavigate } from "react-router-dom";

const PaymentComponent = ({ userId, vendorId, totalPrice }) => {
  const [loading, setLoading] = useState(false);
  const [paymentStatus, setPaymentStatus] = useState(null);
  const [errorDetails, setErrorDetails] = useState(null);
  const [razorpayLoaded, setRazorpayLoaded] = useState(false);
  const navigate = useNavigate();

  // Load Razorpay script when component mounts
  useEffect(() => {
    const script = document.createElement("script");
    script.src = "https://checkout.razorpay.com/v1/checkout.js";
    script.async = true;
    script.onload = () => setRazorpayLoaded(true);
    script.onerror = () => {
      console.error("Failed to load Razorpay script");
    };
    document.body.appendChild(script);
  }, []);

  const handlePayment = async () => {
    if (!razorpayLoaded) {
      alert("Payment service is still loading, please try again in a moment.");
      return;
    }

    setLoading(true);
    const localUserId = localStorage.getItem("userId");

    if (!localUserId || !vendorId || !totalPrice) {
      console.error("Invalid input: Missing userId, vendorId, or totalPrice");
      setLoading(false);
      setPaymentStatus("Payment Failed: Missing required data");
      return;
    }

    try {
      const response = await axios.post(
        `${config.serverUrl}/payments/create-order`,
        null,
        {
          params: {
            userId: localUserId,
            vendorId: vendorId,
            amount: totalPrice,
          },
        }
      );

      const { razorpayOrderId, amount, currency } = response.data;

      const options = {
        key: "rzp_test_6mksRbtiWF5CWZ",
        amount: amount ,
        currency: currency,
        name: "Packers & Movers",
        description: "Payment for shifting service",
        order_id: razorpayOrderId,
        handler: async function (response) {
          try {
            const verifyResponse = await axios.get(
              `${config.serverUrl}/verify`,
              {
                params: { paymentId: response.razorpay_payment_id },
              }
            );
            navigate("/payment-success", { state: verifyResponse.data });
            setPaymentStatus("Payment Successful");
          } catch (verifyError) {
            console.error("Error in payment verification:", verifyError);
            setErrorDetails(verifyError.response?.data || "Unknown error");
            setPaymentStatus("Payment Verification Failed");
          }
        },
        prefill: {
          name: "Packers & Movers",
          email: "packersandmovers@sunbeaminfo.com",
          contact: "+911234567890",
        },
        theme: {
          color: "#F37254",
        },
      };

      const rzp1 = new window.Razorpay(options);
      rzp1.open();
    } catch (error) {
      console.error("Error in payment:", error);
      setErrorDetails(error.response?.data || "Unknown error");
      setPaymentStatus("Payment Failed");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div>
      <h2>Payment Details</h2>
      <button
        className="pay-now-btn"
        onClick={handlePayment}
        disabled={loading}
      >
        {loading ? "Processing..." : "Pay Now"}
      </button>
      {paymentStatus && <p>Status: {paymentStatus}</p>}
      {errorDetails && (
        <div style={{ color: "red", marginTop: "10px" }}>
          <h4>Error Details:</h4>
          <pre>{JSON.stringify(errorDetails, null, 2)}</pre>
        </div>
      )}
    </div>
  );
};

export default PaymentComponent;
