//import logo from './logo.svg';
import './App.css';
import {React, useState } from 'react'

function App() {
  const [counter, setCounter] = useState(0);

  const increase = () => {
    setCounter(count => count+1);
  };

  const decrease = () => {
    setCounter(count => count-1);
  };

  const reset = () => {
    setCounter(0);
  }

  return (
    <div className="counter">
      <h1>React Counter</h1>
      <span className="counter_output">{counter}</span>
      <div className="btn_conatiner">
        <button className="control_btn" onClick={increase}>+</button>
        <button className="control_btn" onClick={decrease}>-</button>
        <button className="reset" onClick={reset}>Reset</button>
      </div>
    </div>
  );
}

export default App;
