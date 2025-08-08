import AOS from "aos";

import ContactUsBannerImg from "../assets/packers-movers-charges-banner[1].jpg";

import "aos/dist/aos.css";
AOS.init();

export default function ContactInfo() {
  return (
    <div className="contact_info">
      <img src={ContactUsBannerImg} alt="ContactUsBannerImg" className="contact-banner-img" width="70%" />
    </div>
  );
}
