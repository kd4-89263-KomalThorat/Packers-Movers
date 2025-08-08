import React from "react";
import { Carousel } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";

// import Slide1 from "../assets/packers-and-movers-indiranagar.png";
// import Slide2 from "../assets/packers-movers-charges-banner.jpg";

import Slide1 from "../assets/slider4.jpg";
import Slide2 from "../assets/vendor2.jpg";

export default function HeroCarousel() {
  return (
    <Carousel fade>
      <Carousel.Item interval={2500}>
        <img className="d-block w-100 hero-carousel-img" src={Slide1} alt="First Slide" />
      </Carousel.Item>
      <Carousel.Item interval={2000}>
        <img className="d-block w-100 hero-carousel-img" src={Slide2} alt="Second Slide" />
      </Carousel.Item>
    </Carousel>
  );
}
