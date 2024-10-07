import "./Accordion.css";
import { useState,useRef } from "react";
import Chevron from "./Chevron";

const Accordion = (props) => {

  const [setActive , setActiveState]=useState("");
  const [setHeight, setHeightState] = useState("0px");
  const [setRotate, setRotateState] = useState("accordion)__icon");

  const content = useRef(null);

  function toggleAccordion(){
    setActiveState(setActive === "" ? "active" : "");
    setHeightState(
      setActive === "active" ? "0px" : `${content.current.scrollHeight}px`
    );

    setRotateState(setActive === "active" ? "accordion__icon" : "accordion__icon rotate");

    console.log(content.current.scrollHeight);
  }
  return (
    <div className="accordion_section">
      <button className={`accordion ${setActive}`} onClick={toggleAccordion}>
        <p className="accordion_title">{props.title}</p>
        <Chevron className={`${setRotate}`} width={10} fill={"#777"} />
      </button>
      <div ref={content} style={{maxHeight: `${setHeight}`}} className="accordion_content">
        <div  
            className="accordion_text"  
            dangerouslySetInnerHTML={{ __html:props.content}}
        />

       
      </div>
      
    </div>
  )
}

export default Accordion
