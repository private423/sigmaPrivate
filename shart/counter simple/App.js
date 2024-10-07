import './App.css';
import React from 'react';

const {useState} = React;

function App() {
  const[count,setCount] = useState(0);

  return (
    <div className="App">
      <h1 className={count <0 ? "positive" : count>0 ?  "negative" : null } >{count}</h1>
      <div className="button__wrapper">
        <button onClick={()=>setCount(count-1)}>-</button>
        <button onClick={()=>setCount(count+1)}>+</button>
      </div>
    </div>
  );
}

export default App;
